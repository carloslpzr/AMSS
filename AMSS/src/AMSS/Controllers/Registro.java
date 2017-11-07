/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Controllers;
import AMSS.Models.Cuarto;
import AMSS.Models.Familiar;
import AMSS.Models.HistorialMedico;
import AMSS.Models.Residente;
import AMSS.Models.SeguroMedico;
import AMSS.SQLConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author Carlos
 */
public class Registro {
    private Connection con;
    
    public Registro(){
        con = SQLConnection.getInstance();
    }
    
    public void Registrar(Residente residente, Cuarto cuarto, Familiar familiar, HistorialMedico historial, SeguroMedico seguro){
        cuarto.post(con);
    }
    
}
