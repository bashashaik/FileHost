/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturersnotes.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.apache.struts2.StrutsStatics;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


import com.lecturersnotes.sql.SQLConnection;

/**
 *
 * @author Basha Shaik
 */
public class LoginInterceptor implements Interceptor, StrutsStatics {
    Connection con;
    PreparedStatement ps;
    String message;
    public LoginInterceptor() {
    }
    
    public void destroy() {
        try{
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void init() {
        SQLConnection sqlCon=new SQLConnection();
        sqlCon.init();
        con=sqlCon.getConnection();
        try{
         ps=con.prepareStatement("select * from registration where email=? and password=? ");   
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String email;
        String password;
        Map<String, Object> sessionMap;
        String result="error";
        ActionContext context=actionInvocation.getInvocationContext();
        HttpServletRequest request=(HttpServletRequest)context.get(HTTP_REQUEST);
        email=request.getParameter("email");
        password= request.getParameter("password");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            String name=rs.getString("name");
            result=actionInvocation.invoke();
            sessionMap=context.getSession();
            sessionMap.put("name", name);
            sessionMap.put("email", email);
        }
        return result;
    }
}