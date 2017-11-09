/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Carlos
 */
public class Familiar {
    private String nombre;
    private int edad;
    private String telefono;
    private String direccion;
    
    public Familiar(String nombre, int edad, String telefono, String direccion){
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public void postFamiliar(Connection con, int residenteId){
        String sql = "INSERT INTO Familiar (ID_Residente, Nombre, Edad, Telefono, Direccion) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.setInt(1, residenteId);
					statement.setString(2, nombre);
                                        statement.setInt(3,edad);
                                        statement.setString(4, telefono);
                                        statement.setString(5,direccion);
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
	} catch(Exception e){
            System.out.println("error");
        }
    }
}
