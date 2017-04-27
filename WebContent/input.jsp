<%@page import="cn.mldn.vo.Area"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xmlHttpRequest ;	// 这个是Ajax的核心处理对象，所有的异步处理操作都通过此对象完成
	function create() {	// 定义一个函数，此函数负责创建XMLHttpRequst对象实例
		if (window.XMLHttpRequest) {	// 当前浏览器使用的不是IE
			xmlHttpRequest = new XMLHttpRequest() ;	// 直接实例化对象
		} else {	// 使用的是IE浏览器
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHttp") ;
		}
	}
	window.onload = function() {
		document.getElementById("area").addEventListener("change",function(){
			aid = this.value ;
			if (aid != "") {
				create() ;	// 创建XMLHttpRequest对象
				// 定义要进行处理的程序路径
				xmlHttpRequest.open("get","areaplus?aid=" + aid) ;
				// 进行请求的发送处理
				xmlHttpRequest.send(null) ;	// 此时参数通过地址重写传递了
				xmlHttpRequest.onreadystatechange = function() {	// 定义信息返回的回调处理函数
					if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
						alert("ddd");
						cityObj = eval("(" + xmlHttpRequest.responseText + ")") ;
						cityElement = document.getElementById("city") ;
						cityElement.length = 1 ;
						for (x = 0 ; x < cityObj.allplus.length ; x ++) {
							optionElement = document.createElement("option") ;
							optionElement.setAttribute("value",cityObj.allplus[x].apid) ;
							optionElement.appendChild(document.createTextNode(cityObj.allplus[x].title)) ;
							cityElement.appendChild(optionElement) ;
						}
					}
				}
			} else {
				cityElement = document.getElementById("city") ;
				cityElement.length = 1 ;
			}
		},false) ;
	}
</script>
</head>
<body>
<form action="" method="post">
	省份：<select id="area">
			<option value="">====== 请选择您所在省份 ======</option>
		 	<c:forEach items="${allAreas}" var="area">
				<option value="${area.aid}">${area.title}</option>
			</c:forEach> 
			

		</select>
	城市：<select id="city">
			<option value="">====== 请选择您所在城市 ======</option>
		</select>
</form>
</body>
</html>