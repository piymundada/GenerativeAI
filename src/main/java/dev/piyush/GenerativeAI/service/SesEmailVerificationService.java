package dev.piyush.GenerativeAI.service;

import com.mongodb.AwsCredential;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;

@Service
public class SesEmailVerificationService {


    private SesClient sesClient;

    private String accessKey;
    private String secretKey;

    @PostConstruct
    public void init() {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));
        sesClient = SesClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.US_EAST_1)
                .build();
    }

    public void sendEmail(String email) {
        sesClient.verifyEmailIdentity(builder -> builder.emailAddress(email));
    }

}
