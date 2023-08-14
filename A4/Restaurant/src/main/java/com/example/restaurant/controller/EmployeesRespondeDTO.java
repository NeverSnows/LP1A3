package com.example.restaurant.controller;

import com.example.restaurant.Employee;

public record EmployeesRespondeDTO(Long id, String name, String cpf) {
    public EmployeesRespondeDTO(Employee employee){
        this(employee.getId(), employee.getName(), employee.getCpf());
    }
}
