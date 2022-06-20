package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IHistoriqueRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.Hello;
import com.bprice.persistance.model.Historique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Controller
@EnableScheduling
public class RealTimeDataController {
    @Autowired
    private SimpMessagingTemplate template;

    private boolean connectionstatus = false;
    @Autowired
    IHistoriqueRepository historiqueRepository;

private String idActionMarketing;
private Historique historiquebackup;
    @MessageMapping("/startwebsocket")
    public void greeting(String idAction) throws Exception {
        this.idActionMarketing = idAction;
        historiquebackup = historiqueRepository.findFirstByIdActionmarketingOrderByDateDesc(idActionMarketing);
        System.out.println(historiquebackup);

    }

    @Scheduled(fixedRate = 1000)
    public void findlasthistorique() throws Exception {
        if(this.connectionstatus) {
            Historique historique = historiqueRepository.findFirstByIdActionmarketingOrderByDateDesc(this.idActionMarketing);
            if(!(historique.getIdHistorique().equals(this.historiquebackup.getIdHistorique()))) {
                this.historiquebackup = historique;

                this.template.convertAndSend("/HistoriqueInteraction/sendHistorique", new ResponseObject(EnumMessage.HISTORIQUEINTERACTION_EXIST.code, EnumMessage.HISTORIQUEINTERACTION_EXIST.label,
                        historique));

            }


        }

    }
    @EventListener
    public void onDisconnectEvent(SessionDisconnectEvent event) {
        this.connectionstatus = false;
        System.out.println(new Hello("DISCONNECTED"));

    }
    @EventListener
    public void onConnectEvent(SessionConnectedEvent event) {
        this.connectionstatus = true;
        System.out.println(new Hello("connected"));
    }
   public void DisableEnableSchedule(){

   }
}
