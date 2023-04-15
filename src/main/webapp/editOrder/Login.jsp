<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>丹丹漢堡訂餐系統</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>


    <div>
        <!-- 第一區header -->
    <header class="space">
        <a href="<core:url value='/' />" class="logo">
            <img src="img/logo-2-1024x276.png"></img>
        </a>
        <ul class="nav-links">
            <li class="nav-item"><a href="<core:url value='/editOrder/Login.jsp' />">修改訂單</a></li>
            <li class="nav-item"><a href="<core:url value='/showAllDatas.jsp' />">顯示所有訂單</a></li>
            <li class="nav-item"><a href="#">News</a></li>
            <li class="nav-item"><a href="#">Sign in</a></li>
        </ul>
    </header>


        <form action="<core:url value='/Middleware' />" method="post">
        <div class="container">
            <div class="box">
                <h2>查詢訂單</h2>
                <div><!-- 密碼欄位 -->
                    <input type="text" placeholder="訂單編號" name="queryId" pattern="[0-9]{1,8}" required="required">
                    <i class="icon fas fa-envelope fa-lock"></i>
                </div>
                <div> <!-- 帳號欄位 -->
                    <input type="text" placeholder="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required="required">
                    <i class="icon fas fa-envelope"></i>
                </div>
                <input type="hidden" name="FormName" value="showDataByIdForm"/>
                <!-- 登入按鈕 -->
                <input type="submit" value="查詢">

            </div>

        </div>
        </form>
    </div>
    <script src="js/script.js"></script>

</body>

</html>