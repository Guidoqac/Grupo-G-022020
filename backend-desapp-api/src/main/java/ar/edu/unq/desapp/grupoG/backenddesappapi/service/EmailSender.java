package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Component
@Service
public class EmailSender {

    @Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private DonationService donationService;

    /*
     * 86400000 milisegundos = 1 dia
     *     5000 milisegundos = 5 segundos
     */
    //@Scheduled(fixedRate = 86400000)
    public void sendMessageUsingThymeleafTemplate() throws MessagingException {

        List<User> users = userService.findAll();
        String[] mails = users.stream().map(u -> u.getEmail()).collect(Collectors.toList()).toArray(new String[0]);
        List<Double> donationsAmount = donationService.getTopTenDonations().stream().map(d -> d.getAmount()).collect(Collectors.toList());
        List<String> locationsName = locationService.findTopTenLocations().stream().map(l -> l.getName()).collect(Collectors.toList());

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        Context thymeleafContext = new Context();
        thymeleafContext.setVariable("donationsAmount", donationsAmount);
        thymeleafContext.setVariable("locationsName", locationsName);
        String htmlBody = thymeleafTemplateEngine.process("template1.html", thymeleafContext);

        helper.setText(htmlBody, true);
        helper.setSubject("Top diario.");
        helper.setTo(mails);
        javaMailSender.send(message);
    }

    public void sendMessageToFinishedProject(String projectName, String[] mails) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        Context thymeleafContext = new Context();
        thymeleafContext.setVariable("nombreProyecto", projectName);
        String htmlBody = thymeleafTemplateEngine.process("template2.html", thymeleafContext);

        helper.setText(htmlBody, true);
        helper.setSubject("Proyecto finalizado.");
        helper.setTo(mails);
        javaMailSender.send(message);
    }

}
