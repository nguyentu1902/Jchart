/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectToSinglestoreDB {
    private static final ConnectToSinglestoreDB connectToSinglestoreDB = new ConnectToSinglestoreDB();
    public Connection conn = null;
    
    // singleton
    public static ConnectToSinglestoreDB getInstance(){
        return connectToSinglestoreDB;
    }

    public ConnectToSinglestoreDB(){
        try {
                conn = DriverManager.getConnection("jdbc:singlestore://172.25.219.162:3309/rolling?user=root&password=5VMrvFZCa7astakjtOJDtYu2r1yJQ1S6");
                System.out.println("Connect to DB!");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}