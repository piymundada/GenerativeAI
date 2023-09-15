package dev.piyush.GenerativeAI.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Document(collection = "doctor")
public class Doctor {

    @Id
    @Field(value = "_id")
    private UUID id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}
