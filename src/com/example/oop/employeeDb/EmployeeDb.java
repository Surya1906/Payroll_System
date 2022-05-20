
package com.example.oop.employeeDb;

/**
 *
 * @author Surya.N
 */
import java.sql.Connection;
import java.sql.DriverManager;


public class EmployeeDb {
      static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/payrollsystem";
    static String uname = "root";
    static String pass = "";
   
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,uname, pass);
        }
        return con;
    }
}
