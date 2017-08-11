<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<!--  *
* No changes
* -->
<html>
    <head>
        <script type="text/javascript" src="/springmvcexample/js/jquery-1.8.3.js"></script>
        
        <!--  order of scripts important to prevent javascript errors -->
        <script type="text/javascript" src="/springmvcexample/js/ajaxtags/prototype-1.4.0.js"></script>
        <script type="text/javascript" src="/springmvcexample/js/ajaxtags/scriptaculous-1.5.3.js"></script>
        <script type="text/javascript" src="/springmvcexample/js/ajaxtags/overlibmws.js"></script>
        <script type="text/javascript" src="/springmvcexample/js/ajaxtags/builder-1.5.3.js"></script>
        <script type="text/javascript" src="/springmvcexample/js/ajaxtags/controls.js"></script>
        <script type="text/javascript" src="/springmvcexample/js/ajaxtags/ajaxtags-1.2-beta2.js"></script>
        <script type="text/javascript" src="/springmvcexample/js/ajaxtags/effects.js"></script>
        
        <link rel="stylesheet" href="/springmvcexample/stylesheet/stylesheet.css" type="text/css"/>

        <script type="text/javascript">
            jQuery.noConflict();
            $j = jQuery;
        </script>
    </head>
    <body>
		<table border="0" width="100%">
		    <tr align="center">
		        <th>
		            <font color="green">
		                This is some message in the header to prove the header is displayed
		            </font>
		        </th>
		    </tr>
		    <tr align="center">
		        <td><fmt:message key="header.message.one"/></td>
		    </tr>
		    <tr align="center">
		        <td><fmt:message key="header.message.two"/></td>
		    </tr>
		    <tr align="center">
		        <td><fmt:message key="header.message.three"/></td>
		    </tr>
		</table>
	</body>
</html>