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
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class DesplegarInfo {
    private Connection con;
    
    public DesplegarInfo(){
        con = SQLConnection.getInstance();
    }
    
    public ArrayList<ArrayList<String>> getTableInfo(){
        ArrayList<ArrayList<String>> tableInfo = new ArrayList<ArrayList<String>>();
        ArrayList<String> row = new ArrayList<String>();
        
        String sql = "SELECT Nombre, Padecimientos  FROM Residentes r JOIN HistorialMedico h ON r.ID = h.ID_Residente;";
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                        row.add(resultSet.getString(1));
                        row.add(resultSet.getString(2));
                        tableInfo.add(row);
                        row = new ArrayList<String>();
                }
        } catch (Exception e) {
            System.out.println("Database error.");
        }
        return tableInfo;
    }
    
}
