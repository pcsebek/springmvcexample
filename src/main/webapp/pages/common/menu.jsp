<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<!-- * 
* Conversion to Spring MVC required the following changes to this JSP
* -- logic:iterate -> ????
* -->

<% /* <tilesx:useAttribute name="menuItems" id="items" classname="org.apache.struts.tiles.beans.MenuItem"/> */ %>
<tilesx:useAttribute name="menuItems" id="items"/>
<html>
    <head>
    </head>
    <body>
        <table width="100%" border="0" cellspacing="5px" cellpadding="1px" >
            <tr align="center">
                <td>&nbsp;</td>
                <% /*
                <logic:iterate id="item" name="items" type="org.apache.struts.tiles.beans.MenuItem" indexId="i">
                    <td width="20%"><a href='<c:out value="${pageContext.request.contextPath}"/><c:out value="${item.link}"/>'><c:out value="${item.value}"/></a></td>
                </logic:iterate>
                */  %>
                <c:forEach items="${items}" var="item" >
                    <td width="20%"><a href='<c:out value="${pageContext.request.contextPath}"/><c:out value="${item.link}"/>'><c:out value="${item.value}"/></a></td>
                </c:forEach>
                <td>&nbsp;</td>
            </tr>
        </table>
    </body>
</html>