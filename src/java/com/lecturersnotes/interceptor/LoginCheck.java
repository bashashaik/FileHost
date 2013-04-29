/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturersnotes.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;


/**
 *
 * @author Basha Shaik
 */
public class LoginCheck extends AbstractInterceptor  {
    
    public LoginCheck() {
    }
    
    
    
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context=actionInvocation.getInvocationContext();
        Map<String, Object> sessionMap= context.getSession();
        String result;
        String email=(String)sessionMap.get("email");
        if(email != null)
            result=actionInvocation.invoke();
        else
            result="login";
        return result;
    }
}