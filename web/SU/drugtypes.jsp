<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>Drug Types</title>
</head>
<body>
<div class="article">
    <header>
<h1>All existing types</h1>
        </header>

    <nav class="nav">
        <li><a href="/superuser/requests.action">View requests</a></li>
        <li><a href="/superuser/users.action">View all users</a></li>
        <li><a href="/superuser/networks.action">View networks</a></li>
        <li><a href="/superuser/drugs.action">View drugs</a></li>
        <li><a href="/user/info">My credentials</a></li>
        <li><a href="/superuser/welcome.action">Back</a> </li>
        <li><a href="logout.action">Logout</a></li>
    </nav>

    <article class="article">
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:url id="deleteURL" action="deletedrugtype">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a></td>
                    <td><s:url id="editURL" action="editdrugtype">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{editURL}">Edit</s:a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/superuser/newdrugtype.action">Create New</a>
        <a target="_blank" href="typesPDF.action">Generate PDF</a>
        <a target="_blank" href="typesXLS.action">Generate XLS</a>
        <a target="_blank" href="typesCSV.action">Generate CSV</a>
    </article>
    </div>
</s:if>
<s:if test="list.size() = 0">
    <h1>The list is empty yet.</h1>
</s:if>
<s:actionerror/>

</div>
<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>
</body>
</html>
