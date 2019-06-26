<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		 <jsp:include page="mainheader.jsp"/><br>
		
		<form action="empServlet" method="post">
			<fieldset>
				<legend>Employee Registration Form</legend>
				<pre>
				Employee_Code : <input type="text" name="empcode"><br>
				Name          : <input type="text" name="empname"><br>
				Mobile        : <input type="text" name="empmobile"><br>
				Email         : <input type="email" name="empemail"><br>
				Status        : <input type="text" name="empstatus"><br>
				Department    : <select name="empdept">
						           <option value='1'>testing</option>
						           <option value='2'>development</option>
						           <option value='3'>hr</option>
						           <option value='4'>sales</option>
						           <option value='5'>support</option>
				                </select><br>
				                <input type="submit" value="SAVE DETAILS">
				</pre>
			</fieldset>
		</form>
</body>
</html>