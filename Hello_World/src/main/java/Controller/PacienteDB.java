package Controller;

import Model.Paciente;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDB extends Database {
    public boolean createPaciente(Paciente paciente){
        connect();
        String sql = "INSERT INTO Paciente(pNome, Idade, uNome, CPF) VALUES (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,paciente.getpNome());
            pst.setInt(2, paciente.getIdade());
            pst.setString(3, paciente.getuNome());
            pst.setString(4, paciente.getCpf());
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


    public boolean updatePaciente(Paciente atPaciente){
        connect();
        String sql = "UPDATE Paciente SET pNome=?, uNome=?, Idade=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, atPaciente.getpNome());
            pst.setString(2, atPaciente.getuNome());
            pst.setInt(3, atPaciente.getIdade());
            pst.setString(4, atPaciente.getCpf());
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

    public boolean deletePaciente(String cpf){
        connect();
        String sql = "DELETE FROM Paciente WHERE cpf=?";
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
    public ArrayList<Paciente> listaPacientes(){
        connect();
        ArrayList<Paciente> pacienteList = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Paciente pac = new Paciente(result.getString("pNome"),result.getString("uNome"),result.getInt("Idade"), result.getString("cpf"));
                System.out.println("Primeiro nome: " + pac.getpNome());
                System.out.println("Ultimo nome: " + pac.getuNome());
                System.out.println("CPF: " + pac.getCpf());
                System.out.println("idade: "+pac.getIdade());
                System.out.println("---------------------------------");
                pacienteList.add(pac);
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return pacienteList;
    }
}
