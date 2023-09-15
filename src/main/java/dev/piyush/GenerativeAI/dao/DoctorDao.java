package dev.piyush.GenerativeAI.dao;

import dev.piyush.GenerativeAI.model.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorDao extends MongoRepository {
    Doctor findByEmail(String email);
}
