<%-- <%@ attribute name="subTitle" required="true" rtexprvalue="true"%> --%>
<%@ attribute name="fontColor" required="true" %>
<%@ tag body-content="tagdependent" %>
<img src="${pageContext.request.contextPath}/images/ant.gif"> <br/>
<%-- <em><strong>${subTitle}</strong></em><br/> --%>

<em><strong><font color="${fontColor}"><jsp:doBody/></font></strong></em><br/>