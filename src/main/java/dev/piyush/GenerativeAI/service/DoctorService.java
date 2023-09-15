package dev.piyush.GenerativeAI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.piyush.GenerativeAI.dao.DoctorDao;
import dev.piyush.GenerativeAI.dao.S3Repository;
import dev.piyush.GenerativeAI.model.dto.DoctorDto;
import dev.piyush.GenerativeAI.model.entity.Doctor;
import dev.piyush.GenerativeAI.utils.Validator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DoctorService {

    private final DoctorDao doctorDao;

    private final S3Repository s3Repository;

    private final KafkaTemplate kafkaTemplate;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;
    private final SesEmailVerificationService sesEmailVerificationService;

    public DoctorService(DoctorDao doctorDao, S3Repository s3Repository, KafkaTemplate kafkaTemplate, ObjectMapper objectMapper, RestTemplate restTemplate, SesEmailVerificationService sesEmailVerificationService) {
        this.doctorDao = doctorDao;
        this.s3Repository = s3Repository;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
        this.sesEmailVerificationService = sesEmailVerificationService;
    }

    /* Write code here to save the doctor details in the database
     * Check first in database if the doctor is already present or not
     * If present then throw an exception
     * If not present then save the doctor details in the database
     *
     * @param doctor
     * @return
     */
    public Doctor addDoctor(DoctorDto doctorDto) {
        if (!Validator.validateDoctorDto(doctorDto)) {
            throw new RuntimeException("Invalid Doctor Details");
        }

        Doctor doctor = doctorDao.findByEmail(doctorDto.getEmail());
        if (doctor != null) {
            throw new RuntimeException("Doctor already present");
        }

        //map the doctorDto to doctor entity using model mapper and then save it in the database
        Doctor savedDoctor = (Doctor) doctorDao.save(objectMapper.convertValue(doctorDto, Doctor.class));

        //send the doctor details to kafka topic
        kafkaTemplate.send("doctor-details", savedDoctor);

        //send a verification email to the doctor

        sesEmailVerificationService.sendEmail(savedDoctor.getEmail());

        return savedDoctor;
    }

    //write code here to upload a document for specific doctor in S3 bucket
    public void uploadDocument(String email, MultipartFile file) throws IOException {
        Doctor doctor = doctorDao.findByEmail(email);
        if (doctor == null) {
            throw new RuntimeException("Doctor not found");
        }

        s3Repository.uploadFile(file);
        System.out.println("File Uploaded Successfully");
    }

    /*write code here to call other api using rest template using exchange client and check if status code 200 then parse the response
    other wise throw an exception
    @return
    @throws IOException
    */
    public String getDoctorDetails() throws IOException {
        try {
            String url = "https://jsonplaceholder.typicode.com/todos/1";
            String response = restTemplate.getForObject(url, String.class);
            if (response.contains("200")) {
                return response;
            } else {
                throw new RuntimeException("Invalid Response");
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid Response");
        }
    }
}