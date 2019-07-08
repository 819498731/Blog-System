<%--
  Created by IntelliJ IDEA.
  User: mhq
  Date: 2019/4/16
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>留言管理系统</title>
    <link rel="stylesheet" href="/css/bootstrap4.0.min.css" >
    <script src="/js/jquery.slim.min.js" ></script>
    <script src="/js/popper.min.js" ></script>
    <script src="/js/bootstrap4.0.min.js"></script>
    <script src="/js/layer.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand text-success" href="/admin/main">留言管理</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

            <li class="nav-item ">
                <a class="nav-link" href="/admin/main">主页 </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/admin/leaveMsgs/list">留言板管理</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/admin/article/search" method="GET">
            <input class="form-control mr-sm-2" type="search" placeholder="文章标题或内容..." aria-label="Search" name="word">
            <button class="btn btn-outline-success my-2 my-sm-0 btn-sm" type="submit">搜索</button>
        </form>

        <a class="btn btn-outline-danger btn-sm" href="/admin/logout" role="button">退出</a>
    </div>
</nav>

    <table class="table table-sm">
        <thead>
        <tr class="table-info">
            <th>id</th>
            <th>发表时间</th>
            <th>留言</th>
            <th>昵称</th>
            <th>邮箱</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${leavemsgs}" var="lm">
            <tr>
                <th scope="row">${lm.id}</th>
                <td>${lm.times}</td>
                <td>${lm.message}</td>
                <td>${lm.name}</td>
                <td>${lm.email}</td>
                <td><button type="button" class="btn btn-outline-danger btn-sm" onclick="ifdelete('${lm.id}') ">删除</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
   <nav aria-label="Page navigation example" style="position: absolute;bottom: 10px;left: 42%">
    <ul class="pagination justify-content-center">
        <li class="page-item  <c:if test="${pageInfo.pageNum==1}">disabled</c:if> ">
            <a class="page-link" href="/admin/leavemsgs/list?page=1" >&laquo;</a>
        </li>
        <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">
            <li class="page-item <c:if test="${pageInfo.pageNum==pageNo}">active</c:if>"><a class="page-link" href="/admin/leavemsgs/list?page=${pageNo}">${pageNo}</a></li>
        </c:forEach>
        <li class="page-item  <c:if test="${pageInfo.pageNum==pageInfo.pages}">disabled</c:if> ">
            <a class="page-link" href="/admin/leavemsgs/list?page=${pageInfo.pages}">&raquo;</a>
        </li>
    </ul>
</nav>
<script src="/js/jquery-3.2.1.min.js"></script>
<script>
    function ifdelete(id) {
        layer.confirm('确定删除该文章吗?', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                type: 'POST',
                url: '/api/leaveMsgs/del',
                datatype:'json',
                data:{"id":id},
                success: function(data){
                    if(data['stateCode']==1){
                        layer.msg('删除成功!',{icon:1,time:1000});
                        setTimeout("window.location.reload()",1000);
                    }
                    else {
                        layer.msg('删除失败!',{icon:5,time:1000});
                    }
                },
                error:function(data) {
                    console.log('错误...');
                },
            });
        }, function(){

        });
    }

</script>

</body>
</html>
