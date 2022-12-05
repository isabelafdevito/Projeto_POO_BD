package View;

import java.util.Scanner;

import Controller.ConsultaDB;
import Controller.MedicoDB;

public class Paciente {
    private int op;
    public void informativo(){
        Scanner sc = new Scanner(System.in);
        MedicoDB medicoDB = new MedicoDB();

        System.out.println("Seja bem vindo ao nosso hospital");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Fazer uma consulta com um medico");
        System.out.println("2 - Verificar lista de medicos");
        op = sc.nextInt();
        sc.nextLine();
        switch (op){
            case 1:
                System.out.println("Digite seu CPF");
                String cpfPaciente = sc.nextLine();
                System.out.println("Digite o CPF do medico que deseja consultar");
                String cpfMedico = sc.nextLine();
                System.out.println("Digite a data da consulta");
                String data = sc.nextLine();
                System.out.println("Digite o que voce esta sentindo");
                String problema = sc.nextLine();
                ConsultaDB consultaDB = new ConsultaDB();
                consultaDB.createConsulta(cpfPaciente,cpfMedico,data,problema);
                break;
            case 2:
                System.out.println("Visualizar Medicos");
                medicoDB.listaMedicos();
                break;

        }
    }
}
