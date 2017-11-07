/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Controllers;
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
public class Eventualidades {
    private Connection con;
    
    public Eventualidades(){
        con = SQLConnection.getInstance();
    }
    
    public ArrayList<String> getResidents(){
        ArrayList<String> residentNames = new ArrayList<String>();
        String sql = "SELECT Nombre FROM Residentes;";
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                        residentNames.add(resultSet.getString(1));
                }
        } catch (Exception e) {
            System.out.println("Database error.");
        }
        return residentNames;
    }
    
    public ArrayList<String> getNurses(){
        ArrayList<String> nurseNames = new ArrayList<String>();
        String sql = "SELECT Nombre FROM Enfermero;";
        try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                        nurseNames.add(resultSet.getString(1));
                }
        } catch (Exception e) {
            System.out.println("Database error.");
        }
        return nurseNames;
    }
    
    public void postEvent(int index, Date date, String description){
        String sql = "INSERT INTO Eventualidad (ID_Residente, Fecha, Acontecimiento) VALUES (?, ?, ?);";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.setInt(1, index);
					statement.setDate(2, date);
                                        statement.setString(3, description);
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
	} catch(Exception e){
            System.out.println("error");
        }

    }
    
}
