package com.example.restaurant.controller;

import com.example.restaurant.Employee;
import com.example.restaurant.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final List<Employee> employees = new ArrayList<>();

    @GetMapping
    public List<EmployeesRespondeDTO> getAll() {
        return employees.stream().map(EmployeesRespondeDTO::new).toList();
    }

    @PostMapping
    public void addMeal(@RequestBody EmployeesRespondeDTO data){
        employees.add(new Employee(data));
    }

    @DeleteMapping
    public void deleteMeal(@RequestBody Long id){
        try {
            //Isso aqui ta muito errado, mas o unico momento em que daria erro, seria em um overflow do ID, o que não deve ocorrer,
            // ja que a Lista esta sendo utilisada apenas para prototipação. Por este mesmo motivo usamos bancos de dados.
            employees.remove(Math.toIntExact(id));
        }catch (IndexOutOfBoundsException | ArithmeticException ignored){}
    }

    @PutMapping("/{id}")
    public void editMeal(@RequestBody EmployeesRespondeDTO data, @PathVariable Long id){

        try{
            Employee employee = employees.get((int)id.longValue());
            employee.setName(data.name());
            employee.setCpf(data.cpf());
            employees.set((int)id.longValue(), employee);
        }catch (IndexOutOfBoundsException e) {
            employees.add(new Employee(data.id(), data.name(), data.cpf()));
        }
    }
}
