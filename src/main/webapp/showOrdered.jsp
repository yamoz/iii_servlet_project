<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.SqlQuery"%>
<%@ page import="service.statusCode"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>丹丹漢堡訂餐系統</title>
<link rel="stylesheet" href="css/style.css">
<style>
#orderDetail {
	margin-top: 100px;
}

#orderTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#orderTable td, #orderTable th {
	border: 1px solid #ddd;
	padding: 8px;
}

#orderTable tr:nth-child(even) {
	background-color: #f2f2f2;
}

#orderTable tr:hover {
	background-color: #ddd;
}

#orderTable th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
	<header>
		<a href="<core:url value="/" />" class="logo"> <img src="images/logo-2-1024x276.png"></img>
		</a>
		<ul class="nav-links">
			<li class="nav-item"><a
				href="<core:url value='/editOrder/Login.jsp' />">修改訂單</a></li>
			<li class="nav-item"><a
				href="<core:url value='/showAllDatas.jsp' />">顯示所有訂單</a></li>
			<li class="nav-item"><a href="#">News</a></li>
			<li class="nav-item"><a href="#">Sign in</a></li>
		</ul>
	</header>
	<div id="orderDetail">
		<h5>訂單明細</h5>
		<table id="orderTable">
			<tr>
				<th>訂單編號</th>
				<th>email</th>
				<th>品項1</th>
				<th>品項2</th>
				<th>品項3</th>
				<th>品項4</th>
				<th>品項5</th>
				<th>品項6</th>
				<th>品項7</th>
				<th>品項8</th>
				<th>品項9</th>
				<th>取餐狀態</th>
				<th>訂單建立日期</th>
				<th>訂單修改日期</th>
			</tr>
			<!--read by id-->
			<!--update by id-->

			<%
			Object storedDataObj = request.getAttribute("ordered");
			ArrayList<ArrayList<String>> storedData = (ArrayList<ArrayList<String>>) storedDataObj;
			// 		ArrayList<ArrayList<String>> storedData = new ArrayList<ArrayList<String>>();
			// 		if ( storedDataObj instanceof ArrayList<?> ){
			// 			ArrayList<?> a = (ArrayList<?>)storedDataObj;
			// 			if ( a instanceof ArrayList<?> ){
			// 				for ( Object b:a ){
			// 					if ( b instanceof String ){
			// 						String c = (String)b;
			// 					}
			// 				}
			// 			}
			// 		}
			// 		ArrayList<ArrayList<String>> storedData = SqlQuery.storeOrderdataToSql(request);
			int arrSize = storedData.size();

			for (int i = 0; i < arrSize; i++) {
			%>
			<tr>
				<%
				for (int j = 0; j < storedData.get(i).size(); j++) {
					if (j == 11) {
						Integer temp = Integer.valueOf(storedData.get(i).get(11));
						String statusStr = statusCode.statusCodeTrans(temp);
				%>
				<td><%=statusStr%></td>
				<%
				} else {
				%>
				<td><%=storedData.get(i).get(j)%></td>
				<%
				}
				%>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>