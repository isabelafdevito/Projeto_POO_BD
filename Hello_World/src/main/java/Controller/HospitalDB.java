package Controller;

import Model.Hospital;
import Model.Paciente;

import java.sql.SQLException;

public class HospitalDB extends Database{
    public boolean createHospital(Hospital hospital){
        connect();
        String sql = "INSERT INTO Hospital(idHospital, CNPJ, quantFunc) VALUES (?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,hospital.getIdHospital());
            pst.setString(2, hospital.getCNPJ());
            pst.setInt(3, hospital.getQntFunc());
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
