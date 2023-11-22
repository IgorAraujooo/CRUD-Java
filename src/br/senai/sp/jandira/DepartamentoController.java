package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Departamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoController {

    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();

    public List<Departamento> listarDepartamentos() throws SQLException {
        Statement statement = connection.createStatement();
        String queryConsulta = "SELECT * FROM departamento";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Departamento> departamentos = new ArrayList<>();

        while (resultSet.next()) {
            Departamento departamento = new Departamento();

            departamento.setIdDepartamento(resultSet.getInt("idDepartamento"));
            departamento.setNome(resultSet.getString("nome"));
            departamento.setSigla(resultSet.getString("sigla"));

            departamentos.add(departamento);
        }

        return departamentos;
    }

    public void listarDepartamentosSimples() throws SQLException {
        List<Departamento> departamentos = listarDepartamentos();

        for (Departamento departamento : departamentos) {
            System.out.println("Id: " + departamento.getIdDepartamento());
            System.out.println("Nome: " + departamento.getNome());
            System.out.println("Sigla: " + departamento.getSigla());
            System.out.println("/----------------------------------------------/");
        }
    }
}
