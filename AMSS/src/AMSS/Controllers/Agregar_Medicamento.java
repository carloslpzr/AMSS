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
public class Agregar_Medicamento {
    Connection con;
    
    public Agregar_Medicamento(){
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
    
    public ArrayList<ArrayList<String>> getMeds(int id){
        ArrayList<ArrayList<String>> medicamentos = new ArrayList<ArrayList<String>>();
        ArrayList<String> row = new ArrayList<String>();
        String sql = "SELECT ID, Nombre FROM Medicamento WHERE ID_Residente = " + id;
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                        row.add(resultSet.getString(1));
                        row.add(resultSet.getString(2));
                        medicamentos.add(row);
                        row = new ArrayList<String>();
                }
        } catch (Exception e) {
            System.out.println("Database error.");
        }
        return medicamentos;
    }
    
}