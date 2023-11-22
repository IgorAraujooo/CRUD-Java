package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Funcionario {
    private String nome, cargo, departamento;
    private int idFuncionario = 0;
    private double salario;

    public void cadastrarFuncionario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o Nome: ");
        this.nome = scanner.nextLine();
        System.out.println("Informe o Cargo: ");
        this.cargo = scanner.nextLine();
        System.out.println("Informe o Departamento: ");
        this.departamento = scanner.nextLine();
        System.out.println("Informe o Salario: ");
        this.salario = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("/---------------------------------/");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}