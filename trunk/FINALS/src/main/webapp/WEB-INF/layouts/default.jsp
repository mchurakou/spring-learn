<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="contact.list.page.contacts"/></title>
	
	
	
	 <spring:url value="/resources/css/jquery/jquery-ui-1.10.3.custom.css" var="jquery_ui_theme_css" /> 
	 <spring:url value="/resources/js/jquery/jquery-1.9.1.js" var="jquery_url" />
     <spring:url value="/resources/js/jquery/jquery-ui-1.10.3.custom.js" var="jquery_ui_url" />          
     
     
     
     <!-- jQuery and jQuery UI -->          
     <link rel="stylesheet" type="text/css" media="screen" href="${jquery_ui_theme_css}" />        
     <script src="${jquery_url}" type="text/javascript"></script>
     <script src="${jquery_ui_url}" type="text/javascript"></script>
	
     <!-- jqGrid -->
     <spring:url value="/resources/css/jqgrid/ui.jqgrid.css" var="jqgrid_css" />
     <spring:url value="/resources/js/jqgrid/i18n/grid.locale-en.js" var="jqgrid_locale_url" />
     <spring:url value="/resources/js/jqgrid/jquery.jqGrid.min.js" var="jqgrid_url" />
     <link rel="stylesheet" type="text/css" media="screen" href="${jqgrid_css}" />
     <script type="text/javascript" src="${jqgrid_locale_url}"><jsp:text/></script> 
     <script type="text/javascript" src="${jqgrid_url}"><jsp:text/></script>
     
     
     <script type="text/javascript">
     	
     	$(function(){
     		$("button").button();
     	    	
     		$(".datepicker").datepicker({
     			dateFormat: "yy-mm-dd",
     			changYear: true
     		});
     	});
     </script>

</head>
<body>
	<tiles:insertAttribute name="header" ignore="true" />
  	<tiles:insertAttribute name="menu" ignore="true" />
	<tiles:insertAttribute name="body"/> 
	<hr/>
    <tiles:insertAttribute name="footer" ignore="true"/>
</body>
</html>
