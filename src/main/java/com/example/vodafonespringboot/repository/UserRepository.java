package com.example.vodafonespringboot.repository;
import java.util.List;

import com.example.vodafonespringboot.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    // Extensión de la clase MongoRepository. Este interface se utilizará para
    // realizar interacciones con la base de datos de mongoDB
}
