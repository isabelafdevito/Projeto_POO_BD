package Model;

public class Paciente {
    private String pNome;
    private String uNome;
    private int idade;
    private String cpf;

    public Paciente(){}
    public Paciente(String pNome, String uNome, int idade, String cpf) {
        this.pNome = pNome;
        this.uNome = uNome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getpNome() {
        return pNome;
    }

    public void setpNome(String pNome) {
        this.pNome = pNome;
    }

    public String getuNome() {
        return uNome;
    }

    public void setuNome(String uNome) {
        this.uNome = uNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

  public void marcaConsulta(){

    }

  public void mostrarInfo(){

    }
}
