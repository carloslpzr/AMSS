/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;

import java.sql.PreparedStatement;
import java.sql.Connection;
/**
 *
 * @author Carlos
 */
public class Cuarto {
    private int cuarto;
    private int cama;
    
    public Cuarto(int cuarto, int cama){
        this.cuarto = cuarto;
        this.cama = cama;
    }
    
    public void post(Connection con){
        String sql = "INSERT INTO Cuarto (ID_Residente, Fecha, Acontecimiento) VALUES (?, ?);";
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
