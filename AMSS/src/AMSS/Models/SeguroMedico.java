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
public class SeguroMedico {
    private String compania;
    private String clave;
    private Date fechaAdquisicion;
    private Date fechaVencimiento;
    
    public SeguroMedico(String compania, String clave, Date fechaAdq, Date fechaVen){
        this.compania = compania;
        this.clave = clave;
        this.fechaAdquisicion = fechaAdq;
        this.fechaVencimiento = fechaVen;
    }
}
