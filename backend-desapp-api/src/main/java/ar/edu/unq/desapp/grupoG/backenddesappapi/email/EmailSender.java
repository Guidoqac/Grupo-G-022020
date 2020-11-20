package ar.edu.unq.desapp.grupoG.backenddesappapi.email;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private EmailService emailService;

    /*
     * 86400000 milisegundos = 1 dia
     *     5000 milisegundos = 5 segundos
     */
    //@Scheduled(fixedRate = 5000)
    public void sendEmail() {
        EmailBody emailBody = new EmailBody();
        emailBody.setEmail("gonveron96@gmail.com");
        emailBody.setSubject("Mensaje de prueba");
        emailBody.setContent("Este mensaje fue enviado el " + dateFormat.format(new Date()));
        emailService.sendEmail(emailBody);
    }
}
