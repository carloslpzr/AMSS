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
public class HistorialMedico {
    private String operaciones;
    private String padecimientos;
    
    public HistorialMedico(){
        
    }
    
    public HistorialMedico(String operaciones, String padecimientos){
        this.operaciones = operaciones;
        this.padecimientos = padecimientos;
    }
    
    public void postHistorial(Connection con, int residenteId){
        String sql = "INSERT INTO HistorialMedico (ID_Residente, Operaciones, Padecimientos) VALUES (?, ?, ?);";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.setInt(1, residenteId);
					statement.setString(2, operaciones);
                                        statement.setString(3, padecimientos);
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
	} catch(Exception e){
            System.out.println("error");
        }
    }

    public String getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(String operaciones) {
        this.operaciones = operaciones;
    }

    public String getPadecimientos() {
        return padecimientos;
    }

    public void setPadecimientos(String padecimientos) {
        this.padecimientos = padecimientos;
    }
    
    public void getHistorial(Connection con, int id){
        String sql = "SELECT Operaciones, Padecimientos FROM HistorialMedico WHERE ID_Residente = " + id;
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                resultSet.next();
                this.operaciones = resultSet.getString(1);
                this.padecimientos = resultSet.getString(2);
        } catch (Exception e){
            
        }
    } 
}
