<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<!-- * 
* Conversion to Spring MVC required the following changes to this JSP
* -- tiles:useAttribute -> tilesx:useAttribute
* -- html:form -> form:form
* -- html:hidden -> form:hidden
* -- html:select -> form:select
* -- html:submit -> input type=submit
* -->
<html>
     <tilesx:useAttribute id="screenName" name="title"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
        <script type="text/javascript">
            $j(document).ready(function() {
            	
            	   enableDisableButtons("0");
            	   $j('#selectedEmployee').change(function () {retrieveSelectedEmployee();});
            	
               loadEmployeeList();
               
            });
            
            function loadEmployeeList() {
            	   $j.ajax({
            		   type: "GET",
            		   url: $j('#contextPath').val() + "/do/ajax/getEmployeeList",
            		   cache: "false",
            		   dataType: "text",
            		   success: function(response) {
            			   
            			   $j('#selectedEmployee').append('<option value="0">Select one to edit or leave blank to add</option>').append(response);
            		   }
            	   });
            };
            
            function retrieveSelectedEmployee() {
            	   var value = $j("#selectedEmployee").val();
               $j('#employeeId').val(value);
               enableDisableButtons(value);
            }
            
            function enableDisableButtons(value) {            	
            	   $j('#displayButton').prop('disabled',(value === "0"));
            	   $j('#addButton').prop('disabled',(value !== "0"));
            }
            
        </script>
        
        <title><c:out value="${screenName}"/></title>

    </head>
    <body>
        <!-- known issue so need to prepend pageContext.request.contextPath to action -->
        <form:form action="${pageContext.request.contextPath}/do/employee" commandName="employeeForm" method="get">
            <form:hidden id="employeeId" path="employeeId"/>
            <input type="hidden" id="contextPath" value='<c:out value="${pageContext.request.contextPath}"/>'/>
            
		    <table>
                <tr align="left">
                    <td>Select Employee (optional):</td>
                    <td>
                        <!--  not tabindx for this tag -->
                        <form:select  id="selectedEmployee" path="selectedId">
                        </form:select>
                    </td> 
                <tr align="left">
                    <td>
                        <input type="submit" id="displayButton" style="button" name="display" value="Display"/>
                    </td>
		            <td>
                        <input type="submit" id="addButton" style="button" name="add" value="Add"/>
                    </td>
		        </tr>
		    </table>
		</form:form>

    </body>
</html>
