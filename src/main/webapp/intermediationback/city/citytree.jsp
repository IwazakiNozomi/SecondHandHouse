<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		
		<script src="/assets/js/city.js"></script>
		<title>City Tree</title>
		
		<style type="text/css">
			
			body,html {
				height:100%;
				width: 100%;
				margin:0px;
			}
			
			li {
				list-style-type:none;
			}
		
			.hidden {
				display:none;
			}
			
			#list {
				margin:0px;
				width:250px;
				height:100%;
				padding-left:0px;
				border-right:1px solid #333333;
			}
			
			.cityinfo {
				position:absolute;
				top:0px;
				left:251px;
			}
		</style>
	</head>
	<body>
		<ul class="citylist" id="list">
			<c:forEach items="${citylist }" var="city" >
				<c:if test="${city.parentCityId==0 }">
					<li class="city">
						<a class="hidden">${city.cityId }</a>
						<a class="cityname">${city.cityName }</a>
						<input type="button" class="opspread" value="展开"/>
						<input type="button" class="opputaway hidden" value="收起"/>	
					</li>
				</c:if>
			</c:forEach>
		</ul>
		<div class="cityinfo">
			<ul class="cityinfo">
				<li><input type="text" /></li>
				<li><input type="text" /></li>
				<li><input type="text" /></li>
				<li><input type="text" /></li>
			</ul>
		</div>	
	</body>
	<script type="text/javascript">
		$(function(){
			CITY.init();
		});
	</script>
</html>