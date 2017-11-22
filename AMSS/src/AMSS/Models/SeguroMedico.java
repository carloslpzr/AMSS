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
/**
 *
 * @author Carlos
 */
public class SeguroMedico {
    private String compania;
    private String clave;
    private Date fechaAdquisicion;
    private Date fechaVencimiento;
    
    public SeguroMedico(){
        
    }
    
    public SeguroMedico(String compania, String clave, Date fechaAdq, Date fechaVen){
        this.compania = compania;
        this.clave = clave;
        this.fechaAdquisicion = fechaAdq;
        this.fechaVencimiento = fechaVen;
    }
    
    public void postSeguro(Connection con, int residenteId){
        String sql = "INSERT INTO SeguroMedico (ID_Residente, Compania, Clave, FechaAdquisicion, FechaVencimiento) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.setInt(1, residenteId);
					statement.setString(2, compania);
                                        statement.setString(3, clave);
                                        statement.setDate(4, fechaAdquisicion);
                                        statement.setDate(5, fechaVencimiento);
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
	} catch(Exception e){
            System.out.println("error");
        }
    }

    public String getCompania() {
        return compania;
    }

    public String getClave() {
        return clave;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public void getSeguro(Connection con, int id){
        String sql = "SELECT Compania, Clave, FechaAdquisicion, FechaVencimiento FROM SeguroMedico WHERE ID_Residente = " + id;
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                resultSet.next();
                this.compania = resultSet.getString(1);
                this.clave = resultSet.getString(2);
                this.fechaAdquisicion = resultSet.getDate(3);
                this.fechaVencimiento = resultSet.getDate(4);
        } catch (Exception e){
            
        }
    }
    
    
}
