<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3c.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/pages/include/tagLibraryInclude.jsp" %>
<html>
    <tilesx:useAttribute id="screenName" name="title"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
            $j(document).ready(function() {
            	   $j('#currentJobId').change(function() { retrieveStateCodesJSON();} );
            	   
            	   $j('#stateCd').change(function() { onStateCodeChangePostFunction(); });
            	   
            	   $j('#stateType_M, #stateType_S, #stateType_T').change(function() { retrieveStateCodesXML(); });
            	   $j('#stateType_U').change(function() { clearStateCodesXML(); });
            });
            
            var states = ["AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME",
            		          "MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA",
            		          "RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"];
            var territories = ["AS","DC","FM","GU","MH","MP","PW","PR","VI"];
            var militaryStates = ["AE","AA","AP"];
            
            /*
             * Function currently not used.. data placed on POJO via Controller.
             */
            function loadJobList() {
            	   $j.ajax({
            		   type: "get",
            		   url: $j('#contextPath').val() + "/do/ajax/getJobList",
            		   cache: "false",
            		   dataType: "xml",
            		   success: function(response) {
            			   $j('#currentJobId').append('<option value="0">Select Job</option>').append(response);
            			   if ($j('#currentJobId').val() !== undefined && $j('#currentJobId').val() !== "") {
            				   $j('#currentJobId option[value=' + $j('currentJobId').val() +']').attr('selected','selected');
            			   }
            		   }
            	   });
            }
            
            function retrieveStateCodesJSON() {
            	   $j.ajax({
            		   type:     "get",
            		   url:      $j('#contextPath').val() + "/do/ajax/json/getStates",
            		   cache:    "false",
            		   dataType: "JSON",
            		   success:  function(data) {

            			   var optionHtml = '<option value=""> Select a State...</option>';
            			   $j.each(data, function(indx,state) {
            				   optionHtml += '<option value="' + state.abrv + '">' + state.name + '</option>';
            			   });
            			   $j('#stateCd').find('option').remove();
            			   $j('#stateCd').append(optionHtml);
            			   
            		   },
            		   error: function(textStatus,errorThrow) {
            			    // nothing to see or do in this scenario
            		   },
            		   complete: function(response,textStatus) {
            			   
            			   onStateCodeChangePostFunction();
            		   }
            	   });
            }
            
            function clearStateCodesXML() {
                $j('#stateCd2').find('option').remove();
                $j('#stateCd2').prop('disabled',true);
            }
            
            function retrieveStateCodesXML() {

                $j.ajax({
                    type:     "get",
                    url:      $j('#contextPath').val() + "/do/ajax/xml/getStates",
                    cache:    "false",
                    dataType: "XML",
                    success:  function(xml) {
                    	
                    	   var optionHtml = '<option value=""> Select a State...</option>';
                    	   $j(xml).find('state').each(function() { 
                    		   var abrv = $j(this).find("abrv").text();
                    		   var name = $j(this).find("name").text();
                            optionHtml += '<option value="' + abrv + '">' + name + '</option>';
                    	   });
                        $j('#stateCd2').find('option').remove();
                        $j('#stateCd2').append(optionHtml).prop('disabled',false);
                    },
                    error: function(textStatus,errorThrow,data) {
                         // nothing to see or do in this scenario
                    },
                    complete: function(response,textStatus) {
                         // nothing to see or do in this scenario
                    }
                });
            }
         
            function onStateCodeChangePostFunction() {

            	   var type;
            	   if (states.indexOf($j('#stateCd').val()) > -1) {
            		   type="S";
            	   }
            	   else if (territories.indexOf($j('#stateCd').val()) > -1) {
            		   type="T";
            	   }
            	   else if (militaryStates.indexOf($j('#stateCd').val()) > -1) {
            		   type="M";
            	   }
            	   else {
            		   type="U";
            	   }
            	   $j("input[name=stateTypeCd][value=" + type + "]").prop("checked",true).change();
            }
            
            function onStateCodeChangePostFunction2() {
            	
            	   $j('#stateCd3Message').fadeIn(1000).delay(1000).fadeOut();
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
		                <form:select tabindex="4" id="currentJobId" path="currentJobId">
                            <form:option value="0">Select Job</form:option>
                            <form:options items="${employeeForm.jobList}" itemLabel="description" itemValue="id" />
		                </form:select>
		            </td>
		        </tr>
                <tr align="left">
                    <td>State Code (ajax:select): </td>
                    <td>
                        <form:select tabindex="5" id="stateCd3" path="stateCd3" disabled="true">
                            <option/>
                        </form:select>
                    </td>
                    <td>
                        <div id="stateCd3Message" style="display:none;">
                        Data successfully retrieved using ajax:select tag
                        </div>
                    </td>
                </tr>
                <tr align="left">
                    <td>State Code (JSON): </td>
                    <td>
                        <form:select tabindex="6" id="stateCd" path="stateCd">
                            <option/>
                        </form:select>
                    </td>
                </tr>
                <tr align="left">
                    <td>State Code (XML): </td>
                    <td>
                        <form:select tabindex="7" id="stateCd2" path="stateCd2" disabled="true">
                            <option/>
                        </form:select>
                    </td>
                </tr>
                <tr align="left">
                    <td>State Type Code: </td>
                    <td>
                        <form:radiobutton path="stateTypeCd" id="stateType_M" disabled="true" value="M"/>Military "State"<br/>
                        <form:radiobutton path="stateTypeCd" id="stateType_S" disabled="true" value="S"/>State<br/>
                        <form:radiobutton path="stateTypeCd" id="stateType_T" disabled="true" value="T"/>Territory<br/>
                        <form:radiobutton path="stateTypeCd" id="stateType_U" disabled="true" value="U"/>Unknown
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
                        <input type="submit" tabindex="50" style="button" name="save" value="Save"/>
                    </td>
                    <td>
                        <% /* <html:submit property="method" styleClass="button" value="saveAndAdd">Save and Add</html:submit> */ %>
                        <input type="submit" tabindex="51" class="button" name="saveAndAdd" value="Save and Add"/>
                    </td>
                    <td>
                        <% /* <html:submit property="method" styleClass="button" value="delete">Delete</html:submit> */ %>
                        <input type="submit" tabindex="52" class="button" name="delete" value="Delete"/>
                    </td>
		        </tr>
		    </table>
		</form:form>
    </body>
    <% /* 
        * tag did not work with Spring MVC -- use JQuery.ajax instead */ %>
    <ajax:select baseUrl="${pageContext.request.contextPath}/do/ajax/ajaxtags/getStates"
                 source="currentJobId"
                 target="stateCd3"
                 parameters="jobId={currentJobId}"
                 executeOnLoad="false"
                 defaultOptions="{employeeForm.stateCd3}"
                 postFunction="onStateCodeChangePostFunction2"
                 parser="new ResponseXmlParser()"/>
         
</html>
