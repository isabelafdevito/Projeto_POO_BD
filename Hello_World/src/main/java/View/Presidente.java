package View;

import Controller.EnfermeiraDB;
import Controller.HospitalDB;
import Controller.MedicoDB;
import Controller.PredioDB;
import Model.Enfermeira;
import Model.Hospital;
import Model.Medico;
import Model.Predio;

import java.util.Scanner;
public class Presidente {
    private int op;
    public void informativo(){
        MedicoDB medicoDB = new MedicoDB();
        Enfermeira enfermeira = new Enfermeira();
        EnfermeiraDB enfermeiraDB = new EnfermeiraDB();
        Hospital hospital = new Hospital();
        HospitalDB hospitalDB = new HospitalDB();
        Predio predio = new Predio();
        PredioDB predioDB = new PredioDB();


        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo presidente!");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar novo medico");
        System.out.println("2 - Cadastrar nova enfermeira");
        System.out.println("3 - Deletar medico");
        System.out.println("4 - Deletar enfermeira");
        System.out.println("5 - Alterar dados medico");
        System.out.println("6 - Alterar dados enfermeira");
        System.out.println("7 - Cadastrar Hospital");
        System.out.println("8 - Alugar predio");
        op = sc.nextInt();
        sc.nextLine();
        switch (op){
            case 1:
                Medico medico = new Medico();
                System.out.println("Digite a especialidade do medico");
                medico.especialidade = sc.nextLine();
                System.out.println("Digite o cpf do Medico");
                medico.setCpf(sc.nextLine());
                System.out.println("Digite o telefone");
                medico.setTelefone(sc.nextLine());
                System.out.println("Digite o nome do medico");
                medico.setNome(sc.nextLine());
                System.out.println("Digite a licenca do medico");
                medico.setLidencaMedico(sc.nextLine());
                System.out.println("Digite para qual hospital ele trabalha");
                medico.setIdHospital(sc.nextInt());
                System.out.println("Digite o salario");
                medico.setSalario(sc.nextFloat());
                sc.nextLine();
                System.out.println("Digite a idade do Medico");
                medico.setIdade(sc.nextInt());
                sc.nextLine();
                medicoDB.createMedico(medico);
                break;
            case 2:
                System.out.println("Digite o cpf da enfermeira");
                enfermeira.setCpf(sc.nextLine());
                System.out.println("Digite o nome da enfermeira");
                enfermeira.setNome(sc.nextLine());
                System.out.println("Digite para qual hospital ela trabalha");
                enfermeira.setIdHospitall(sc.nextInt());
                System.out.println("Digite o salario");
                enfermeira.setSalario(sc.nextFloat());
                System.out.println("Digite o telefone");
                enfermeira.setTelefone(sc.nextLine());
                System.out.println("Digite a idade da enfermeira");
                enfermeira.setIdade(sc.nextInt());
                System.out.println("Digite a quantidade de horas que ela trabalha");
                enfermeira.setHorasTrabalhadas(sc.nextInt());
                enfermeiraDB.createEnfermeira(enfermeira);
                break;
            case 3:
                System.out.println("Digite o CPF do medico que deseja deletar");
                String cpfDelete = sc.nextLine();
                medicoDB.deleteMedico(cpfDelete);
                break;
            case 4:
                System.out.println("Digite o CPF da enfermeira que deseja deletar");
                String cpfDelete1 = sc.nextLine();
                enfermeiraDB.deleteEnfermeira(cpfDelete1);
                break;
            case 5:
                Medico medico1= new Medico();
                System.out.println("Digite a especialidade do medico");
                medico1.especialidade = sc.nextLine();
                System.out.println("Digite o cpf do Medico");
                medico1.setCpf(sc.nextLine());
                System.out.println("Digite o telefone");
                medico1.setTelefone(sc.nextLine());
                System.out.println("Digite o nome do medico");
                medico1.setNome(sc.nextLine());
                System.out.println("Digite a licenca do medico");
                medico1.setLidencaMedico(sc.nextLine());
                System.out.println("Digite para qual hospital ele trabalha");
                medico1.setIdHospital(sc.nextInt());
                System.out.println("Digite o salario");
                medico1.setSalario(sc.nextFloat());
                sc.nextLine();
                System.out.println("Digite a idade do Medico");
                medico1.setIdade(sc.nextInt());
                sc.nextLine();
                medicoDB.updateMedico(medico1);

                break;
            case 6:
                System.out.println("Digite o cpf da enfermeira que deseja alterar");
                enfermeira.setCpf(sc.nextLine());
                System.out.println("Digite o nome da enfermeira");
                enfermeira.setNome(sc.nextLine());
                System.out.println("Digite para qual hospital ela trabalha");
                enfermeira.setIdHospitall(sc.nextInt());
                System.out.println("Digite o salario");
                enfermeira.setSalario(sc.nextFloat());
                System.out.println("Digite o telefone");
                enfermeira.setTelefone(sc.nextLine());
                System.out.println("Digite a idade da enfermeira");
                enfermeira.setIdade(sc.nextInt());
                System.out.println("Digite a quantidade de horas que ela trabalha");
                enfermeira.setHorasTrabalhadas(sc.nextInt());
                enfermeiraDB.updateEnfermeira(enfermeira);
                break;

            case 7:
                System.out.println("Cadastrar novo hospital");
                System.out.println("Digite o CNPJ do hospital");
                hospital.setCNPJ(sc.nextLine());
                System.out.println("Digite a quantidade de funcionarios do hospital");
                hospital.setQntFunc(sc.nextInt());
                System.out.println("Digite o id do hospital");
                hospital.setIdHospital(sc.nextInt());
                hospitalDB.createHospital(hospital);

                break;
            case 8:
                System.out.println("Alugar predio");
                System.out.println("Digite a loocalizacao");
                predio.setLocalizacao(sc.nextLine());
                System.out.println("Digite o id do predio");
                predio.setIdPredio(sc.nextInt());
                System.out.println("Digite quanto possui de espaco");
                predio.setEspaco(sc.nextInt());
                System.out.println("Digite quantas salas ele possui");
                predio.setQntSalas(sc.nextInt());
                predioDB.createPredio(predio);
                break;

        }
    }
}
