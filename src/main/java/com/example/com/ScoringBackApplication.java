package com.example.com;

import com.example.com.configuration.DroolsUtility;
import com.example.com.dao.*;
import com.example.com.entities.*;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ScoringBackApplication implements CommandLineRunner {

    @Autowired
    private ConditionRepository conditionRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private InfoClientRepository infoClientRepository;
    @Autowired
    private NotationRepository notationRepository;
    @Autowired
    private SegementRepository segementRepository;
    @Autowired
    private DemandeCreditRepository demandeCreditRepository;
    public static void main(String[] args) {
        SpringApplication.run(ScoringBackApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Rule> rules = new ArrayList<Rule>();


        Rule rule1=new Rule("projetAuto");
        Conditions projetAuto=new Conditions();
        projetAuto.setProperty("infoClient.natureProjet");
        projetAuto.setOperation("Equal to");
        projetAuto.setValue("Auto");
        conditionRepository.save(projetAuto);
        rule1.setConditions(Arrays.asList(projetAuto));
        rule1.setAction("20");
        rules.add(rule1);

        Rule rule2=new Rule("projetImmo");
        Conditions projetImmo=new Conditions();
        projetImmo.setProperty("infoClient.natureProjet");
        projetImmo.setOperation("Equal to");
        projetImmo.setValue("Immobilier");
        conditionRepository.save(projetImmo);
        rule2.setConditions(Arrays.asList(projetImmo));
        rule2.setAction("10");
        rules.add(rule2);

        Rule rule3=new Rule("projetTravaux");
        Conditions projetTravaux=new Conditions();
        projetTravaux.setProperty("infoClient.natureProjet");
        projetTravaux.setOperation("Equal to");
        projetTravaux.setValue("Travaux");
        conditionRepository.save(projetTravaux);
        rule3.setConditions(Arrays.asList(projetTravaux));
        rule3.setAction("5");
        rules.add(rule3);

        Rule rule4=new Rule("projetDivers");
        Conditions projetDivers=new Conditions();
        projetDivers.setProperty("infoClient.natureProjet");
        projetDivers.setOperation("Equal to");
        projetDivers.setValue("Divers");
        conditionRepository.save(projetDivers);
        rule4.setConditions(Arrays.asList(projetDivers));
        rule4.setAction("5");
        rules.add(rule4);

        Rule rule5=new Rule("doubleNationalite");
        Conditions doubleNationalite=new Conditions();
        doubleNationalite.setProperty("infoClient.documentSejour");
        doubleNationalite.setOperation("Equal to");
        doubleNationalite.setValue("Double-nationalité");
        conditionRepository.save(doubleNationalite);
        rule5.setConditions(Arrays.asList(doubleNationalite));
        rule5.setAction("10");
        rules.add(rule5);

        Rule rule6=new Rule("longSejour");
        Conditions longSejour=new Conditions();
        longSejour.setProperty("infoClient.documentSejour");
        longSejour.setOperation("Equal to");
        longSejour.setValue("Long-séjour");
        conditionRepository.save(longSejour);
        rule6.setConditions(Arrays.asList(longSejour));
        rule6.setAction("5");
        rules.add(rule6);

        Rule rule7=new Rule("courtSejour");
        Conditions courtSejour=new Conditions();
        courtSejour.setProperty("infoClient.documentSejour");
        courtSejour.setOperation("Equal to");
        courtSejour.setValue("Court-séjour");
        conditionRepository.save(courtSejour);
        rule7.setConditions(Arrays.asList(courtSejour));
        rule7.setAction("0");
        rules.add(rule7);

        Rule rule8=new Rule("locataire");
        Conditions locataire=new Conditions();
        locataire.setProperty("infoClient.statutLogement");
        locataire.setOperation("Equal to");
        locataire.setValue("Locataire");
        conditionRepository.save(locataire);
        rule8.setConditions(Arrays.asList(locataire));
        rule8.setAction("5");
        rules.add(rule8);

        Rule rule9=new Rule("pret");
        Conditions pret=new Conditions();
        pret.setProperty("infoClient.statutLogement");
        pret.setOperation("Equal to");
        pret.setValue("Propriétaire avec prêt encours");
        conditionRepository.save(pret);
        rule9.setConditions(Arrays.asList(pret));
        rule9.setAction("10");
        rules.add(rule9);

        Rule rule10=new Rule("sansPret");
        Conditions sansPret=new Conditions();
        sansPret.setProperty("infoClient.statutLogement");
        sansPret.setOperation("Equal to");
        sansPret.setValue("Propriétaire sans prêt encours");
        conditionRepository.save(sansPret);
        rule10.setConditions(Arrays.asList(sansPret));
        rule10.setAction("20");
        rules.add(rule10);

        Rule rule11=new Rule("loge");
        Conditions loge=new Conditions();
        loge.setProperty("infoClient.statutLogement");
        loge.setOperation("Equal to");
        loge.setValue("Logé par un employeur ou gratuitement");
        conditionRepository.save(loge);
        rule11.setConditions(Arrays.asList(loge));
        rule11.setAction("15");
        rules.add(rule11);

        Rule rule12=new Rule("autre");
        Conditions autre=new Conditions();
        autre.setProperty("infoClient.statutLogement");
        autre.setOperation("Equal to");
        autre.setValue("Autres");
        conditionRepository.save(autre);
        rule12.setConditions(Arrays.asList(autre));
        rule12.setAction("5");
        rules.add(rule12);

        Rule rule13=new Rule("un");
        Conditions un=new Conditions();
        un.setProperty("infoClient.dureeLogement");
        un.setOperation("Less than");
        un.setValue("1");
        conditionRepository.save(un);
        rule13.setConditions(Arrays.asList(un));
        rule13.setAction("5");
        rules.add(rule13);

        Rule rule14 =new Rule("deux");
        Conditions greaterThan = new Conditions();
        greaterThan.setProperty("infoClient.dureeLogement");
        greaterThan.setOperation("Greater than");
        greaterThan.setValue("1");
        Conditions lessThan = new Conditions();
        lessThan.setProperty("infoClient.dureeLogement");
        lessThan.setOperation("Less than");
        lessThan.setValue("2");
        conditionRepository.save(greaterThan);
        conditionRepository.save(lessThan);
        rule14.setConditions(Arrays.asList(greaterThan,lessThan));
        rule14.setAction("10");
        rules.add(rule14);

        Rule rule15=new Rule("deux");
        Conditions deux=new Conditions();
        deux.setProperty("infoClient.dureeLogement");
        deux.setOperation("Greater than");
        deux.setValue("2");
        conditionRepository.save(deux);
        rule15.setConditions(Arrays.asList(deux));
        rule15.setAction("15");
        rules.add(rule15);

        Rule rule16=new Rule("celibataire");
        Conditions celibataire=new Conditions();
        celibataire.setProperty("infoClient.situationMaritale");
        celibataire.setOperation("Equal to");
        celibataire.setValue("Célibataire");
        conditionRepository.save(celibataire);
        rule16.setConditions(Arrays.asList(celibataire));
        rule16.setAction("10");
        rules.add(rule16);

        Rule rule17=new Rule("marie");
        Conditions marie=new Conditions();
        marie.setProperty("infoClient.situationMaritale");
        marie.setOperation("Equal to");
        marie.setValue("Marié(e)");
        conditionRepository.save(marie);
        rule17.setConditions(Arrays.asList(marie));
        rule17.setAction("15");
        rules.add(rule17);

        Rule rule18=new Rule("divrorce");
        Conditions divrorce=new Conditions();
        divrorce.setProperty("infoClient.situationMaritale");
        divrorce.setOperation("Equal to");
        divrorce.setValue("Divorcé(e)");
        conditionRepository.save(divrorce);
        rule18.setConditions(Arrays.asList(divrorce));
        rule18.setAction("5");
        rules.add(rule18);

        Rule rule19=new Rule("veuf");
        Conditions veuf=new Conditions();
        veuf.setProperty("infoClient.situationMaritale");
        veuf.setOperation("Equal to");
        veuf.setValue("Veuf(ve)");
        conditionRepository.save(veuf);
        rule19.setConditions(Arrays.asList(veuf));
        rule19.setAction("5");
        rules.add(rule19);

        Rule rule20=new Rule("sans");
        Conditions sans=new Conditions();
        sans.setProperty("infoClient.nbEnfant");
        sans.setOperation("Equal to");
        sans.setValue("0");
        conditionRepository.save(sans);
        rule20.setConditions(Arrays.asList(sans));
        rule20.setAction("10");
        rules.add(rule20);

        Rule rule21=new Rule("avec");
        Conditions avec=new Conditions();
        avec.setProperty("infoClient.nbEnfant");
        avec.setOperation("Equal to");
        avec.setValue("1");
        conditionRepository.save(avec);
        rule21.setConditions(Arrays.asList(avec));
        rule21.setAction("10");
        rules.add(rule21);

        Rule rule22=new Rule("avecDeux");
        Conditions avecDeux=new Conditions();
        avecDeux.setProperty("infoClient.nbEnfant");
        avecDeux.setOperation("Equal to");
        avecDeux.setValue("2");
        conditionRepository.save(avecDeux);
        rule22.setConditions(Arrays.asList(avecDeux));
        rule22.setAction("5");
        rules.add(rule22);

        Rule rule23=new Rule("supDeux");
        Conditions supDeux=new Conditions();
        supDeux.setProperty("infoClient.nbEnfant");
        supDeux.setOperation("Greater than");
        supDeux.setValue("2");
        conditionRepository.save(supDeux);
        rule23.setConditions(Arrays.asList(supDeux));
        rule23.setAction("0");
        rules.add(rule23);

        Rule rule24=new Rule("seul");
        Conditions seul=new Conditions();
        seul.setProperty("infoClient.nbEmprunteur");
        seul.setOperation("Equal to");
        seul.setValue("1");
        conditionRepository.save(seul);
        rule24.setConditions(Arrays.asList(seul));
        rule24.setAction("5");
        rules.add(rule24);

        Rule rule25=new Rule("aDeux");
        Conditions aDeux=new Conditions();
        aDeux.setProperty("infoClient.nbEmprunteur");
        aDeux.setOperation("Equal to");
        aDeux.setValue("2");
        conditionRepository.save(aDeux);
        rule25.setConditions(Arrays.asList(aDeux));
        rule25.setAction("10");
        rules.add(rule25);

        Rule rule26=new Rule("prive");
        Conditions prive=new Conditions();
        prive.setProperty("infoClient.statutProfesionnel");
        prive.setOperation("Equal to");
        prive.setValue("Salarié du privé ");
        conditionRepository.save(prive);
        rule26.setConditions(Arrays.asList(prive));
        rule26.setAction("5");
        rules.add(rule26);

        Rule rule27=new Rule("public");
        Conditions spublic=new Conditions();
        spublic.setProperty("infoClient.statutProfesionnel");
        spublic.setOperation("Equal to");
        spublic.setValue("Salarié du public");
        conditionRepository.save(spublic);
        rule27.setConditions(Arrays.asList(spublic));
        rule27.setAction("10");
        rules.add(rule27);

        Rule rule28=new Rule("independant");
        Conditions independant=new Conditions();
        independant.setProperty("infoClient.statutProfesionnel");
        independant.setOperation("Equal to");
        independant.setValue("Independant");
        conditionRepository.save(independant);
        rule28.setConditions(Arrays.asList(independant));
        rule28.setAction("5");
        rules.add(rule28);

        Rule rule29=new Rule("retraite");
        Conditions retraite=new Conditions();
        retraite.setProperty("infoClient.statutProfesionnel");
        retraite.setOperation("Equal to");
        retraite.setValue("Retraité");
        conditionRepository.save(retraite);
        rule29.setConditions(Arrays.asList(retraite));
        rule29.setAction("0");
        rules.add(rule29);

        Rule rule30=new Rule("cdi");
        Conditions cdi=new Conditions();
        cdi.setProperty("infoClient.typeContrat");
        cdi.setOperation("Equal to");
        cdi.setValue("CDI");
        conditionRepository.save(cdi);
        rule30.setConditions(Arrays.asList(cdi));
        rule30.setAction("20");
        rules.add(rule30);

        Rule rule31=new Rule("cdd");
        Conditions cdd=new Conditions();
        cdd.setProperty("infoClient.typeContrat");
        cdd.setOperation("Equal to");
        cdd.setValue("CDD");
        conditionRepository.save(cdd);
        rule31.setConditions(Arrays.asList(cdd));
        rule31.setAction("10");
        rules.add(rule31);

        Rule rule32=new Rule("interim");
        Conditions interim=new Conditions();
        interim.setProperty("infoClient.typeContrat");
        interim.setOperation("Equal to");
        interim.setValue("Intérim");
        conditionRepository.save(interim);
        rule32.setConditions(Arrays.asList(interim));
        rule32.setAction("5");
        rules.add(rule32);

        Rule rule33=new Rule("aprentissage");
        Conditions aprentissage=new Conditions();
        aprentissage.setProperty("infoClient.typeContrat");
        aprentissage.setOperation("Equal to");
        aprentissage.setValue("Contrat d’apprentissage");
        conditionRepository.save(aprentissage);
        rule33.setConditions(Arrays.asList(aprentissage));
        rule33.setAction("0");
        rules.add(rule33);

        Rule rule34=new Rule("cadre");
        Conditions cadre=new Conditions();
        cadre.setProperty("infoClient.classificationContrat");
        cadre.setOperation("Equal to");
        cadre.setValue("Contrat Cadre");
        conditionRepository.save(cadre);
        rule34.setConditions(Arrays.asList(cadre));
        rule34.setAction("10");
        rules.add(rule34);

        Rule rule35=new Rule("non_cadre");
        Conditions non_cadre=new Conditions();
        non_cadre.setProperty("infoClient.classificationContrat");
        non_cadre.setOperation("Equal to");
        non_cadre.setValue("Contrat non-Cadre");
        conditionRepository.save(non_cadre);
        rule35.setConditions(Arrays.asList(non_cadre));
        rule35.setAction("5");
        rules.add(rule35);

        Rule rule36=new Rule("six");
        Conditions six=new Conditions();
        six.setProperty("infoClient.dureeContrat");
        six.setOperation("Less than");
        six.setValue("6");
        conditionRepository.save(six);
        rule36.setConditions(Arrays.asList(six));
        rule36.setAction("0");
        rules.add(rule36);

        Rule rule37=new Rule("douze");
        Conditions douze=new Conditions();
        douze.setProperty("infoClient.dureeContrat");
        douze.setOperation("Less than");
        douze.setValue("12");
        Conditions inf=new Conditions();
        inf.setProperty("infoClient.dureeContrat");
        inf.setOperation("Greater than");
        inf.setValue("6");
        conditionRepository.save(inf);
        conditionRepository.save(douze);
        rule37.setConditions(Arrays.asList(inf,douze));
        rule37.setAction("5");
        rules.add(rule37);

        Rule rule38=new Rule("sup");
        Conditions sup=new Conditions();
        sup.setProperty("infoClient.dureeContrat");
        sup.setOperation("Greater than");
        sup.setValue("12");
        conditionRepository.save(sup);
        rule38.setConditions(Arrays.asList(sup));
        rule38.setAction("20");
        rules.add(rule38);

        ruleRepository.saveAll(rules);
        //Create a session to operate Drools in memory
        DroolsUtility utility = new DroolsUtility();
        Date date=new Date("06/07/1997");
        StatelessKieSession session = utility.loadSession(rules, "drools/templates/Client.drl");		//Define the products to be processed using our rules
        Client client1=new Client("fadili ahlam","Madame","061243474","ahlamfadili10@gmail.com","EE676302",date);
        InfoClient info =new InfoClient("Immobilier","Célibataire",0,0,20000000,"Double-nationalité","Propriétaire sans prêt encours",new Long(1),new Long(1),"Salarié du privé ","CDI","Contrat Cadre",6,"39 unite mohamed Safou HYBR");
        client1.setInfoClient(info);

        Segment segment1=new Segment(0,30);
        Notation notation1=new Notation("A","description1");
        segment1.setNotation(notation1);
        Segment segment2=new Segment(30,60);
        Notation notation2=new Notation("B","description2");
        segment2.setNotation(notation2);
        Segment segment3=new Segment(60,90);
        Notation notation3=new Notation("C","description3");
        segment3.setNotation(notation3);
        Segment segment4=new Segment(90,120);
        Notation notation4=new Notation("D","description4");
        segment4.setNotation(notation4);
        Segment segment5=new Segment(120,150);
        Notation notation5=new Notation("A","description5");
        segment5.setNotation(notation5);

        client1.setNotation(notation1);
        infoClientRepository.save(info);
        clientRepository.save(client1);

        System.out.println("***before over " + client1.getNom() + " with score " + client1.getScore() + "...");
        session.setGlobal("client", client1);
        session.execute(client1);
        System.out.println("***score after review: " + client1.getScore());


        notationRepository.save(notation1);
        notationRepository.save(notation2);
        notationRepository.save(notation3);
        notationRepository.save(notation4);
        notationRepository.save(notation5);

        segementRepository.save(segment2);
        segementRepository.save(segment2);
        segementRepository.save(segment3);
        segementRepository.save(segment4);
        segementRepository.save(segment5);










    }
}
