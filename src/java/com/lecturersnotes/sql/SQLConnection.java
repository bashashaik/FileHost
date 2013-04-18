/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturersnotes.sql;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Basha Shaik
 */
public class SQLConnection {
    Connection con;
    String message;
    public void init(){
        try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
         }
        catch(ClassNotFoundException e){
            System.out.println(e);
            message="Class not found Exception";
        }
        catch(SQLException e){
            System.out.println(e);
            message="SQLException";
        }
        
    }
    public Connection getConnection(){
        return con;
    }
    public void destroy(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
