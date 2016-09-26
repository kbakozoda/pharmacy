<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Welcome User, please login below</h3>
<s:form action="tryAuthorise">
    <s:textfield name="username" label="User Name"></s:textfield>
    <s:textfield name="password" label="Password" type="password"></s:textfield>
    <s:submit value="Login"></s:submit>
</s:form>
</body>
</html>
