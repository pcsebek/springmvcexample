<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<html>
    <tilesx:useAttribute id="screenTitle" name="title"/>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${screenTitle}"/></title>        
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/stylesheet/stylesheet.css" type="text/css"/>
        
        <title>
            <!-- <bean:message key="index.title"/>  -->
            <fmt:message key="index.title"/>
        </title>
        <!-- <html:base/> -->
        <base/>
    </head>
    <body>

        <table id="defaultLayoutTableZ" border="1" style="width: 100%;" cellspacing="5">
            <tr>
                <td nowrap colspan="2" align="center">
                    <tiles:insertAttribute name="header"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    <tiles:insertAttribute name="menu" ignore="false"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    <tiles:insertAttribute name="errors"/>
                </td>
            </tr>
            
            <tr>
                <td nowrap width="80%" valign="top" align="left">
                    <tiles:insertAttribute name="body-content"/>
                </td>
            </tr>
            
            <tr>
                <td nowrap colspan="2" align="center">
                    <tiles:insertAttribute name="footer"/>
                </td>
            </tr>
        </table>
    </body>
</html>