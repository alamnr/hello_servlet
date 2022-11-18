<%@ taglib prefix="formTags" uri="selectTag" %>
<%@ taglib prefix="selectTagFile" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title> choose bear </title>
</head>
<body>
    color list: <br/> ${applicationScope.colorList}
    <%-- <form action="/selectBeer" method="post">
        <p>Select beer characteristics : </p>
        <select name="color" size="1">
        <option value="light">light</option>
        <option value="amber">amber</option>
        <option value="brown">brown</option>
        <option value="dark">dark</option>
        </select>
        <br/><br/>
        <input type="submit">
    </form> --%>

    <form action="/selectBeer" method="post">
        <p>Select beer characteristics  with simple tag handler : </p>
        <formTags:selectSimple name="color" size="1" optionsList="${applicationScope.colorList}" />
        <br/><br/>
        <p>Select beer characteristics  with classic tag  handler: </p>
        <formTags:selectClassic name="color" size="1" optionsList="${applicationScope.colorList}" />
        <br/><br/>
        <p>Select beer characteristics  with  tag  file: </p>
        <selectTagFile:select name="color" size="1" optionsList="${applicationScope.colorList}" />
        <br/><br/>
        <input type="submit">
    </form>
</body>
</html>