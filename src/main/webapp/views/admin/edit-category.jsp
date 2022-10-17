<%--
  Created by IntelliJ IDEA.
  User: andreatran
  Date: 08/10/2022
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/admin/category/edit" var="edit"></c:url>
<form role="form" action="${edit}" method="post"
      enctype="multipart/form-data">
    <input name="id" value="${category.cateid }" hidden="">
    <div class="form-group">
        <label>Tên danh sách:</label> <input type="text" class="form-control"
                                             value="${category.catename }" name="name" />
    </div>
    <div class="form-group">
        <label>Trang thai:</label> <input type="text" class="form-control"
                                             value="${category.status }" name="status" />
    </div>
    <div class="form-group">
        <c:url value="/image?fname=${category.icon }" var="imgUrl"></c:url>
        <img class="img-responsive" width="100px" src="${imgUrl}"
             alt="">
        <label>Ảnh đại diện</label> <input type="file" name="images"
                                           value="${category.icon }" />
    </div>
    <button type="submit" class="btn btn-default">Edit</button>
    <button type="reset" class="btn btn-primary">Reset</button>
</form>

</body>
</html>
