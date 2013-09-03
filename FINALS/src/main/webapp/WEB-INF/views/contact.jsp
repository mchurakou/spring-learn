<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div>

	

	
	<c:choose> 
	   <c:when test="${contact.id == null}">
	     	<c:set var="contactTitle" value="contact.show.page.contact.new"/>
	   </c:when>
	   <c:otherwise>
	   	  <c:set var="contactTitle" value="contact.show.page.contact.info"/>
	   </c:otherwise>
	</c:choose>
	
	<spring:message code="${contactTitle}"/>
	
</div>
<div>	
	<form:form modelAttribute="contact" id="contactForm"  >
			<c:if test="${not empty message}">
				<div>${message}</div>
			</c:if>
	       <table>
	           <tr>
	               <td>
	               	<form:label path="firstName">
                       <spring:message code="contact.list.page.first.name"/>*:
                    </form:label> 
                   </td>
                   <td>
                   		<form:input path="firstName" />
                   		<div>
                   			<form:errors path="firstName" cssClass="error"/>
                   		</div>
                   </td>
               </tr>
               <tr>
	               <td>
	               	<form:label path="lastName">
                       <spring:message code="contact.list.page.last.name"/>*:
                    </form:label> 
                   </td>
                   <td>
                   		<form:input path="lastName" />
                   		<div>
                   			<form:errors path="lastName" cssClass="error"/>
                   		</div>
                   </td>
               </tr>
               <tr>
	               <td>
	               	<form:label path="birthDate">
                       <spring:message code="contact.list.page.birth.date"/>:
                    </form:label> 
                   </td>
                   <td>
                        <input value="${contact.birthDate}" name="birthDate"/>
                   		<div>
                   			<form:errors path="birthDate" cssClass="error"/>
                   		</div>
                   </td>
               </tr>
      		</table>
      		
      		<form:hidden path="version"/>
      		<button type="submit"><spring:message code="button.title.save"/></button>
      </form:form>

</div>
