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
public class Medicamento {
    private int id_Residente;
    private String nombre;
    private String tipo;
    private int hora;
    private int contenido;
    private String notificacion;
    private int dosis;
    
    public Medicamento(int id, String nombre, String tipo, int hora, int contenido, String notificacion, int dosis){
        this.id_Residente = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.hora = hora;
        this.contenido = contenido;
        this.notificacion = notificacion;
        this.dosis = dosis;
    }
    
    public void postMeds(Connection con, String lot){
        String tipoDosis;
        if(lot.equals("Contenido")){
            tipoDosis = "Dosis";
        } else {
            tipoDosis = "DosisML";
        }
        String sql = "INSERT INTO Medicamento (ID_Residente, Nombre, Tipo, Hora, " + lot + ", Notificacion, " + tipoDosis + ") VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.setInt(1, id_Residente);
					statement.setString(2,nombre);
                                        statement.setString(3, tipo);
                                        statement.setInt(4,hora);
                                        statement.setInt(5,contenido);
                                        statement.setString(6, notificacion);
                                        statement.setInt(7,dosis);
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
	} catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
