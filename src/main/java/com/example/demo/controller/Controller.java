package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class Controller {
    @Autowired
    EmpRepo repo;

    @GetMapping("/employees")
    public List<Employee> getAllEmp(){
       return repo.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id) { return repo.findById(id).get(); }
    
    @PostMapping("/employee/add")
    public String addEmployee(@RequestBody Employee employee){
        for(Employee E: repo.findAll()){
            if(E.getId()==employee.getId()){
                return ("Employee Already exist");
            }
        }repo.save(employee);
        return("Employee added");
    }

    @PutMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        for(Employee E: repo.findAll()){
            if(E.getId()==id){
                E.setEmpAge(employee.getEmpAge());
                E.setEmpDesignation(employee.getEmpDesignation());
                E.setEmpEmail(employee.getEmpEmail());
                E.setEmpFirstName(employee.getEmpFirstName());
                E.setEmpLastName(employee.getEmpLastName());
                E.setEmpSalary(employee.getEmpSalary());
                repo.save(E);
                return ("Employee updated successfully");
            }
        }return("Employee Not Found");
    }

    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        for(Employee E: repo.findAll()){
            if(E.getId()==id){
                repo.delete(E);
                return "Employee deleted";
            }
        }return "Invalid Operation";
    }
}
