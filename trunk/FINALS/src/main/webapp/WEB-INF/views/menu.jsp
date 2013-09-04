<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

 <spring:url var="loginUrl" value="/j_spring_security_check" />





<div>
	


    <security:authorize access="isAnonymous()">
    	<c:if test="${not empty message}">
				<div>${message}</div>
			</c:if>
	    <div id="login">
	       <form name="loginForm" action="${loginUrl}" method="post">
	           <table>
	               <caption align="left">Login:</caption>
	               <tr>
	                   <td>User Name:</td>
	                   <td><input type="text" name="j_username"/></td>
	               </tr>
	               <tr>
	                   <td>Password:</td>
	                   <td><input type="password" name="j_password"/></td>
	               </tr>
	               <tr>
	                   <td colspan="2" align="center"><input name="submit" type="submit" value="Login"/></td>
	               </tr>           
	           </table>
	       </form>
	    </div> 
    </security:authorize>



	<security:authorize access="hasRole('ROLE_USER')">
		<spring:message code="contact.list.page.menu"/>
		<ul>
			<li>
				<a href="<spring:url value="/contacts/add"/>"><spring:message code="menu.add.contact"/></a>
			</li>
		</ul>
	</security:authorize>  
</div>