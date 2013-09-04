<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<div>
	<spring:message code="contact.list.page.list.of.contacts"/>
</div>
<div>	
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
	                       ${status.count}
	                   </td>
	                   <td>
	                   		<security:authorize access="hasRole('ROLE_USER')">
	                   			<a href="contacts/${contact.id}">
	                       			${contact.firstName}
	                       		</a>
	                   		</security:authorize>
	                   		<security:authorize access="isAnonymous()">
	                   			${contact.firstName}
	                   		</security:authorize>
	                   
	                   	   
	                   </td>
	                   <td>
	                       ${contact.lastName}
	                   </td>
	                   <td>
	                        ${contact.birthDate}
	                   </td>
	                   <td>
	                   		<security:authorize access="hasRole('ROLE_USER')">
	                   			<a href="contacts/${contact.id}/delete">delete</a>
	                   		</security:authorize>
	                   </td>
	                   
                    </tr>
	           </c:forEach>
	       </table>
	   </c:when>
	   <c:otherwise>
	      <spring:message code="contact.list.page.no.contacts"/> 
	   </c:otherwise>
	</c:choose>
	
	
	
    <spring:url value="/contacts" var="showContactUrl"/>   
    
    <script type="text/javascript">
    $(function(){      
      $("#list").jqGrid({
        url:'${showContactUrl}/listgrid',
        datatype: 'json',
        mtype: 'GET',
        colNames:['<spring:message code="contact.list.page.first.name"/>', '<spring:message code="contact.list.page.last.name"/>', '<spring:message code="contact.list.page.birth.date"/> '],
        colModel :[ 
          {name:'firstName', index:'firstName', width:150},
          {name:'lastName', index:'lastName', width:100}, 
          {name:'birthDate', index:'birthDate', width:100}
        ],
        jsonReader : {
            root:"contactData",
            page: "currentPage",
            total: "totalPages",
            records: "totalRecords",
            repeatitems: false,
            id: "id"
        },      
        pager: '#pager',
        rowNum:5,
        rowList:[10,20,30],
        sortname: 'firstName',
        sortorder: 'asc',
        viewrecords: true,
        gridview: true,
        height: 250,
        width: 500,
        caption: '<spring:message code="contact.list.page.list.of.contacts"/>',
        hidegrid: false
        <security:authorize access="hasRole('ROLE_USER')">,
        onSelectRow: function(id){ 
            document.location.href ="${showContactUrl}/" + id;
        }
        </security:authorize>
      });
    });
    </script>
    
    
    
     
    
    <div>
        <table id="list">
        </table> 
    </div>
    
    <div id="pager"></div> 
</div>
