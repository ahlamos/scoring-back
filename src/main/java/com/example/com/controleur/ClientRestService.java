package com.example.com.controleur;

import com.example.com.configuration.DroolsUtility;
import com.example.com.dao.*;
import com.example.com.entities.*;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ClientRestService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private InfoClientRepository infoClientRepository;
    @Autowired
    private SegementRepository segementRepository;
    @Autowired
    private DemandeCreditRepository demandeCreditRepository;
    @RequestMapping(value="/calculerScore/{id}",method= RequestMethod.PATCH)
    public Client CalculerScore(@PathVariable(name="id") Long id, @RequestBody String tauxEndettement) throws Exception {
        Client client = clientRepository.findById(id).get();
        client.setScore(0);
        double score=calculateScore(client);
        Notation notation=getNotationFromScore(score);
        client.setNotation(notation);
        client.getInfoClient().setTauxEndettement(Double.parseDouble(tauxEndettement));
        DemandeCredit demandeCredit=new DemandeCredit(new Date());
        List<DemandeCredit> demandeCredits = new ArrayList<DemandeCredit>();
        demandeCredits=client.getDemandeCredits();
        demandeCredits.add(demandeCredit);
        demandeCreditRepository.save(demandeCredit);
        client.setDemandeCredits(demandeCredits);
         return clientRepository.save(client);

    }
    public double calculateScore(Client client) throws Exception {
        List<Rule> rules = ruleRepository.findAll();
        DroolsUtility utility = new DroolsUtility();
        StatelessKieSession session = utility.loadSession(rules, "drools/templates/Client.drl");		//Define the products to be processed using our rules
        session.setGlobal("client", client);
        session.execute(client);
        return client.getScore();


    }
    public Notation getNotationFromScore(double score) throws Exception{
        List<Segment> segments=segementRepository.findAll();
        Notation notation=new Notation();
        for(Segment segment:segments) if(segment.getDebut()<score && segment.getFin()>score) notation=segment.getNotation();
        return notation;
    }

    @RequestMapping(value="/majClient/{id}",method= RequestMethod.PATCH)
    public void majClient(@PathVariable(name="id") Long id, @RequestBody Informations informations) throws Exception {
        Client client = clientRepository.findById(id).get();
        client.setCIN(informations.getCIN());client.setCivilite(informations.getCivilite());client.setEmail(informations.getEmail());
        client.setNom(informations.getNom());client.setTelephone(informations.getTelephone());client.setDateNaissance(informations.getDateNaissance());

        InfoClient infoClient = client.getInfoClient();
        infoClient.setAdresse(informations.getAdresse());

        infoClientRepository.save(infoClient);
        clientRepository.save(client);
    }


    @RequestMapping(value="/ajouterClient",method= RequestMethod.POST)
    public void AjouterClient(@RequestBody Informations informations) throws Exception {
        InfoClient infoClient=new InfoClient();
        infoClient.setAdresse(informations.getAdresse());
        Client client=new Client(informations.getNom(), informations.getCivilite(), informations.getTelephone(), informations.getEmail(), informations.getCIN(), informations.getDateNaissance());
        client.setInfoClient(infoClient);
        infoClientRepository.save(infoClient);
        clientRepository.save(client);
    }

    @RequestMapping(value="findClient/{CIN}",method= RequestMethod.GET)
    public Client findClientByCIN(@PathVariable(name="CIN") String CIN) throws Exception {
        Client resultat=new Client();
        List<Client> clients=clientRepository.findAll();
        for(Client client:clients){
            if(client.getCIN()==CIN){
                resultat.setId(client.getId());
                resultat.setNom(client.getNom());
                resultat.setCivilite(client.getCivilite());
                resultat.setTelephone(client.getTelephone());
                resultat.setEmail(client.getEmail());
                resultat.setCIN(client.getCIN());
                resultat.setDateNaissance(client.getDateNaissance());
            }
        }
        return resultat;

    }






}
