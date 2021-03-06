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
import java.sql.Statement;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Residente(){
    }
    
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
    
    public int getResidente(Connection con, int id){
        String[] names;
        String sql = "SELECT Nombre, fechaNacimiento, FechaLlegada, ID_Cuarto FROM Residentes WHERE ID = " + id;
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                resultSet.next();
                names = resultSet.getString(1).split(" ");
                this.nombre = names[0];
                this.apellidos = "";
                for(int i = 1; i < names.length; i++){
                    if(names[i] != null && !names[i].isEmpty()){
                        this.apellidos += names[i];
                    }
                }
                this.fechaNacimiento = resultSet.getDate(2);
                this.fechaLlegada = resultSet.getDate(3);
                return resultSet.getInt(4);
        } catch (Exception e){
            
        }
        return -1;
    }
}
