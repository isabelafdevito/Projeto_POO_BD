package Controller;

import Model.Predio;

import java.sql.SQLException;

public class PredioDB extends Database{
    public boolean createPredio(Predio predio){
        connect();
        String sql = "INSERT INTO medico(idPredio, Hospital_idHospital, Localizacao, Espaco, qntSalas ) VALUES (?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,predio.getIdPredio());
            pst.setInt(2, predio.getIdhospital());
            pst.setString(3, predio.getLocalizacao());
            pst.setInt(4, predio.getEspaco());
            pst.setInt(5, predio.getQntSalas());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
