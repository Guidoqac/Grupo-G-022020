package ar.edu.unq.desapp.grupoG.backenddesappapi.email;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private static final Logger log = LoggerFactory.getLogger(EmailSender.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        EmailBody emailBody = new EmailBody();
        emailBody.setEmail("gonveron96@gmail.com");
        emailBody.setSubject("Mensaje de prueba");
        emailBody.setContent("Este mensaje fue enviado el " + dateFormat.format(new Date()));
        emailService.sendEmail(emailBody);
    }
}
