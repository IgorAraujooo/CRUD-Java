package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.controller.DepartamentoController;
import br.senai.sp.jandira.controller.FuncionarioController;
import br.senai.sp.jandira.model.Funcionario;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void executarMenu() throws SQLException {
        boolean continuar = true;

        while (continuar) {
            System.out.println("===============================================");
            System.out.println("              Bem Vindo ao Sistema             ");
            System.out.println("===============================================");
            System.out.println("                    M E N U                    ");
            System.out.println("===============================================");
            System.out.println(" 1 - Cadastrar Funcionário                     ");
            System.out.println(" 2 - Listar Funcionários                       ");
            System.out.println(" 3 - Deletar Funcionário                       ");
            System.out.println(" 4 - Pesquisar Funcionário                     ");
            System.out.println(" 5 - Atualizar Salário                         ");
            System.out.println(" 6 - Listar Departamentos                      ");
            System.out.println(" 7 - Sair                                      ");
            System.out.println("===============================================");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            FuncionarioController funcionarioController = new FuncionarioController();
            DepartamentoController departamentoController = new DepartamentoController();

            switch (opcao) {
                case 1:
                    Funcionario novoFuncionario = new Funcionario();
                    novoFuncionario.cadastrarFuncionario();
                    funcionarioController.cadastrarFuncionario(novoFuncionario);
                    break;
                case 2:
                    funcionarioController.listarFuncionarios();
                    break;
                case 3:
                    System.out.println("Informe o nome do funcionário que deseja deletar: ");
                    String nomeDeletar = scanner.nextLine();
                    funcionarioController.deletarFuncionarios(nomeDeletar);
                    break;
                case 4:
                    System.out.println("Informe o nome do funcionário que deseja pesquisar: ");
                    String nomePesquisar = scanner.nextLine();
                    funcionarioController.pesquisarFuncionario(nomePesquisar);
                    break;
                case 5:
                    System.out.println("Informe o nome do funcionário que deseja atualizar o salário: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.println("Informe o novo salário: ");
                    double novoSalario = scanner.nextDouble();
                    funcionarioController.atualizarSalario(nomeAtualizar, novoSalario);
                    break;
                case 6:
                    System.out.println("Listagem de Departamentos:");
                    departamentoController.listarDepartamentosSimples();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    break;
            }
        }
    }
}
