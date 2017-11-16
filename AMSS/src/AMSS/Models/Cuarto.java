/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS.Models;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
    
    public int post(Connection con){
        String sql = "INSERT INTO Cuarto (NumeroCuarto, NumeroCama) VALUES (?, ?);";
        try (PreparedStatement statement = con.prepareStatement(sql, new String[]{"ID_Residente"})) {
					statement.setInt(1, cuarto);
					statement.setInt(2, cama);
					int rowsAffected = statement.executeUpdate();
					System.out.println(rowsAffected + " row(s) inserted");
                                        ResultSet rs = statement.getGeneratedKeys();
                                        if(rs.next()){
                                            int id = rs.getInt(1);
                                            return id;
                                        }
	} catch(Exception e){
            System.out.println("error");
        }
        return -1;
    }

    public int getCuarto() {
        return cuarto;
    }

    public void setCuarto(int cuarto) {
        this.cuarto = cuarto;
    }

    public int getCama() {
        return cama;
    }

    public void setCama(int cama) {
        this.cama = cama;
    }
    
    
}
