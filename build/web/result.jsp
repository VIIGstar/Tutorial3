<%-- 
    Document   : result
    Created on : Dec 17, 2018, 10:09:37 PM
    Author     : VIIGstar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List product</title>
    </head>
    <body>
        <h1>List product!</h1>
        <a href="search.jsp">Search</a>
        <jsp:useBean class="model.ProductFinderBean" id="finder" scope="request"/>
        
        <table>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Description</td>
            </tr>
            
            <c:forEach items="${finder.products}" var ="product">
                <tr>
                    <td>
                        <c:out value="${product.id}"/>
                    </td>
                    <td>
                        <c:out value="${product.name}"/>
                    </td>
                    <td>
                        <c:out value="${product.desc}"/>
                    </td>
                </tr>
                </c:forEach>
        </table>
    </body>
</html>
