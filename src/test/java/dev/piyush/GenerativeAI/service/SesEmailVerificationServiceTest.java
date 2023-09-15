package dev.piyush.GenerativeAI.service;

//Importing JUnit
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//import SesEmailVerificationService class
import dev.piyush.GenerativeAI.service.SesEmailVerificationService;
public class SesEmailVerificationServiceTest {

    @Test
    public void  testSendEmail() {
        SesEmailVerificationService sesEmailVerificationService = new SesEmailVerificationService();
        sesEmailVerificationService.sendEmail("test");
    }

    @Test
    public void  testSendEmailWithException() {
        SesEmailVerificationService sesEmailVerificationService = new SesEmailVerificationService();
        assertThrows(RuntimeException.class, () -> {
            sesEmailVerificationService.sendEmail("test");
        });
    }

    @Test
    public void  testSendEmailWithException2() {
        SesEmailVerificationService sesEmailVerificationService = new SesEmailVerificationService();
        assertThrows(RuntimeException.class, () -> {
            sesEmailVerificationService.sendEmail("test");
        });
    }
}
