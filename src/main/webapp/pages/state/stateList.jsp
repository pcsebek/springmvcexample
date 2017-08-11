<!DOCTYPE HTML PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/pages/include/tagLibraryInclude.jsp" %>

<% /*   JQuery DataTables as alternative to <ajax:dataTable> and <display:table>/<display:column> */ %>

<link rel="stylesheet" href="/springmvcexample/dataTables/css/jquery.dataTables.css" type="text/css"/>
<link rel="stylesheet" href="/springmvcexample/buttonsDataTables/css/buttons.dataTables.css" type="text/css"/>

<!--  Order of the javascript files below is important -->
<script type="text/javascript" src="/springmvcexample/dataTables/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/springmvcexample/buttonsDataTables/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="/springmvcexample/buttonsDataTables/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="/springmvcexample/buttonsDataTables/js/buttons.print.min.js"></script>

<!--  can be included using //cdnjs.cloudfare.com/ajax/libs/jszip/3.1.3/jszip.min.js -->
<!--  decided to download from github https://stuk.github.io/jszip/ and place in the buttonsDataTables folder-->
<script type="text/javascript" src="/springmvcexample/buttonsDataTables/js/jszip.min.js"></script>



<script type="text/javascript">
    $j(document).ready(function() {
    	
    	   loadDataTable1();
    	   loadDataTable2();
    });
    
    function loadDataTable1() {
    	
        $j('#example').DataTable({
        	    'searching':false,
        	    'lengthChange':false,
        	    
            'aaData': ${stateList2},
            'aoColumns': [
                { 'data': 'abrv' },
                { 'data': 'name' },
                { 'data': 'stateHood' },
                { 'data': 'capital' },
                { 'data': 'population' }
            ]
        });       
    }
    
    function loadDataTable2() {

    	   var table3 = $j("#example2").DataTable({
                		    'searching':false,
                		    'lengthChange':false,
                		    'ajax': {
                		        'url': $j('#contextPath').val() + "/do/ajax/json/getStates",
                		        'type': 'get',
                		        'dataType':'JSON',
                		        'dataSrc': ''
                		    },
                		    'aoColumns': [
                		    	 { 'data': 'abrv' },
                		    	 { 'data': 'name' },
                		    	 { 'data': 'stateHood' },
                		    	 { 'data': 'capital' },
                		    	 { 'data': 'population' }
                		    ],
                		    'dom': 'friptpB',
                		    'buttons': [ 'csv', 'excel','print' ]
                	   });
    }
    
</script> 

<input type="hidden" id="contextPath" value='<c:out value="${pageContext.request.contextPath}"/>'/>

<h3>ajax displayTag, display table, and display column combination</h3><br/>
<ajax:displayTag id="displayTagAjaxStateList" ajaxFlag="displayAjax" tableClass="displayTag"
                 postFunction="function() { alert('postFunction'); }">

    <display:table name="stateList"
                   requestURI=""
                   export="false"
                   sort="list"
                   defaultsort="2"
                   pagesize="10"
                   id="stateRow"
                   class="displayTag stateTable">
        <display:column titleKey="state.table.state.abrv"
                        sortable="true"
                        property="abrv"
                        style="width:100px;">
        </display:column>
        <display:column titleKey="state.table.state.name"
                        sortable="true"
                        property="name"
                        style="width:275px;">
        </display:column>
        <display:column titleKey="state.table.state.date"
                        sortable="true"
                        style="width:100px;">
            <c:choose>
                <c:when test="${stateRow.stateHood eq '0'}">
                    UNKNOWN
                </c:when>
                <c:otherwise>
                    ${stateRow.stateHood}
                </c:otherwise>
            </c:choose>
        </display:column>
        <display:column titleKey="state.table.state.capital"
                       sortable="false"
                       style="width:100px;">
            <c:choose>
                <c:when test="${empty stateRow.capital}">
                    UNKNOWN
                </c:when>
                <c:otherwise>
                    ${stateRow.capital}
                </c:otherwise>
            </c:choose>
       </display:column>
       <display:column titleKey="state.table.state.population"
                       sortable="true"
                       style="width:100px;">
                <c:choose>
                    <c:when test="${stateRow.population eq 0}">
                        UNKNOWN
                    </c:when>
                    <c:otherwise>
                        ${stateRow.population}
                    </c:otherwise>
                </c:choose>
       </display:column>
    </display:table>
</ajax:displayTag>
<br/>
<h3>JQuery DataTables alternative using data from request</h3>
<div style="width:70%">
    <table id="example" cellspacing="0" class="compact stripe" style="border: 1px solid #666; width: 100%; margin: 0px 0 20px 0;">
        <thead>
            <th><fmt:message key="state.table.state.abrv"/></th>
            <th><fmt:message key="state.table.state.name"/></th>
            <th><fmt:message key="state.table.state.date"/></th>
            <th><fmt:message key="state.table.state.capital"/></th>
            <th><fmt:message key="state.table.state.population"/></th>
        </thead>
    </table>
</div>
<br/>
<h3>JQuery DataTables alternative using AJAX to retrieve table data</h3>
<div style="width:70%">
    <div>
    <table id="example2" cellspacing="0" class="compact stripe" style="border: 1px solid #666; width: 100%; margin: 0px 0 20px 0;">
        <thead>
            <th><fmt:message key="state.table.state.abrv"/></th>
            <th><fmt:message key="state.table.state.name"/></th>
            <th><fmt:message key="state.table.state.date"/></th>
            <th><fmt:message key="state.table.state.capital"/></th>
            <th><fmt:message key="state.table.state.population"/></th>
        </thead>
    </table>
    </div>
    <div class="example2Buttons"></div>
</div>


