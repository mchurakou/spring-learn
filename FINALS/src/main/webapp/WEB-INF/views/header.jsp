<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<h1>
	<spring:message code="final.app"/> 
    <spring:url var="logoutUrl" value="/j_spring_security_logout" />  
</h1>

 <div id="userinfo">
        <security:authorize access="isAuthenticated()">
	            <security:authentication property="principal.username" />
	            <br/>
	            <a href="${logoutUrl}"><spring:message code="final.logout"/></a>
        </security:authorize>                    
</div> 
<hr/>