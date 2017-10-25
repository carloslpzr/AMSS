/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMSS;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Carlos
 */
public final class SQLConnection {
    private static SQLConnection instance;
    private static Connection connection;
            
    private SQLConnection(){
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=CasaDeRetiro;user=sa;password=Clave123";
        try {
                // Load SQL Server JDBC driver and establish connection.
                System.out.print("Connecting to SQL Server ... ");
                connection = DriverManager.getConnection(connectionURL);
                System.out.println("Done.");
        } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
        }
    }
    
    public static Connection getInstance() {
        if (instance == null)
            instance = new SQLConnection();
        return connection;
    }
    
}
