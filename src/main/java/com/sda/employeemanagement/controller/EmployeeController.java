package com.sda.employeemanagement.controller;

import com.sda.employeemanagement.model.Employee;
import com.sda.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* /api/v1/employees */

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    //CRUD-create, read, update, delete

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    ;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeRepository.findById(id).get();
    }

    @DeleteMapping("/employees")
    public void deleteEmployees() {
        employeeRepository.deleteAll();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }

    @PutMapping("/employees/")
    public void addEmployee(Employee employee) {
        int id = employee.getId();
        if (!employeeRepository.existsById(id)) {
            employeeRepository.save(employee);
        }
    }
}
