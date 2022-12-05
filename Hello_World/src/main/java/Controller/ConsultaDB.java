package Controller;

import Model.Consulta;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDB extends Database{

    public boolean createConsulta(String cpfPaciente, String cpfMedico, String data, String problema){
        connect();
        String sql = "INSERT INTO Consulta(Paciente_cpf, Medico_CPF, problemaConsulta, dataConsulta) VALUES (?,?,?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1,cpfPaciente);
            pst.setString(2, cpfMedico);
            pst.setString(3, data);
            pst.setString(4, problema);
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
    public  ArrayList<Consulta> verConsultas(String cpfPaciente){
        connect();
        ArrayList<Consulta> consultaList = new ArrayList<>();
        String sql = "SELECT * FROM Consulta WHERE Paciente_cpf=?";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Consulta consulta = new Consulta(result.getString("Paciente_cpf"),result.getString("Medico_CPF"),result.getString("problemaConsulta"), result.getString("dataConsulta"));
                System.out.println("CPF do paciente: " + consulta.getCpfPaciente());
                System.out.println("CPF do Medico: " + consulta.getCpfMedico());
                System.out.println("Data: " + consulta.getData());
                System.out.println("Ocorrencia: "+consulta.getProblema());
                System.out.println("---------------------------------");
                consultaList.add(consulta);
            }

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
        return consultaList;
    }
}
