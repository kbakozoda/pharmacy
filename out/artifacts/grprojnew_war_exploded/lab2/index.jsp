<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
  <title>Hello World</title>
</head>
<body>
<s:form action="HelloWorld" >
  <s:textfield name="username" label="User Name" />
  <s:submit />
</s:form>
</body>
</html>
