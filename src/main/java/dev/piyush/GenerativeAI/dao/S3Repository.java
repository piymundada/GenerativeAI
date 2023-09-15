package dev.piyush.GenerativeAI.dao;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import jakarta.annotation.PostConstruct;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;

import java.io.IOException;

public class S3Repository {

    public AmazonS3 s3Client;

    //write code here to connect to s3 using the credentials
    @PostConstruct
    public void init() {
        System.out.println("S3 Repository Initialized");
        String accessKey = "XXXXXXXXX";
        String secretKey = "XXXXXXXXX";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey,secretKey);
        s3Client = new AmazonS3Client(credentials);
    }


   //Write code here to connect to S3 and upload the image to S3 bucket
    public void uploadFile(MultipartFile file) throws IOException {
        s3Client.putObject("bucket-name", file.getOriginalFilename(), file.getInputStream().toString());
        System.out.println("File Uploaded Successfully");
    }

    //Write code here to connect to S3 and download the image from S3 bucket
    public void downloadFile(String fileName) {
        s3Client.getObject("bucket-name", fileName);
        System.out.println("File Downloaded Successfully");
    }

}
