<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="contact.list.page.contacts"/></title>
</head>
<body>
	<tiles:insertAttribute name="header" ignore="true" />
  	<tiles:insertAttribute name="menu" ignore="true" />
	<tiles:insertAttribute name="body"/> 
	<hr/>
    <tiles:insertAttribute name="footer" ignore="true"/>
</body>
</html>
