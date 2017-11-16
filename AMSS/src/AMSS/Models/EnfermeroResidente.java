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
public class EnfermeroResidente {
    private int residente_id;
    private int enfermero_id;
    
    public EnfermeroResidente(int res, int enf){
        this.residente_id = res;
        this.enfermero_id = enf;
    }
}
