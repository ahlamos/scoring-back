package com.example.com.controleur;

import com.example.com.dao.DemandeCreditRepository;
import com.example.com.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class DemandeCreditRestService {
    @Autowired
    private DemandeCreditRepository demandeCreditRepository;

    @RequestMapping(value = "/demandesCredits", method = RequestMethod.GET)
    public List<DemandeCredit> getDemandes() {
        List<DemandeCredit> resultats= new ArrayList<DemandeCredit>();
        Predicate<DemandeCredit> byStatut=demandeCredit -> demandeCredit.getStatut()!=null;
        List<DemandeCredit> demandeCredits=demandeCreditRepository.findAll();
        resultats=demandeCredits.stream().filter(byStatut).collect(Collectors.toList());
        return resultats;

    }

    @RequestMapping(value="/updateStatut/{id}",method= RequestMethod.PATCH)
    public void updateStatut(@PathVariable(name="id") Long identificateur, @RequestBody String statut) throws Exception {
        DemandeCredit demandeCredit = demandeCreditRepository.findById(identificateur).get();
        demandeCredit.setStatut(statut);
        demandeCreditRepository.save(demandeCredit);
    }
}
