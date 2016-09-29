<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<html>
<head>
    <title>Pharmacists</title>
</head>
<body>
<div class="flex-container">
<header>Pharmacists</header>
<nav class="nav">
    <ul>
        <li>
            <a href="/admin/createPhst.action">Create new</a>
        </li>
        <li>
            <a href="/admin/welcome.action">Back</a><br>
        </li>
    </ul>
</nav>

<article class="article">
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Surname</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="username"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="surname"/></td>

                    <td><s:url id="delURL" action="phstDel">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{delURL}">Delete</s:a>
                    </td>

                    <td><s:url id="editURL" action="phstEdit">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{editURL}">Edit</s:a></td>
                </tr>
            </s:iterator>
        </table>
        <s:url id="pdfURL" action="phstPDF">
            <s:param name="id" value="%{networkId}"></s:param>
        </s:url>
        <s:a href="%{pdfURL}">PDF</s:a> |

        <s:url id="xlsURL" action="phstXLS">
            <s:param name="id" value="%{networkId}"></s:param>
        </s:url>
        <s:a href="%{xlsURL}">XLS</s:a> |

        <s:url id="csvURL" action="phstCSV">
            <s:param name="id" value="%{networkId}"></s:param>
        </s:url>
        <s:a href="%{csvURL}">CSV</s:a>

    </div>
</s:if>
<s:if test="list.size() = 0">
    <h1>No pharmacists.</h1>
</s:if>
<s:actionerror/>
</article>
<footer id="copyright">Copyright 2016, Loosers inc.</footer>
</div>
</body>
</html>
