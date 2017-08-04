<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<!-- *
* Conversion to Spring MVC required the following changes to this JSP
* -- bean:message -> fmt:message
 -->
<html>
    <head>
    </head>
    <body>
		<table border="0" width="100%">
		    <tr align="center">
		        <th>
		            <font color="blue">
		                <font color="red"><u>NOTE:</u></font>
		                This is some message in the footer to prove the footer is displayed
		            </font>
		        </th>
		    </tr>
		    <tr align="center">
		        <td>Using this site for testing of Spring MVC</td>
		    </tr>
		    <tr align="center">
		        <td>Use of this site provide no value</td>
		    </tr>
		    <tr align="center">
		        <td>Just useless information that is being used for testing</td>
		    </tr>
		    <tr align="center">
		        <td>
                <% /* 
			        <bean:message key="footer.message.one"/>&nbsp;
			        <bean:message key="footer.message.two"/>&nbsp;
			        <bean:message key="footer.message.three"/>&nbsp;
			        <bean:message key="footer.message.four"/>&nbsp;
			        */ %>
                    <fmt:message key="footer.message.one"/>&nbsp;
                    <fmt:message key="footer.message.two"/>&nbsp;
                    <fmt:message key="footer.message.three"/>&nbsp;
                    <fmt:message key="footer.message.four"/>&nbsp;
		        <td>
		    </tr>
		</table>
	</body>
</html>