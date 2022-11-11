<form action="${pageContext.request.contextPath}/addComment" method="post">
    Add your comment :</br>
    <textarea name="input" cols="40" rows="10"> </textarea> </br>
    <input type="hidden" name="userType" value="${param.userType}">
    <input type="submit" value="Add comment">
</form>