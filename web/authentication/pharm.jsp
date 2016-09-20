<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Sign Up</h1>
<s:form action="pharmsignup">
    <s:textfield name="username" label="User Name"></s:textfield>
    <s:textfield name="password" label="Password" type="password"></s:textfield>
    <s:textfield name="confpassword" label="Confirm password" type="password"></s:textfield>
    <s:textfield name="name" label="Enter your name"></s:textfield>
    <s:textfield name="surname" label="Enter your last name"></s:textfield>
    <s:submit value="Sign me Up!"></s:submit>
</s:form>
</body>
</html>