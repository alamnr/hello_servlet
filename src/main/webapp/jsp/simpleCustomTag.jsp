<%@ taglib prefix="myTags" uri="simpleTags" %>

<html>
<head>
<title>Simple tag test</title>
</head>
<body>
    Simple 1   : <myTags:simple1 />
    <br/>
    Simple 2 : 
    <myTags:simple2>
        This is the body
    </myTags:simple2>
    <br/>
    Simple 3:
    <myTags:simple3>
       Message is: ${message}
    </myTags:simple3>
    <br/>
    Simple 4:
    <table>
        <myTags:simple4>
            <tr><td>${movie}</td></tr>
        </myTags:simple4>
    </table>

    Simple 5:
    <table>
        <myTags:simple5 movieList="${movieCollection}">
            <tr>
                <td>${movie.name}</td>
                <td>${movie.genre}</td>
            </tr>
        </myTags:simple5>
    </table>

</body>
</html>