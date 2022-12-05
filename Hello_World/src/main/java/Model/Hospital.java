package Model;

public class Hospital {
    private String CNPJ;
    private int qntFunc;
    private int idHospital;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getQntFunc() {
        return qntFunc;
    }

    public void setQntFunc(int qntFunc) {
        this.qntFunc = qntFunc;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }
}
