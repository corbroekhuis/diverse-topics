package com.academy.mailserver.controller;

import com.academy.mailserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.academy.mailserver.model.Email;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api")
public class EmailController {

    protected static final Logger logger = LogManager.getLogger();

    EmailService emailService;
    String version;
    
    @Autowired
    public EmailController(EmailService emailService, @Value("${version}") String version){
        this.emailService = emailService;
        this.version = version;
    }

    @GetMapping("/getversion")
    public ResponseEntity<String> getVersion() {

        logger.info("Inside 'getVersion'");

        return ResponseEntity.ok( version);

    }

    @PutMapping(value = "/email", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveEmail(@RequestBody final Email email) {

        logger.info("Inside 'saveEmail' " + email.getRecipients());
/*
        // Use Random class to pause for 10 to 20 millisecs
        int milliSecs = ThreadLocalRandom.current().nextInt(10, 19 + 1);
        try {
            Thread.sleep(milliSecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        emailService.save(email);
       //return ResponseEntity.ok("Ok!") ;
        return new ResponseEntity("{ \"status\": \"Ok!\"}", HttpStatus.CREATED);

    }

    @GetMapping(value = "/email/{id}", produces = "application/json")
    public ResponseEntity<Email> getEmailById(@PathVariable final Long id) {

        logger.info("Inside 'getEmailById'");

        try {
            Email email = emailService.findById(id).orElse(null);
            return ResponseEntity.ok( email);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/email", produces = "application/json")
    public ResponseEntity<Iterable<Email>> getAllEmails() {

        logger.info("Inside 'getAllEmails'");

        try {
            Iterable<Email> emails = emailService.findAll();
            return ResponseEntity.ok( emails);
        } catch (Exception e) {
            return ResponseEntity.ok( null); // Collections.emptyList()
        }

    }

    @DeleteMapping(value = "/email/{id}", produces = "text/plain")
    public ResponseEntity<String> deleteEmailById( @PathVariable final Long id) {

        logger.info("Inside 'deleteEmailById'");

        try {
            emailService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

