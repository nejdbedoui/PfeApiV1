package com.bprice.bpapipos.EndPoint;

import ch.qos.logback.classic.Logger;
import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IPartenaireBpriceRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.Impl.LoggerFactory;
import com.bprice.bpapipos.service.Impl.SendSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class SendSMSEndpoint {
    private static final transient Logger logger = LoggerFactory.getLogger(SendSMSEndpoint.class);

    @Autowired
    private SendSMS sendingSmsService;
    @Autowired
    IPartenaireBpriceRepository partenaireBpriceRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    SendSMS sendSMS;
    @CrossOrigin()
    @RequestMapping(value = "/sendSms/destination/{destination}/bodysms/{bodysms}/application/{idApplication}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseObject sendSms(@PathVariable("destination") String destination, @PathVariable("bodysms") String bodysms, @PathVariable("idApplication") String idApplication){
        logger.info("sendSms sms for destination : "+destination);
        if (destination != null){
            destination = sendingSmsService.ckeckNumTelFormat(destination);
        }
        if (destination == null)
            return new ResponseObject(EnumMessage.ERROR.code, "destination invalide",null);

        if(null == partenaireBpriceRepository.findByIdPartenaire(idApplication)){
            return new ResponseObject(EnumMessage.ERROR.code, "partenaire invalide",null);
        }

        //send password
        int ret = sendingSmsService.sendSMS(destination, bodysms);

        if(ret == 1){


            return new ResponseObject(EnumMessage.OK.code, "message envoyé avec success",null);
        }else
            return new ResponseObject(EnumMessage.ERROR.code, "message non envoyé",null);
    }

    @PostMapping("/send_mail")
    public void Sendmail(HttpServletRequest request){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("testmailsenderspringboot@gmail.com");
        message.setTo("nejdbedoui@gmail.com");
        message.setText("Chair partenaire, votre contrat est prêt pour être confirmé, veuillez le vérifier et le valider au plus taut possible \n  Merci pour votre compréhension \n http://localhost:4200/pages/gestionpub/gestionacontrat ");
        message.setSubject("test");
        mailSender.send(message);
    }

    @PostMapping("/send_mail2")
    public void Sendmail2(HttpServletRequest request){
        sendSMS.Sendmail();
    }
}
