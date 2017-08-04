<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<!-- *
* Conversion to Spring MVC required the following changes to this JSP
* -- bean:write -> c:out      accessing model attribute helloWorldForm
* -->

<html>
    <head>
    </head>
    <body>
        hi...<br/>
        <h1><c:out value="${helloWorldForm.message}" /></h1>
    </body>
</html>
