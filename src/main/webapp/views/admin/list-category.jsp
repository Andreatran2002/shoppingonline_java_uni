<%--
  Created by IntelliJ IDEA.
  User: andreatran
  Date: 01/10/2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${cateList}" var="cate" varStatus="STT" >
    <tr class="odd gradeX">
        <td>${STT.index+1 }</td>
        <c:url value="/image?fname=${cate.images }" var="imgUrl"></c:url>
        <td><img height="150" width="200" src="${imgUrl}" /></td>
        <td>${cate.catename }</td>
        <td>${cate.status }</td>
        <td><a href="<c:url value='/admin/category/edit?id=${cate.cateid }'/>"
               class="center">Sửa</a>
            | <a href="<c:url value='/admin/category/delete?id=${cate.cateid }'/>"
                 class="center">Xóa</a></td>
    </tr>
</c:forEach>
</body>
</html>
