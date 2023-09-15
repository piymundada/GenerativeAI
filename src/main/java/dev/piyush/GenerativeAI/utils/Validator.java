package dev.piyush.GenerativeAI.utils;

import dev.piyush.GenerativeAI.model.dto.DoctorDto;

public class Validator {

    /* Write a validation method to validate
    first name, last name, specialization,
    email, password, phone number, address, city, state, country, zip code
     */

    public static boolean validateFirstName(String firstName) {
        return firstName.matches("^[a-zA-Z]+$");
    }

    public static boolean validateLastName(String lastName) {
        return lastName.matches("^[a-zA-Z]+$");
    }


    public static boolean validateSpecialization(String specialization) {
        return specialization.matches("^[a-zA-Z]+$");
    }


    public static boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }


    public static boolean validatePassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^[0-9]{10}$");
    }

    public static boolean validateAddress(String address) {
        return address.matches("^[a-zA-Z0-9]+$");
    }


    public static boolean validateCity(String city) {
        return city.matches("^[a-zA-Z]+$");
    }


    public static boolean validateState(String state) {
        return state.matches("^[a-zA-Z]+$");
    }


    public static boolean validateCountry(String country) {
        return country.matches("^[a-zA-Z]+$");
    }


    public static boolean validateZipCode(String zipCode) {
        return zipCode.matches("^[0-9]{6}$");
    }


    public static boolean validateDoctorDto(DoctorDto doctorDto) {
        return validateFirstName(doctorDto.getFirstName()) &&
                validateLastName(doctorDto.getLastName()) &&
                validateSpecialization(doctorDto.getSpecialization()) &&
                validateEmail(doctorDto.getEmail()) &&
                validatePassword(doctorDto.getPassword()) &&
                validatePhoneNumber(doctorDto.getPhoneNumber()) &&
                validateAddress(doctorDto.getAddress()) &&
                validateCity(doctorDto.getCity()) &&
                validateState(doctorDto.getState()) &&
                validateCountry(doctorDto.getCountry()) &&
                validateZipCode(doctorDto.getZipCode());
    }



}
