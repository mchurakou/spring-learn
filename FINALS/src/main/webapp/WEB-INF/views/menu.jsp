<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div>
	<spring:message code="contact.list.page.menu"/>
	<ul>
		<li>
			<a href="<spring:url value="/contacts/add"/>"><spring:message code="menu.add.contact"/></a>
		</li>
	</ul>  
</div>