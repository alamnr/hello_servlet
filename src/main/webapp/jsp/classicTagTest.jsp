<%@ taglib prefix="mine" uri="classicTags"%>
<!DOCTYPE html>
<html>
<head>
<title>Classic tag test </title>
</head>
<body> 
    Classic tag - 1 : <br/><br/>
    <mine:classicOne/> 
    <br/><br/>
    Classic tag test - 2 : 
    <br/><br/>
    <mine:classicTwo/><br/><br/>
    Classic tag test with body - 3 : 
    <br/><br/>
    <mine:simpleBody>
        This is the body
    </mine:simpleBody>
    <br/><br/>
    Classic tag test with body iteration  4 : <br/><br/>
    <table border="1">
    <mine:iterateMovies>
        <tr><td>${movie}</td></tr>
    </mine:iterateMovies>
    </table>
</body>
</html>
