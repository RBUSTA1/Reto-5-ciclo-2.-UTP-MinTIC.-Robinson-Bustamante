package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.vo.ProyectoPorTipo;
import reto4.util.JDBC_utilities;

public class ProyectoPorTipo_dao{
    public ArrayList<ProyectoPorTipo> requerimiento2() throws SQLException{
        ArrayList <ProyectoPorTipo> respuesta = new ArrayList<ProyectoPorTipo>();
        Connection conect = JDBC_utilities.getConnection();

        try {
            String consulta = "SELECT ID_Proyecto, Constructora, Ciudad, Estrato "+
            "FROM Proyecto "+
            "INNER JOIN Tipo "+
            "ON Proyecto.ID_Tipo = Tipo.ID_Tipo "+
            "WHERE Ciudad = 'Cartagena'"+
            "ORDER BY Estrato ";

            PreparedStatement statement = conect.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                ProyectoPorTipo tipo = new ProyectoPorTipo();
                
                tipo.setId_p(resultado.getInt("Id_Proyecto"));
                tipo.setConstructora(resultado.getString("Constructora"));
                tipo.setCiudad(resultado.getString("Ciudad"));
                tipo.setEstrato(resultado.getInt("Estrato"));

                respuesta.add(tipo);
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
