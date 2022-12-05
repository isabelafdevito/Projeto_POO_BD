package Model;

public class Consulta {
    private String cpfPaciente;
    private String cpfMedico;
    private String problema;
    private String data;

    public Consulta(String cpfPaciente, String cpfMedico, String problema, String data) {
        this.cpfPaciente = cpfPaciente;
        this.cpfMedico = cpfMedico;
        this.problema = problema;
        this.data = data;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getCpfMedico() {
        return cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
