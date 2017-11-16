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
public class Eventualidad {
    private int residente_id;
    private String acontecimiento;
    private int receta_id;
    private Date fecha;
    
    public Eventualidad(int residente, String acontecimiento, int receta, Date fecha){
        this.residente_id = residente;
        this.acontecimiento = acontecimiento;
        this.receta_id = receta;
        this.fecha = fecha;
    }
}
