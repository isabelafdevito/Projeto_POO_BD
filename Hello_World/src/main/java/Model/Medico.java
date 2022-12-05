package Model;

public class Medico extends Funcionario{

    public String especialidade;
    private String lidencaMedico;
    private String telefone;
    private int idHospital;

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public Medico(){
        super();
    }

    public Medico(String nome, String cpf, String telefone, float salario, int idade) {
        super(nome, cpf, telefone, salario, idade);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getLidencaMedico() {
        return lidencaMedico;
    }

    public void setLidencaMedico(String lidencaMedico) {
        this.lidencaMedico = lidencaMedico;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
