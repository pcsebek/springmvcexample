<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>
<html>
    <tilesx:useAttribute id="screenName" name="title"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
            $j(document).ready(function() {
            });
            
            /*
             * Function currently not used.. data placed on POJO via Controller.
             */
            function loadJobList() {
            	   $j.ajax({
            		   type: "get",
            		   url: $j('#contextPath').val() + "/do/ajax/getJobList",
            		   cache: "false",
            		   dataType: "text",
            		   success: function(response) {
            			   $j('#jobList').append('<option value="0">Select Job</option>').append(response);
            			   alert($j('#currentJobId').val());
            			   if ($j('#currentJobId').val() !== undefined && $j('#currentJobId').val() !== "") {
            				   $j('#jobList option[value=' + $j('currentJobId').val() +']').attr('selected','selected');
            			   }
            		   }
            	   });
            }
            
            
        </script>
        <title><c:out value="${screenName}"/></title>
    </head>
    <body>
        <br/>
        <form:form action="${pageContext.request.contextPath}/do/employeeUpdate" commandName="employeeForm" method="post">
            <form:hidden id="employeeId" path="employeeId"/>
            <form:hidden path="priorJobId"/>
            <input type="hidden" id="contextPath" value='<c:out value="${pageContext.request.contextPath}"/>'/>
            
		    <table>
		        <tr align="left">
		            <td>First Name: </td>
		            <td><form:input tabindex="1" path="firstName" value="${employeeForm.firstName}"/></td>
		        </tr>
                <tr align="left">
		            <td>Last Name: </td>
		            <td><form:input tabindex="2" path="lastName" value="${employeeForm.lastName}"/></td>
		        </tr>
                <tr align="left">
		            <td>Current Salary: </td>
		            <td>$<form:input tabindex="3" path="salary" value="${employeeForm.salary}"/></td>
		        </tr>
                <tr align="left">
		            <td>Current Job: </td>
		            <td>
		                <form:select tabindex="4" id="jobList" path="currentJobId">
                            <form:option value="0">Select Job</form:option>
                            <form:options items="${employeeForm.jobList}" itemLabel="description" itemValue="id" />
		                </form:select>
		            </td>
		        </tr>
                <tr align="left">
		            <td></td>
		        </tr>
                <tr align="left">
		            <td>Previous Jobs:</td>
		            <td>
		                <c:forEach items="${employeeForm.previousJobs}" var="oldJob">
		                    <c:out value="${oldJob.description}"/><br/>
		                </c:forEach>
		            </td>
		        </tr>
                <tr align="left">
                    <td>
                        <% /* <html:submit property="method" styleClass="button" value="save">Save</html:submit> */ %>
                        <input type="submit" tabindex="5" style="button" name="save" value="Save"/>
                    </td>
                    <td>
                        <% /* <html:submit property="method" styleClass="button" value="saveAndAdd">Save and Add</html:submit> */ %>
                        <input type="submit" tabindex="6" class="button" name="saveAndAdd" value="Save and Add"/>
                    </td>
                    <td>
                        <% /* <html:submit property="method" styleClass="button" value="delete">Delete</html:submit> */ %>
                        <input type="submit" tabindex="7" class="button" name="delete" value="Delete"/>
                    </td>
		        </tr>
		    </table>
		</form:form>
    </body>
</html>
