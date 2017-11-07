/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;
import java.sql.Date;
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
}
