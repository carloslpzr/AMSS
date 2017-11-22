/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class Familiar {
    private String nombre;
    private int edad;
    private String telefono;
    private String direccion;
    
    public Familiar(){
        
    }
    
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void getFamiliar(Connection con, int id){
        String sql = "SELECT Nombre, Edad, Telefono, Direccion FROM Familiar WHERE ID_Residente = " + id;
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                resultSet.next();
                this.nombre = resultSet.getString(1);
                this.edad = resultSet.getInt(2);
                this.telefono = resultSet.getString(3);
                this.direccion = resultSet.getString(4);
        } catch (Exception e){
            
        }
    }
}
