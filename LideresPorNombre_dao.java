package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.vo.LideresPorNombre;
import reto4.util.JDBC_utilities;

public class LideresPorNombre_dao{
    public ArrayList<LideresPorNombre> requerimiento3() throws SQLException{
        ArrayList <LideresPorNombre> respuesta = new ArrayList<LideresPorNombre>();
        Connection conect = JDBC_utilities.getConnection();

        try {
            String consulta = "SELECT ID_Lider, Nombre, Primer_Apellido "+
            "FROM Lider "+
            "WHERE Primer_Apellido LIKE '%z' "+
            "ORDER BY Nombre ";

            PreparedStatement statement = conect.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                LideresPorNombre nombre = new LideresPorNombre();
                
                nombre.setId_lider(resultado.getInt("ID_Lider"));
                nombre.setNombre(resultado.getString("Nombre"));
                nombre.setApellido(resultado.getString("Primer_Apellido"));

                respuesta.add(nombre);
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
