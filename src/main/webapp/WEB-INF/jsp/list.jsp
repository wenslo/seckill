<%@page contentType="text/html;charset=UTF-8" language="java"  %>
<!-- 引用jstl -->
<%@include file="common/tag.jsp"%>
<html>
<head>
  <title>秒杀列表页</title>
  <%@include file="common/head.jsp"%>
</head>
<body>
  <!-- 页面显示部分 -->
  <div class="container">
    <div class="panel panel-default">
      <div class="panel panel-heading text-center">
        <h2>秒杀也聊</h2>
      </div>
      <div class="panel-body">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>名称</th>
              <th>库存</th>
              <th>开始时间</th>
              <th>结束时间</th>
              <th>创建时间</th>
              <th>详情页</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="sk" items="${list}">
              <tr>
                <td>${sk.name}</td>
                <td>${sk.number}</td>
                <td>
                  <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                  <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                  <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                  <a class="btn btn-info" href="/seckill/${sk.seckillId}/detail">link</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

</html>