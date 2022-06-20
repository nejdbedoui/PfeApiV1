package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.EndPoint.SendSMSEndpoint;
import com.bprice.bpapipos.repository.IPartenaireBpriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import ch.qos.logback.classic.Logger;

import javax.servlet.http.HttpServletRequest;


@Service
public class SendSMS {
    @Autowired
    private SendSMS sendingSmsService;
    @Autowired
    IPartenaireBpriceRepository partenaireBpriceRepository;
    @Autowired
    private JavaMailSender mailSender;
    private static final  Logger logger = LoggerFactory.getLogger(SendSMS.class);

    private RestTemplate restTemplate = new RestTemplate();


    private String sender="Bprice";


    private String url="https://www.tunisiesms.tn/client/Api/Api.aspx?fct=sms&key=OrGLZv3yXPMfWZnPn6YgcBUiVxCbXCGEuHJpIUtlGT8Fd3DomSsKqpZvNKpmfRMPS/-//-/kRVsJDSSodVKBIEHtRnhxbGBZVcaC"

    ;


    public int sendSMS(String destination, String msg) {
        int ret = 0;
        try {
            String completeURL;
            //String Url_str = "https://www.tunisiesms.tn/client/Api/Api.aspx?fct=sms&key=MYKEY&mobile=216XXXXXXXX&sms=Hello+World&sender=YYYYYYY";
            msg = msg.replace(" ", "%20");

            LocalDateTime localDateTime = LocalDateTime.now();
            ZoneId z = ZoneId.of( "Africa/Tunis" );
            ZonedDateTime zdt = localDateTime.atZone( z );

            TimeZone timeZoneUTC = TimeZone.getTimeZone("UTC");
            Calendar calendar = Calendar.getInstance(timeZoneUTC);
            Date date = calendar.getTime();
            // Display a date in day, month, year format

            //Calendar rightNow = Calendar.getInstance();
            int hour = zdt.getHour();
            int minutes = zdt.getMinute();

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);


            completeURL = url+"&mobile="+destination+"&sms=" +msg+"&sender="+sender+"&date="+today;

            logger.info("URL de sms : " + completeURL);
            URL myURL = new URL(completeURL);
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    myURLConnection.getInputStream()));
            String inputLine;
            String xml = "";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("SMS API: " + inputLine);
                xml += inputLine;
            }

            if (xml.contains("<status_code>200</status_code>")) {
                ret = 1;
            } else {
                ret = -1;
            }
            in.close();

        } catch (MalformedURLException e) {
            System.out.println("SEND SMS: MalformedURLException " + e.getMessage());
            return -2;
        } catch (IOException e) {
            System.out.println("SEND SMS: IOException " + e.getMessage());
            return -3;
        }
        logger.info("OTP envoyé : à " + destination);
        return ret;

    }

    public String ckeckNumTelFormat(String msisdn) {
        if(msisdn == null)
            return null;
        if(msisdn.length() < 8)
            return null;
        if(msisdn.length() == 8)
            msisdn = "216"+msisdn;
        else
        if(msisdn.startsWith("00"))
            msisdn.replace("00", "");
        if(msisdn.length() != 11)
            return null;
        if(!msisdn.startsWith("216"))
            return null;
        return msisdn;
    }
    @Autowired
    public void Sendmail(){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("testmailsenderspringboot@gmail.com");
        message.setTo("nejdbedoui@gmail.com");
        message.setText("Chair partenaire, votre contrat est prêt pour être confirmé, veuillez le vérifier et le valider au plus taut possible \n  Merci pour votre compréhension \n http://localhost:4200/pages/gestionpub/gestionacontrat ");
        message.setSubject("test");
        mailSender.send(message);
    }
}
