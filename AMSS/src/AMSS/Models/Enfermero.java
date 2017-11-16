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
public class Enfermero {
    private String nombre;
    private int edad;
    private String turno;
    
    
    public Enfermero(String nombre, int edad, String turno){
        this.nombre = nombre;
        this.edad = edad;
        this.turno = turno;
    }
}
