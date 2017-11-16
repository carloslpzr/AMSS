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
public class RegistroSalidas {
    private int residente_id;
    private Date fechaSalida;
    private Date fechaRegreso;
    private String nombreResponsable;
    private String parentesco;
    
    public RegistroSalidas(int residente, Date fechaS, Date fechaR, String responsable, String parentesco){
        this.residente_id = residente;
        this.fechaSalida = fechaS;
        this.fechaRegreso = fechaR;
        this.nombreResponsable = responsable;
        this.parentesco = parentesco;
    }
}
