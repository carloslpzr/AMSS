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
public class HistorialMedico {
    private String operaciones;
    private String padecimientos;
    
    public HistorialMedico(String operaciones, String padecimientos){
        this.operaciones = operaciones;
        this.padecimientos = padecimientos;
    }
}
