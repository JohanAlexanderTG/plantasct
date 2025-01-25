package com.mycompany.plantasct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Plantasct {
    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/plantasct";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM productos");
            while(rs.next ()){
                System.out.println(rs.getString("Nombre"));
            
            }
            
            //Inserción de datos - Actualización de datos - Eliminar datos 
            statement.execute("INSERT INTO `productos` (`id_producto`, `Nombre`, `Descripción`, `Precio`) VALUES ('07', 'Lombricompost', 'Abono organico', '15000'); ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM productos");
            while(rs.next ()){
                System.out.println(rs.getString("Nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Plantasct.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}

