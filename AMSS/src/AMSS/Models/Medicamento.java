/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author Carlos
 */
public class Medicamento {
    private int id_Residente;
    private String nombre;
    private String tipo;
    private int contenido;
    private String notificacion;
    private int dosis;
    private Boolean manana;
    private Boolean tarde;
    private Boolean noche;
    
    public Medicamento(int id, String nombre, String tipo, int contenido, String notificacion, int dosis, Boolean manana, Boolean tarde, Boolean noche){
        this.id_Residente = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
        this.notificacion = notificacion;
        this.dosis = dosis;
        this.manana = manana;
        this.tarde = tarde;
        this.noche = noche;
    }
    
    public void postMeds(Connection con, String lot){
        String tipoDosis;
        if(lot.equals("Contenido")){
            tipoDosis = "Dosis";
        } else {
            tipoDosis = "DosisML";
        }
        String sql = "INSERT INTO Medicamento (ID_Residente, Nombre, Tipo, " + lot + ", " + tipoDosis + ", Manana, Tarde, Noche, FechaComienzo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.setInt(1, id_Residente);
					statement.setString(2,nombre);
                                        statement.setString(3, tipo);
                                        statement.setInt(4,contenido);
                                        statement.setInt(5,dosis);
                                        statement.setBoolean(6, manana);
                                        statement.setBoolean(7, tarde);
                                        statement.setBoolean(8, noche);
                                        statement.setDate(9, Date.valueOf(LocalDate.now()));
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
	} catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
