package com.company;

import java.util.ArrayList;
import java.util.List;

public class Departamento<T extends FuncionarioControlavel>{
    private final String nome;
    private final List<T> funcionariosBativeis;
    private final List<Gerente> gerentes;

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionariosBativeis = new ArrayList<>();
        this.gerentes = new ArrayList<>();
    }

    public void addFuncionario(T funcionario, Gerente gerente){
        funcionariosBativeis.add(funcionario);
        gerentes.add(gerente);
    }

    public List<Funcionario> listarFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>(funcionariosBativeis);
        funcionarios.addAll(gerentes);

        return funcionarios;
    }

    public List<FuncionarioControlavel> listarAtrasados(float horarioLimite){
        List<FuncionarioControlavel> atrasados= new ArrayList<>();

        for(FuncionarioControlavel funcionario : funcionariosBativeis){
            if (funcionario.horarioEntrada > horarioLimite){
                atrasados.add(funcionario);
            }
        }

        return atrasados;
    }
}
