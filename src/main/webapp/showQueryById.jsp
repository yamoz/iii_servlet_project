<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.SqlQuery"%>
<%@ page import="service.statusCode"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>丹丹漢堡訂餐系統</title>
<link rel="stylesheet"
	href="https://meyerweb.com/eric/tools/css/reset/reset.css" />
<link rel="stylesheet" href="css/style.css">
<style>
#orderTable {
	margin-top: 100px;
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
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

input {
	/* 	display: inline; */
	width: 100%;
	height: 100%;
	text-align: center;
}

.content {
	margin-top: 100px;
}

h3 {
	padding-top: 30px; text-align : center;
	font-size: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<%
	Object storedDataObj = request.getAttribute("queryData");
	ArrayList<ArrayList<String>> storedData = (ArrayList<ArrayList<String>>) storedDataObj;
	int arrSize = storedData.size();
	%>
	<header>
		<a href="<core:url value='/' />" class="logo"> <img
			src="images/logo-2-1024x276.png"></img>
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
	<div class="content">
		<%
		if (arrSize > 0) {
		%>
		<form action="<core:url value='/Middleware' />" method="post">
			<table id="orderTable">
				<tr>
					<th>email</th>
					<th>訂單編號</th>
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
					<th>修改訂單</th>
					<th>刪除訂單</th>
				</tr>
				<tr>

					<!-- 					<td><input type="text" name="emailShow" -->
					<%-- 						value="<%=storedData.get(0).get(1)%>" disabled="disabled"></td> --%>
					<td><%=storedData.get(0).get(1)%></td>
					<!-- 					<td><input type="text" name="queryIdShow" -->
					<%-- 						value="<%=storedData.get(0).get(0)%>" disabled="disabled" --%>
					<!-- 						size="50"></td> -->
					<td><%=storedData.get(0).get(0)%></td>
					<%
					for (int i = 0; i < arrSize; i++) {
						ArrayList<String> valueList = storedData.get(i);
					%>
					<%
					for (int j = 2; j < 11; j++) {
					%>
					<td><input type="text" name="item_<%=j - 1%>"
						value="<%=valueList.get(j)%>" size="1" pattern="[0-9]{1,1}" /></td>
					<%
					}
					%>
					<!-- 					<td><input type="text" name="status" -->
					<%-- 						value="<%=statusCode.statusCodeTrans(Integer.valueOf(storedData.get(0).get(11)))%>" --%>
					<!-- 						disabled="disabled"></td> -->
					<td><%=statusCode.statusCodeTrans(Integer.valueOf(storedData.get(0).get(11)))%></td>
					<!-- 					<td><input type="text" name="createdDate" -->
					<%-- 						value="<%=storedData.get(0).get(12)%>" disabled="disabled"></td> --%>
					<td><%=storedData.get(0).get(12)%></td>
					<!-- 					<td><input type="text" name="editedDate" -->
					<%-- 						value="<%=storedData.get(0).get(13)%>" disabled="disabled"></td> --%>
					<td><%=storedData.get(0).get(13)%></td>
					<td><button type="submit">update</button></td>
					<%
					}
					%>
					<td><input type="hidden" name="email"
						value="<%=storedData.get(0).get(1)%>"> <input
						type="hidden" name="queryId" value="<%=storedData.get(0).get(0)%>">
						<input type="hidden" name="FormName" value="updateForm" />
						</form>

						<form action="./Middleware" method="post">
							<input type="hidden" name="email"
								value="<%=storedData.get(0).get(1)%>"> <input
								type="hidden" name="queryId"
								value="<%=storedData.get(0).get(0)%>"> <input
								type="hidden" name="FormName" value="deleteForm" />
							<button type="submit">delete</button>

						</form></td>
				</tr>

			</table>
			<%
			} else {
			%>
			<h3>查無資料!</h3>
			<%
			}
			%>
		
	</div>
</body>
</html>