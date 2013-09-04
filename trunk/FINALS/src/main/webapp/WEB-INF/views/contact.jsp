<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <spring:url value="/contacts/photo" var="photoURL"/> 
 
 <spring:url value="/contacts" var="contactsURL"/> 


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
	 <c:if test="${contact.id != null}">
	 	<a href="${contactsURL}/${contact.id}/log"><spring:message code="finals.log"/></a>
	 </c:if>
	<form:form modelAttribute="contact" id="contactForm" method="post" enctype="multipart/form-data" >
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
                        <input value="${contact.birthDate}" name="birthDate" class="datepicker" readonly='true' />
                   		<div>
                   			<form:errors path="birthDate" cssClass="error"/>
                   		</div>
                   </td>
               </tr>
               
               <tr>
	               <td>
	               	<label for="file">
                       <spring:message code="contact.list.page.image"/>:
                    </label> 
                   </td>
                   <td>
                   		<c:if test="${contact.id != null}">
                   			<img src="${photoURL}/${contact.id}"></img>
                   		</c:if>
         		
                        <input name="file" type="file" />
                   </td>
               </tr>
      		</table>
      		
      		<form:hidden path="version"/>
      		<button type="submit"><spring:message code="button.title.save"/></button>
      </form:form>

</div>
