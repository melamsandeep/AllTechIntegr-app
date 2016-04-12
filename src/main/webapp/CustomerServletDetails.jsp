
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h2>Custom Form based Login Page</h2>

	  <form action="/integrationPrj/CustomerServlet?${_csrf.parameterName}=${_csrf.token}" method="POST">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type='text' name='Name' /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type='text' name='Age'></td>
			</tr>
						<tr>
				<td>Sex:</td>
				<td><input type='text' name='Sex'></td>
			</tr>
			
			<tr>
				<td>Id:</td>
				<td><input type='text' name='Id'></td>
			</tr>
			
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="Submit"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>
