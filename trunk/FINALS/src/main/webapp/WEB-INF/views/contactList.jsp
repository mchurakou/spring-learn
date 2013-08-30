<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>



<html>
<head>
	<title><spring:message code="contact.list.page.contacts"/></title>
</head>
<body>
	<h1>
		<spring:message code="contact.list.page.list.of.contacts"/>  
	</h1>

	
	<c:choose> 
	   <c:when test="${not empty contacts}">
	       <table>
	           <tr>
	               <td>
                       <spring:message code="contact.list.page.number"/> 
                   </td>
	               <td>
	                   <spring:message code="contact.list.page.first.name"/> 
	               </td>
	               <td>
                      <spring:message code="contact.list.page.last.name"/> 
                   </td>
                   <td>
                      <spring:message code="contact.list.page.birth.date"/> 
                   </td>
	           </tr>
	           <c:forEach items="${contacts}" var="contact" varStatus="status">
	               <tr>
	                   <td>
	                       ${status.index} ${status.count}
	                   </td>
	                   <td>
	                       ${contact.fistName}
	                   </td>
	                   <td>
	                       ${contact.lastName}
	                   </td>
	                   <td>
	                        ${contact.birstDate}
	                   </td>
                    </tr>
	           </c:forEach>
	       </table>
	   </c:when>
	   <c:otherwise>
	      <spring:message code="contact.list.page.no.contacts"/> 
	   </c:otherwise>
	</c:choose>
	
    <a href="?lang=en">EN</a> | <a href="?lang=ru">RU</a>
</body>
</html>
