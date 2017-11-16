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
public class ServicioEmergencia {
    private int residente_id;
    private String telefono_servicio;
    private String telefono_persona;
    private String responsable;
    
    public ServicioEmergencia(int residente, String telefonoS, String telefonoP, String responsable){
        this.residente_id = residente;
        this.telefono_persona = telefonoP;
        this.telefono_servicio = telefonoS;
        this.responsable = responsable;
    }
}
