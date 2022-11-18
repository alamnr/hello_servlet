<%@ tag body-content="empty" dynamic-attributes="tagAttrs"%>
<%@ attribute name="optionsList" type="java.util.List" required="true" rtexprvalue="true" %>
<%@ attribute  name="name" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<select name="${name}" 
    <c:forEach var="attrEntry" items="${tagAttrs}">
        ${attrEntry.key}="${attrEntry.value}"
    </c:forEach>
>

<c:forEach var="option" items="${optionsList}">
    <option value="${option}">${option}</option>
</c:forEach>

</select>