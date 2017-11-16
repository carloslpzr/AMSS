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
public class Receta {
    private int residente_id;
    private String nombre_doctor;
    private String medicamento;
    private String dosis;
    
    public Receta(int residente, String doctor, String medicamento, String dosis){
        this.residente_id = residente;
        this.nombre_doctor = doctor;
        this.medicamento = medicamento;
        this.dosis = dosis;
    }
}
