<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"/><br>

	<form action="adminregister" method="post">
	    <fieldset>
	         <legend>Admin Registration Form</legend>
	         <pre>
		         Admin_id : <input type="text" name="adminid" placeholder="ADMIN_ID"><br>
		         UserName : <input type="text" name="adminuname" placeholder="Admin_Username"><br>
		         Password : <input type="password" name="adminpwd" placeholder="Admin_Pwd"><br>
				            <input type="submit" value="SAVE">
	         </pre>
	    </fieldset>
	</form>
</body>
</html>