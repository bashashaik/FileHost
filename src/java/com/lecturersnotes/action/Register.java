/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturersnotes.action;

import com.opensymphony.xwork2.ActionSupport;
import com.lecturersnotes.sql.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.File;


/**
 *
 * @author Basha Shaik
 */
public class Register extends ActionSupport {
    private String registerName;
    private String registerEmail;
    private String registerPassword;
    private String message;
    String result=ERROR;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String filePath="C:\\Basha\\dev\\uploads";
    String fileName;
    

    public String getMessage() {
        return message;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

    public String getRegisterName() {
        return registerName;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }
    
    public Register() {
    }
    
    @Override
    public String execute() throws Exception {
        SQLConnection sqlCon=new SQLConnection();
        sqlCon.init();
        con=sqlCon.getConnection();
        ps=con.prepareStatement("insert into registration values(?, ?, ?)");
        ps.setString(1, registerName);
        ps.setString(2, registerPassword);
        ps.setString(3, registerEmail);
        int nou= ps.executeUpdate();
        if(nou==1){
            fileName=registerEmail;
            File newFile= new File(filePath, registerEmail);
            newFile.mkdir();
            
            result=SUCCESS;
        }
        message="Error in update";
        ps.close();
        sqlCon.destroy();
        return result;
    }
    
    
}