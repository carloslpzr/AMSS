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
import java.time.Period;
/**
 *
 * @author Carlos
 */
public class Residente {
    private String nombre;
    private String apellidos;
    private Date fechaLlegada;
    private Date fechaNacimiento;
    
    public Residente(String nombre, String apellidos, Date fechaLlegada, Date fechaNacimiento){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaLlegada = fechaLlegada;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int postResidente(Connection con,int cuartoId){
        LocalDate birthdate = fechaNacimiento.toLocalDate();
        LocalDate now = LocalDate.now();
        int edad = Period.between(birthdate, now).getYears();
        String sql = "INSERT INTO Residentes (Nombre, Edad, FechaLlegada, ID_Cuarto, Status) VALUES (?, ?, ?, ?, 'Activo');";
        try (PreparedStatement statement = con.prepareStatement(sql, new String[]{"ID_Residente"})) {
					statement.setString(1, nombre + " " + apellidos );
					statement.setInt(2, edad);
                                        statement.setDate(3,fechaLlegada);
                                        statement.setInt(4, cuartoId);
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
                                        ResultSet rs = statement.getGeneratedKeys();
                                        if(rs.next()){
                                            int id = rs.getInt(1);
                                            return id;
                                        }
	} catch(Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
    
}
