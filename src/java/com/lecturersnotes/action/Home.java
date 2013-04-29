/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturersnotes.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.FileUtils;
//import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author Basha Shaik
 */
public class Home extends ActionSupport implements StrutsStatics{
    
    private File myFile;
    private String myFileFileName;
    private String myFileContentType;
    private String destPath="C:\\Basha\\dev\\uploads\\";
    private String result="error";
    private Map<String, Object> sessionMap;
    private String email;
    
    
    
    
    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }
    
    
    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public void setFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }
    

    public String getMyFileContentType() {
        return myFileContentType;
    }

    
    public Home() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String upload()throws Exception {
        HttpServletRequest request=ServletActionContext.getRequest();
        ActionContext context=ServletActionContext.getActionContext(request);
        sessionMap=context.getSession();
        email=(String)sessionMap.get("email");
        try{
            String finalPath=destPath.concat(email);
            File destFile=new File(finalPath,myFileFileName);
            
            FileUtils.copyFile(myFile, destFile);
            System.out.println(finalPath);
            result="success";
        }
        catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
        finally{
            return result;
        }
    }
    public void validate(){
        if(myFile== null){
            addFieldError("myFile","You did not chose any file. ");
        }
    }
}