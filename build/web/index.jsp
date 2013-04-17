<%-- 
    Document   : index
    Created on : Apr 14, 2013, 5:10:40 PM
    Author     : Basha Shaik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
    <center>
        <h1>Welcome to Lecturersnotes</h1>
        <s:form action="login" method="post">
            <s:textfield key="username" label="Username" />
            <s:password key="password" label="Password" />
            <s:submit value="login" />
        </s:form>
        <h3>Don't have account register now!</h3>
        <s:form action="register" method="post">
            <s:textfield key="registerName" label="Name" />
            <s:textfield key="registerEmail" label="Email ID" />
            <s:password key="registerPassword" label="Password" />
            <s:submit value="register" />
        </s:form>
    </center>
    </body>
</html>
