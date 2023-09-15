package dev.piyush.GenerativeAI.controller;

import dev.piyush.GenerativeAI.model.dto.DoctorDto;
import dev.piyush.GenerativeAI.model.entity.Doctor;
import dev.piyush.GenerativeAI.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {


     @Autowired
     private DoctorService doctorService;


     @PostMapping("/doctor")
     public Doctor addDoctor(@RequestBody DoctorDto doctor) {
         return doctorService.addDoctor(doctor);
     }
}
