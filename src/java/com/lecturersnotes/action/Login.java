/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturersnotes.action;

import com.opensymphony.xwork2.ActionSupport;


/**
 *
 * @author Basha Shaik
 */
public class Login extends ActionSupport {
    
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public Login() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}