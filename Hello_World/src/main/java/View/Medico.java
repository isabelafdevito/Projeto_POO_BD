package View;

import java.util.Scanner;

import Controller.PacienteDB;
import Model.Paciente;
public class Medico {
    private int op;
    public void informativo(){
        Scanner sc = new Scanner(System.in);
        PacienteDB pacienteDB = new PacienteDB();
        System.out.println("Bem vindo doutor!");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Fazer cadastro de paciente");
        System.out.println("2 - Atualizar paciente");
        System.out.println("3 - Deletar paciente");
        System.out.println("4 - Verificar lista de pacientes");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                System.out.println("Criar Novo Paciente");
                Model.Paciente paciente = new Model.Paciente();
                System.out.println("Insira o primeiro nome do Paciente");
                paciente.setpNome(sc.nextLine());
                System.out.println("Insira o ultimo nome do Paciente");
                paciente.setuNome(sc.nextLine());
                System.out.println("Insira a idade do paciente");
                paciente.setIdade(sc.nextInt());
                sc.nextLine();
                System.out.println("Insira o CPF do Paciente");
                paciente.setCpf(sc.nextLine());
                pacienteDB.createPaciente(paciente);
                break;

            case 2:
                System.out.println("Atualizar Paciente:");
                Model.Paciente paciente1 = new Model.Paciente();
                System.out.println("Insira o CPF do Paciente que deseja alterar");
                paciente1.setCpf(sc.nextLine());
                System.out.println("Insira o primeiro nome do Paciente");
                paciente1.setpNome(sc.nextLine());
                System.out.println("Insira o ultimo nome do Paciente");
                paciente1.setuNome(sc.nextLine());
                System.out.println("Insira a idade do paciente");
                paciente1.setIdade(sc.nextInt());
                pacienteDB.updatePaciente(paciente1);
                break;
            case 3:
                System.out.println("Atualizar Paciente:");
                String CPFdelete;
                System.out.println("Insira o CPF do Paciente que deseja alterar");
                CPFdelete = sc.nextLine();
                pacienteDB.deletePaciente(CPFdelete);
                break;
            case 4:
                System.out.println("Visualizar Pacientes");
                pacienteDB.listaPacientes();
                break;
        }
    }
}
