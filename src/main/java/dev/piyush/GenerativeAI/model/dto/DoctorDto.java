package dev.piyush.GenerativeAI.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDto {

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

    @Override
    public String toString() {
        return "DoctorDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }





}
