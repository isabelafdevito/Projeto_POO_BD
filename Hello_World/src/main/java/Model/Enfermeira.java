package Model;

public class Enfermeira extends Funcionario {
    private int horasTrabalhadas;
    private int idHospitall;

    public Enfermeira() {

    }

    public int getIdHospitall() {
        return idHospitall;
    }

    public void setIdHospitall(int idHospitall) {
        this.idHospitall = idHospitall;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Enfermeira(String nome, int idade, String telefone, float salario, String cpf) {
        super(nome, cpf, telefone, salario,idade );
    }
}
