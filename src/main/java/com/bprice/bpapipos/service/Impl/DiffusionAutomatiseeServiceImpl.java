package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.repository.*;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IDiffusionAutomatiseeService;
import com.bprice.persistance.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class DiffusionAutomatiseeServiceImpl implements IDiffusionAutomatiseeService {

@Autowired
    IActionMarketingRepository iActionMarketingRepository;
@Autowired
    IFormatAffichageRepository iFormatAffichageRepository;
@Autowired
    IPubliciteMobileRepository iPubliciteMobileRepository;
@Autowired
    IStorageRepository iStorageRepository;
@Autowired
    IPopulationCibleRepository iPopulationCibleRepository;
@Autowired
IClientPartenaireRepository iClientPartenaireRepository;
@Autowired
IParametreActionMarketingRepository iParametreActionMarketingRepository;
@Autowired
IClientRepository iClientRepository;
@Autowired
    IHistoriqueRepository iHistoriqueRepository;
    @Override
    public void MiseAJour() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        iPubliciteMobileRepository.deleteAll();
         //ByStatutAndAuto(2,true)
        for ( ActionMarketing action : iActionMarketingRepository.findAll()){
            if(action.getDateDebut().compareTo(new Date())<=0 && action.getDateFin().compareTo(new Date()) >=0){
                System.out.println(action);
                FormatAffichage formatAffichage=iFormatAffichageRepository.findById(action.getIdFormatAffichage()).orElse(null);
                if(formatAffichage != null && formatAffichage.getType().equals("Mobile") && !formatAffichage.getLibelle().equals("Notification")){
                    PopulationCible populationCible=iPopulationCibleRepository.findById(action.getIdPopulationCible()).orElse(null);
                    Storage storage= iStorageRepository.findById(action.getIdStorage()).orElse(null);
                    PubliciteMobile publiciteMobile = new PubliciteMobile();
                    publiciteMobile.setAgeMax(populationCible.getAgeMax());
                    publiciteMobile.setAgeMin(populationCible.getAgeMin());
                    publiciteMobile.setFrequence(action.getFrequence());
                    publiciteMobile.setSexeCible(populationCible.getSexe());
                    publiciteMobile.setLienAction(storage.getUrl());
                    publiciteMobile.setUrlExtern(action.getExternUrl());
                    publiciteMobile.setIdActionMarketing(action.getIdActionMarketing());
                    iPubliciteMobileRepository.save(publiciteMobile);
                }

            }


        }
        try{

            this.Pop_up();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void Pop_up() throws InterruptedException {
        if(iPubliciteMobileRepository.countAllByFrequenceGreaterThan(0) != 0 ){
            List<PubliciteMobile> list=iPubliciteMobileRepository.findAll();
            if(list != null ){
                for(PubliciteMobile publiciteMobile: list){
                    if(publiciteMobile.getFrequence() !=0){
                        publiciteMobile.setActive(true);
                       publiciteMobile.setFrequence(publiciteMobile.getFrequence()-1);
                        iPubliciteMobileRepository.save(publiciteMobile);
                        Thread.sleep(60*60*1000L);
                        publiciteMobile.setActive(false);
                    }
                }
            }
            this.Pop_up();
        }
    }

    @Override
    public ResponseObject check(String idClient){
        ClientPartenaire client=iClientPartenaireRepository.findById(idClient).orElse(null);
        System.out.println("yes1");
        PubliciteMobile publiciteMobile=iPubliciteMobileRepository.findByActiveEquals(true);
        System.out.println("yes2");
        ActionMarketing actionMarketing=iActionMarketingRepository.findById(publiciteMobile.getIdActionMarketing()).orElse(null);
        System.out.println("yes3");
        List<ParametreActionMarketing> parametreActionMarketing=iParametreActionMarketingRepository.findByIdPartenaireCibleAndStatutAndIdActionMarketing(client.getIdPartenaire(),1,actionMarketing.getIdActionMarketing());
       Client client1=iClientRepository.findById(client.getIdClient()).orElse(null);
       System.out.println("yes4");
       List<Historique> historique2=iHistoriqueRepository.findAllByIdActionmarketingAndIdClient(actionMarketing.getIdActionMarketing(),client1.getIdClient());
       int genre=2;
       if(client1.getGenre().equals("Hpmme")){
           genre=1;
       }else if(client1.getGenre().equals("Femme")){
           genre=0;
       }
        if(parametreActionMarketing != null ){
            System.out.println("yes5");
            if((genre==publiciteMobile.getSexeCible() || publiciteMobile.getSexeCible()==2) && (publiciteMobile.getAgeMin() >= (client1.getDateNaissance().getYear()-new Date().getYear()) && (client1.getDateNaissance().getYear()-new Date().getYear()) <= publiciteMobile.getAgeMax())) {
                System.out.println("yes6");
                Historique historique=new Historique();
                historique.setAction(0);
                historique.setAge(new Date().getYear()-client1.getDateNaissance().getYear());
                historique.setDate(new Date());
                historique.setIdActionmarketing(actionMarketing.getIdActionMarketing());
                historique.setSexe(genre);
                historique.setIdClient(client1.getIdClient());
                iHistoriqueRepository.save(historique);
                return new ResponseObject(1,"yes",publiciteMobile);
            }
        }
        return new ResponseObject(-1,"no",null);
    }


    @Override
    public void click(String idClient){
        ClientPartenaire client=iClientPartenaireRepository.findById(idClient).orElse(null);
        System.out.println("yes1");
        PubliciteMobile publiciteMobile=iPubliciteMobileRepository.findByActiveEquals(true);
        System.out.println("yes2");
        ActionMarketing actionMarketing=iActionMarketingRepository.findById(publiciteMobile.getIdActionMarketing()).orElse(null);
        System.out.println("yes3");
        List<ParametreActionMarketing> parametreActionMarketing=iParametreActionMarketingRepository.findByIdPartenaireCibleAndStatutAndIdActionMarketing(client.getIdPartenaire(),1,actionMarketing.getIdActionMarketing());
        Client client1=iClientRepository.findById(client.getIdClient()).orElse(null);
        System.out.println("yes4");
        List<Historique> historique2=iHistoriqueRepository.findAllByIdActionmarketingAndIdClient(actionMarketing.getIdActionMarketing(),client1.getIdClient());
        int genre=2;
        if(client1.getGenre().equals("Hpmme")){
            genre=1;
        }else if(client1.getGenre().equals("Femme")){
            genre=0;
        }
        if(client!=null){
            Historique historique=new Historique();
            historique.setAction(1);
            historique.setAge(new Date().getYear()-client1.getDateNaissance().getYear());
            historique.setDate(new Date());
            historique.setIdActionmarketing(actionMarketing.getIdActionMarketing());
            historique.setSexe(genre);
            historique.setIdClient(client1.getIdClient());
            iHistoriqueRepository.save(historique);

        }
    }


}
