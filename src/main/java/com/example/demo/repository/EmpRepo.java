package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepo extends MongoRepository <Employee,Integer>{

}
