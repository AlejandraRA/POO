/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author david
 */
public class DBConnection {
    
    static Connection connection = null;
    public static Connection getconConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/fake_hotel_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            
             connection = DriverManager.getConnection(url,"root","root");
             System.out.println("Connected");
            
        } catch (Exception e) {
                         System.out.println(e);

        }
        return connection;
                
    }
    
    
}
