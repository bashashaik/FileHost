<%-- 
    Document   : error
    Created on : Apr 18, 2013, 10:32:45 AM
    Author     : Basha Shaik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Some error has occurred, please try after some time.  </h1>
        <h4>Error message: <s:property value="message" /> </h4>
    </body>
</html>
