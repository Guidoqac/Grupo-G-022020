package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.EmailBody;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.DonationService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.EmailService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.mail.internet.AddressException;

@Component
@Controller
public class EmailSender {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private EmailService emailService;

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
    //@Scheduled(fixedRate = 60000)
    public void sendEmail() throws AddressException {
        List<User> users = userService.findAll();
        List<String> mails = users.stream().map(u -> u.getEmail()).collect(Collectors.toList());
        List<Donation> donations = donationService.getTopTenDonations();
        List<Location> locations = locationService.findTopTenLocations();

        mails.forEach(mail -> {
            emailService.sendEmail(emailService.createEmailBody(mail, "Mensaje de prueba", donations.toString() + locations.toString()));
        });
    }
}
