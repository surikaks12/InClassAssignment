package com.company.controller;

import com.company.entity.Employee;
import com.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    List<Employee> emp = new ArrayList<>();

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees/age/{age}")
    public @ResponseBody
    List<Employee> getByFiltedAge(@PathVariable int age) {
        List<Employee> filteredList;

        filteredList = emp.stream()
                .filter(x -> x.getEmployee_age() > age)
                .collect(Collectors.toList());
        return filteredList;
    }

    public List<Employee> all() {
        emp = employeeRepository.findAll();
        return emp;
    }

}