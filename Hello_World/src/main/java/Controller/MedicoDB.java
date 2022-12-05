package Controller;

import Model.Medico;
import Model.Paciente;

import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDB extends Database{

    public boolean createMedico(Medico medico){
        connect();
        String sql = "INSERT INTO Medico(nomeMedico, idadeMedico, Especialidade, Salario, CPF, licencaMedico, Telefone,  Hospital_idHospital  ) VALUES (?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,medico.getNome());
            pst.setInt(2, medico.getIdade());
            pst.setString(3, medico.getEspecialidade());
            pst.setFloat(4, medico.getSalario());
            pst.setString(5, medico.getCpf());
            pst.setString(6,medico.getLidencaMedico());
            pst.setString(7,medico.getTelefone());
            pst.setInt(8, medico.getIdHospital());
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


    public boolean updateMedico(Medico atMedico){
        connect();
        String sql = "UPDATE Medico SET nomeMedico=?, Salario=?, Especialidade=?, idadeMedico=?, licencaMedico=? WHERE CPF=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, atMedico.getNome());
            pst.setFloat(2, atMedico.getSalario());
            pst.setString(3, atMedico.getEspecialidade());
            pst.setInt(4,atMedico.getIdade());
            pst.setString(5, atMedico.getLidencaMedico());
            pst.setString(6, atMedico.getCpf());
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

    public boolean deleteMedico(String cpf){
        connect();
        String sql = "DELETE FROM Medico WHERE CPF=?";
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

    public ArrayList<Medico> listaMedicosFiltrada(float max){
        connect();
        ArrayList<Medico> medicoList = new ArrayList<>();
        String sql = "SELECT * FROM Medico WHERE salario < ?";

        try{
            statement = connection.createStatement();
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, max);
            result = statement.executeQuery(sql);

            while(result.next()){
                Medico medico = new Medico(result.getString("nomeMedico"),result.getString("cpf"), result.getString("telefone"),result.getFloat("Salario"),result.getInt("idadeMedico"));
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CPF: " + medico.getCpf());
                System.out.println("Ultimo nome: " + medico.getTelefone());
                System.out.println("idade: "+medico.getIdade());
                System.out.println("---------------------------------");
                medicoList.add(medico);
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
        return medicoList;
    }
    public ArrayList<Medico> listaMedicos(){
        connect();
        ArrayList<Medico> medicoList = new ArrayList<>();
        String sql = "SELECT * FROM Medico";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Medico medico = new Medico(result.getString("nomeMedico"),result.getString("cpf"), result.getString("telefone"),result.getFloat("Salario"),result.getInt("idadeMedico"));
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CPF: " + medico.getCpf());
                System.out.println("idade: "+medico.getIdade());
                System.out.println("------------------------------------------------");
                medicoList.add(medico);
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
        return medicoList;
    }
}
