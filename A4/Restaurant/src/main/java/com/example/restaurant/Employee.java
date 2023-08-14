package com.example.restaurant;

import com.example.restaurant.controller.EmployeesRespondeDTO;
import com.example.restaurant.controller.MenuResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private static Long idBase = 0L;
    private Long id;
    private String name;
    private String cpf;

    public Employee(EmployeesRespondeDTO data){
        this.id = idBase++;
        this.name = data.name();
        this.cpf = data.cpf();
    }
}
