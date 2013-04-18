/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturersnotes.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *
 * @author Basha Shaik
 */
public class LoginInterceptor implements Interceptor {
    
    public LoginInterceptor() {
    }
    
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}