package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    Conexao conexao = new Conexao();

    Connection connection = conexao.getConnection();
    public void listarFuncionarios() throws SQLException {
        Statement statement = connection.createStatement();
        String queryConsulta = "SELECT * FROM funcionarios";

        ResultSet resultSet =  statement.executeQuery(queryConsulta);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){
            funcionario.setIdFuncionario(resultSet.getInt("id_funcionarios"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setCargo(resultSet.getString("cargo"));
            funcionario.setDepartamento(resultSet.getString("departamento"));
            funcionario.setDepartamento(resultSet.getString("salario"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getSalario());
            System.out.println("/----------------------------------------------/");
        }
    }

    public void deletarFuncionarios(String nome) throws SQLException {
        Statement statement = connection.createStatement();

        String queryDelete = "DELETE FROM funcionarios WHERE nome = '" + nome + "'";

        statement.executeUpdate(queryDelete);
        System.out.println("Usuario Deletado com sucesso...");
    }

    public void atualizarSalario(String nome, Double salario) throws SQLException {
        Statement statement = connection.createStatement();

        String queryAtualizar = "UPDATE funcionarios SET salario =" + salario + "WHERE nome ='" + nome + "'";

        statement.executeUpdate(queryAtualizar);
        System.out.println("Dados atualizado com sucesso!!");
    }

    public void pesquisarFuncionario(String nome) throws SQLException {
        Statement statement = connection.createStatement();

        String queryPesquisa = "SELECT * FROM funcionarios WHERE nome = '" + nome +"'";

        ResultSet resultSet = statement.executeQuery(queryPesquisa);

        List<Funcionario> listPesquisa = new ArrayList<>();

        while (resultSet.next()){

            Funcionario funcionario = new Funcionario();

            funcionario.setIdFuncionario(resultSet.getInt("id_funcionarios"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setCargo(resultSet.getString("cargo"));
            funcionario.setDepartamento(resultSet.getString("departamento"));
            funcionario.setDepartamento(resultSet.getString("salario"));

            listPesquisa.add(funcionario);
        }
        for (Funcionario funcionario : listPesquisa){
            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getSalario());
            System.out.println("/----------------------------------------------/");
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        Statement statement = connection.createStatement();

        String queryCadastro = "INSERT INTO funcionarios (id_funcionarios, nome, cargo, salario, departamento) values (" +
                funcionario.getIdFuncionario() + ",'" + funcionario.getNome() + "','" +
                funcionario.getCargo() + "'," + funcionario.getSalario() + ",'" +
                funcionario.getDepartamento() + "')"
                ;
            statement.executeUpdate(queryCadastro);
            System.out.println("Funcionário Cadastrado com sucesso !");
    }
}
