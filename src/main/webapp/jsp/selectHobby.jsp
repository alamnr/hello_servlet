
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Select hobby</title>
</head>
<body>

    <form method="post" action="<%= request.getContextPath() %>/helloServlet">
        Choose a hobby: <select name="hobbyName" size="1">
            <option>horse skiing</option>
            <option>fuck</option>
            <option>suck</option>
            <option>hug</option>
        </select>
       
        <input type="submit">
    </form>
</body>