package Controller;

import Model.Enfermeira;
import Model.Medico;

import java.sql.SQLException;

public class EnfermeiraDB extends Database{
    public boolean createEnfermeira(Enfermeira enfermeira){
        connect();
        String sql = "INSERT INTO Enfermeira(NomeEnfermeira, idadeEnfermeira, Salario, CPF, HorasTrabalhadas , Hospital_idHospital ) VALUES (?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,enfermeira.getNome());
            pst.setInt(2, enfermeira.getIdade());
            pst.setFloat(3, enfermeira.getSalario());
            pst.setString(4, enfermeira.getCpf());
            pst.setInt(5,enfermeira.getHorasTrabalhadas());
            pst.setInt(6, enfermeira.getIdHospitall());
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


    public boolean updateEnfermeira(Enfermeira atEnfermeira){
        connect();
        String sql = "UPDATE Enfermeira SET nome=?, Salario=?, HorasTrabalhadas=? WHERE CPF=?";
        try{
            pst = connection.prepareStatement(sql);
            pst = connection.prepareStatement(sql);
            pst.setString(1,atEnfermeira.getNome());
            pst.setInt(2, atEnfermeira.getIdade());
            pst.setFloat(3, atEnfermeira.getSalario());
            pst.setString(4, atEnfermeira.getCpf());
            pst.setInt(5,atEnfermeira.getHorasTrabalhadas());
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
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

    public boolean deleteEnfermeira(String cpf){
        connect();
        String sql = "DELETE FROM Enfermeira WHERE CPF=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
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
