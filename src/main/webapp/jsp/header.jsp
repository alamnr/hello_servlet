<%@ taglib prefix="mine" uri="/WEB-INF/function.tld" %>
<div>
<img src="${pageContext.request.contextPath}/images/ant.gif" alt="Ant"/>
<h1>Random no: ${mine:rollIt()}</h1>
<em><strong>${param["subTitle"]}</strong></em>
</div>
