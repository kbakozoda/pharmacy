<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.09.2016
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Create new drug type</title>
</head>
<body>
    <h1>Create new drug type</h1>
    <s:form action="drugtypecreate">
        <s:textfield label="Enter drug type name" name="name"></s:textfield>
        <s:submit value="Submit"/>
    </s:form>
</body>
</html>
