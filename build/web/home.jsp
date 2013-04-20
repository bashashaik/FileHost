<%-- 
    Document   : home
    Created on : Apr 18, 2013, 10:47:52 AM
    Author     : Basha Shaik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h3>Welcome <s:property value="#session.name" /></h3>
        <s:form action="upload" enctype="multipart/form-data">
            <s:file key="myFile" label="Select your file " />
            <s:submit value="upload"/>
        </s:form>
    </center>
    </body>
</html>
