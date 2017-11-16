/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Carlos
 */
public class HistorialMedico {
    private String operaciones;
    private String padecimientos;
    
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
    
    
}
