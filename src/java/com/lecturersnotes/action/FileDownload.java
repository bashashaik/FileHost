package com.lecturersnotes.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class FileDownload extends ActionSupport {

    private InputStream fileInputStream;
    
    public InputStream getFileInputStream(){
        return fileInputStream;
    }
    public FileDownload() {
    }
    
    public String execute() throws Exception {
        String email;
        Map<String,Object> sessionMap;
        HttpServletRequest request;
        String path="C:\\Basha\\dev\\uploads\\";
        ActionContext context=ActionContext.getContext();
        sessionMap=context.getSession();
        email=(String)sessionMap.get("email");
        request= ServletActionContext.getRequest();
        String selectedFile=request.getParameter("selectedFile");
        File downloadFile=new File(path.concat(email.concat("\\"+selectedFile)));
        fileInputStream=new FileInputStream(downloadFile);
        
        return SUCCESS;
    }
}