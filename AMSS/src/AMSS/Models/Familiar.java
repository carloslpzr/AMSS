/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;

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
}
