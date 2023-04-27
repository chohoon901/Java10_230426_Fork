<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
    <h1>게시판</h1>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>내용</th>
        </tr>
        <c:forEach var="post" items="${PostList}">
            <tr>
                <td><c:out value="${post.ID}"/></td>
                <td><c:out value="${post.WRITER}"/></td>
                <td><c:out value="${post.WRITING}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
