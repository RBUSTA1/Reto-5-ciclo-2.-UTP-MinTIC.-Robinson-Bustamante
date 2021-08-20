package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.vo.LiderPorSalario;
import reto4.util.JDBC_utilities;

public class LiderPorSalario_dao{
    public ArrayList<LiderPorSalario> requerimiento1() throws SQLException{
        ArrayList <LiderPorSalario> respuesta = new ArrayList<LiderPorSalario>();
        Connection conect = JDBC_utilities.getConnection();

        try {
            String consulta = "SELECT id_Lider, Nombre, Primer_Apellido, salario " +
                            "FROM Lider WHERE salario <= 500000 ORDER BY salario ";

            PreparedStatement statement = conect.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                LiderPorSalario salario = new LiderPorSalario();
                
                salario.setNombre(resultado.getString("Nombre"));
                salario.setId_lider(resultado.getInt("id_lider"));
                salario.setSalario(resultado.getInt("salario"));
                salario.setApellido(resultado.getString("Primer_Apellido"));

                respuesta.add(salario);
            }

            resultado.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Se ha generado el siguiente error: " + e);
        } finally {
            if(conect != null){
                conect.close();
            }
        }
        return respuesta;
    }
}
