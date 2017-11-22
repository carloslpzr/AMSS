/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Controllers;

import AMSS.SQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Reporte {
    private Connection con;
    
    public Reporte(){
        con = SQLConnection.getInstance();
    }
    
    
    public ArrayList<ArrayList<String>> getTableInfo(){
        ArrayList<ArrayList<String>> tableInfo = new ArrayList<ArrayList<String>>();
        ArrayList<String> row = new ArrayList<String>();
        
        String sql = "SELECT r.Nombre, m.Nombre, m.Manana, m.Tarde, m.Noche, m.FechaComienzo, Contenido, ContenidoML, Dosis, DosisML FROM Residentes r JOIN Medicamento m ON m.ID_Residente = r.ID;";
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                        row.add(resultSet.getString(1));
                        row.add(resultSet.getString(2));
                        
                        int dosis;
                        int contenido;
                        try {
                            contenido = resultSet.getInt(7);
                            dosis = resultSet.getInt(9);
                            row.add(dosis + " Tableta");
                        } catch(Exception e ){
                            contenido = resultSet.getInt(8);
                            dosis = resultSet.getInt(10);
                            row.add(dosis + " Mililitros");
                        }
                        
                        Boolean m = resultSet.getBoolean(3);
                        Boolean t = resultSet.getBoolean(4);
                        Boolean n = resultSet.getBoolean(5);
                        String turnos = "";
                        if(m) turnos += "Manana";
                        if(t) turnos += " Tarde";
                        if(n) turnos += " Noche";
                        row.add(turnos);
                        
                        LocalDate comienzo = resultSet.getDate(6).toLocalDate();
                        int dias = Period.between(comienzo, LocalDate.now()).getDays();
                        int consumoXdia = 0;
                        if(m) consumoXdia += 1;
                        if(t) consumoXdia += 1;
                        if(n) consumoXdia += 1;
                        consumoXdia *= dosis;
                        if((contenido - consumoXdia*dias) < consumoXdia*3){
                            row.add("alert");
                        } else {
                            row.add("ok");
                        }
                        
                        tableInfo.add(row);
                        row = new ArrayList<String>();
                }
        } catch (Exception e) {
            System.out.println("Database error.");
        }
        return tableInfo;
    }
}
