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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Carlos
 */
public class Info_Residente {
    Connection con;
    
    public Info_Residente(){
        con = SQLConnection.getInstance();
    }
    
    
    public ArrayList<ArrayList<String>> getResidentes(){
        ArrayList<ArrayList<String>> residentes = new ArrayList<ArrayList<String>>();
        ArrayList<String> row = new ArrayList<String>();
        String sql = "SELECT ID, Nombre FROM Residentes";
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                        row.add(resultSet.getString(1));
                        row.add(resultSet.getString(2));
                        residentes.add(row);
                        row = new ArrayList<String>();
                }
        } catch (Exception e) {
            System.out.println("Database error.");
        }
        return residentes;
    }
    
    public ArrayList<Object> getInfo(int id){
        ArrayList<Object> info = new ArrayList<Object>();
        
        Residente residente = new Residente();
        int cuartoID = residente.getResidente(con, id);
        info.add(residente);
        
        Cuarto cuarto = new Cuarto();
        cuarto.getCuartoInfo(con, cuartoID);
        info.add(cuarto);
        
        Familiar familiar = new Familiar();
        familiar.getFamiliar(con, id);
        info.add(familiar);
        
        SeguroMedico seguro = new SeguroMedico();
        seguro.getSeguro(con, id);
        info.add(seguro);
        
        HistorialMedico historial = new HistorialMedico();
        historial.getHistorial(con, id);
        info.add(historial);
        
        return info;
    }
}
