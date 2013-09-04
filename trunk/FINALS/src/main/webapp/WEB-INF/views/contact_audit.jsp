<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<div>
	<spring:message code="finals.log"/>:
</div>
<div>	

	       <table>
	           <tr>
	               
	               <td>
	                   <spring:message code="contact.list.page.first.name"/> 
	               </td>
	               <td>
                      <spring:message code="contact.list.page.last.name"/> 
                   </td>
                   <td>
                      <spring:message code="contact.list.page.birth.date"/> 
                   </td>
                   <td>
                   	  <spring:message code="finals.operation"/> 
                   </td>
                   <td>
                   	  <spring:message code="finals.user"/> 
                   </td>
                   <td>
                   	  <spring:message code="finals.date"/> 
                   </td>
	           </tr>
	           <c:forEach items="${audit}" var="auditRecord" varStatus="status">
	               <tr>
	                   <td>
                       		${auditRecord.contact.firstName}

	                   </td>
	                   <td>
	                       ${auditRecord.contact.lastName}
	                   </td>
	                   <td>
	                        ${auditRecord.contact.birthDate}
	                   </td>
	                   <td>
	                        ${auditRecord.opearation}
	                   </td>
	                   <td>
	                        ${auditRecord.user.credential.login}
	                   </td>
	                   <td>
	                        ${auditRecord.date}
	                   </td>
	                   
                    </tr>
	           </c:forEach>
	       </table>

	
	
	
</div>
