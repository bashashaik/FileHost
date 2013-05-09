package com.lecturersnotes.tld;
import java.io.File;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FileList extends TagSupport{

public int doStartTag() throws JspException {
    HttpSession session;
    HttpServletResponse response;
    String email;
    String path="C:\\Basha\\dev\\uploads\\";
    String listOfFiles[];
    JspWriter out=pageContext.getOut();
    session=pageContext.getSession();
    response=(HttpServletResponse)pageContext.getResponse();
    response.setContentType("text/html");
    email= (String)session.getAttribute("email");
    File dest=new File(path.concat(email));
    listOfFiles=dest.list();
    try{
        out.println("<html>");
        out.println("<body>");
        out.println("<form action='fileDownload' ");
        for(int i=0; i<listOfFiles.length; i++){
            
            out.println("<br />");
            out.println("<input type='radio' name='selectedFile' value='"+listOfFiles[i]+"' />");
            out.print(listOfFiles[i]);
        }
        out.println("<br />");
        out.println("<input type='submit' value='Download' />");
        out.println("</form>");
        out.println("<h3>"+email+"</h3>");
        out.println("</body>");
        out.println("</html>");
    }
    catch(Exception e){
        System.out.println(e);
    }
    return EVAL_PAGE;
}

}

