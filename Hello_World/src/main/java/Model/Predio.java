package Model;

public class Predio {
    public String localizacao;
    private int idPredio;
    private int qntSalas;
    private int espaco;

    private int idhospital;



    void mostrarInfo(){
        System.out.println("Infos do Predio");
        System.out.println("Localizacao: " + localizacao);
        System.out.println("Quantidades de salas para atendimento: "+ qntSalas);
        System.out.println("Espaço do predio: "+espaco+"m²");
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(int idPredio) {
        this.idPredio = idPredio;
    }

    public int getQntSalas() {
        return qntSalas;
    }

    public void setQntSalas(int qntSalas) {
        this.qntSalas = qntSalas;
    }

    public int getEspaco() {
        return espaco;
    }

    public void setEspaco(int espaco) {
        this.espaco = espaco;
    }

    public int getIdhospital() {
        return idhospital;
    }

    public void setIdhospital(int idhospital) {
        this.idhospital = idhospital;
    }
}
