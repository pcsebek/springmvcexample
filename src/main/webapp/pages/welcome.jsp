<!DOCTYPE HTML PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<!-- *
* Conversion to Spring MVC required the following changes to this JSP
* -- tiles:useAttribute -> tilesx:useAttribute
* -->

<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <tilesx:useAttribute id="screenName" name="title"/>
    <head>
    </head>
    <body>
        <table width="100%">
            <tr>
                <th>Phil says welcome</th>
            </tr>
            <tr align="center">
                <td><b><c:out value="${screenName}"/></b></td> 
            </tr>
            <tr align="center">
                <td>
                </td>
            </tr>           
        </table> 
    </body>
</html>