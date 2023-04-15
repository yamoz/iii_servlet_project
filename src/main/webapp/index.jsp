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
    <!-- css連接 -->
<!--     <link rel="stylesheet" href="https://meyerweb.com/eric/tools/css/reset/reset.css"> -->
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <!-- 第一區header -->
    <header>
        <a href="<core:url value='/' />" class="logo">
            <img src="images/logo-2-1024x276.png"></img>
        </a>
        <ul class="nav-links">
            <li class="nav-item"><a href="<core:url value='/editOrder/Login.jsp' />">修改訂單</a></li>
            <li class="nav-item"><a href="<core:url value='/showAllDatas.jsp' />">顯示所有訂單</a></li>
            <li class="nav-item"><a href="#">News</a></li>
            <li class="nav-item"><a href="#">Sign in</a></li>
        </ul>
    </header>
    <form action="<core:url value='/Middleware' />" method="post">
        <!-- 第二區menu -->
        <section class="menu" id="menu">
            <div class="box-container">
                <!-- 1號餐 -->
                <div class="box">
                    <img src="images/No1.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus1">-</span>
                        <span class="num1" id="num1">0</span>
                        <span class="plus1">+</span>
                    </div>
                </div>
                <!-- 2號餐 -->
                <div class="box">
                    <img src="images/No2.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus2">-</span>
                        <span class="num2" id="num2">0</span>  
                        <span class="plus2">+</span>
                    </div>
                </div>
                <!-- 3號餐 -->
                <div class="box">
                    <img src="images/No3.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus3">-</span>
                        <span class="num3" id="num3">0</span>
                        <span class="plus3">+</span>
                    </div>
                </div>
            </div>
            <div class="box-container">
                <!-- 4號餐 -->
                <div class="box">
                    <img src="images/No4.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus4">-</span>
                        <span class="num4" id="num4">0</span>
                        <span class="plus4">+</span>
                    </div>
                </div>
                <!-- 5號餐 -->
                <div class="box">
                    <img src="images/No5.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus5">-</span>
                        <span class="num5" id="num5">0</span>
                        <span class="plus5">+</span>
                    </div>
                </div>
                <!-- 6號餐 -->
                <div class="box">
                    <img src="images/No6.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus6">-</span>
                        <span class="num6" id="num6">0</span>
                        <span class="plus6">+</span>
                    </div>
                </div>
            </div>
            <div class="box-container">
                <!-- 7號餐 -->
                <div class="box">
                    <img src="images/No7.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus7">-</span>
                        <span class="num7" id="num7">0</span>
                        <span class="plus7">+</span>
                    </div>
                </div>
                <!-- 8號餐 -->
                <div class="box">
                    <img src="images/No8.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus8">-</span>
                        <span class="num8" id="num8">0</span>
                        <span class="plus8">+</span>
                    </div>
                </div>
                <!-- 9號餐 -->
                <div class="box">
                    <img src="images/No9.png">
                    <!-- plus -->
                    <div class="counter wrapper">
                        <span class="minus9">-</span>
                        <span class="num9" id="num9">0</span>
                        <span class="plus9">+</span>
                    </div>
                </div>


            </div>


        </section>
       <div class="email">
        <span>請輸入email: </span><input type="email" id="email" name="email"
       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" size="30" required>
       </div>
       
       <input type="submit" class="submit" id="submit" value="送出訂單">
       
        <input type="hidden" id="item_1" name="item_1" value="0">
        <input type="hidden" id="item_2" name="item_2" value="0">
        <input type="hidden" id="item_3" name="item_3" value="0">
        <input type="hidden" id="item_4" name="item_4" value="0">
        <input type="hidden" id="item_5" name="item_5" value="0">
        <input type="hidden" id="item_6" name="item_6" value="0">
        <input type="hidden" id="item_7" name="item_7" value="0">
        <input type="hidden" id="item_8" name="item_8" value="0">
        <input type="hidden" id="item_9" name="item_9" value="0">
        <input type="hidden" name="FormName" value="orderForm"/>
       

    </form>
    <!-- 第三區footer -->
    <section class="footer" id="footer">
        <div class="social">
            <a href="#"><img src="images/facebook.png" alt=""></a>
            <a href="#"><img src="images/ig.png" alt=""></a>
            <a href="#"><img src="images/LINE.png" alt=""></a>
         </div>
    </section>


</body>
<script src="js/script.js"></script>

</html>