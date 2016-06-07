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
			
			body{
				background-image:url(/assets/image/background/测试背景.jpg);
				background-repeat:no-repeat;
				background-size: cover;
			}
			
			li {
				list-style-type:none;
			}
		
			.hidden {
				display:none;
			}
			
			.divcitylist {
				height:100%;
				width:17%;
				border-right:1px solid #333333;
			}
			
			#list {
				margin:0px;
				height:55%;
				width:100%;
				padding-left:0px;
				overflow:auto;
				border-bottom:1px solid #333333;
			}
			
			.searchcitylist>ul {
				margin:0px;
				height:90%;
				padding-left:0px;
				overflow:auto;
			}
			
			.searchcitylist>input {
				width:30%;
				margin:0px;
				padding-left:0px;
				overflow:auto;
			}
			
			.searchcitylist {
				width:100%;
				height:44%;
			}
			
			.infopage {
				width:82%;
			}
			
			.citypage {
				position:absolute;
				top:0px;
				left:251px;
			}
			
			.districtinfo {
				position:absolute;
				top:55%;
				right:0px;
				width:30%;
				height:44%;
			}
			
			.cityinfo {
				padding:0px;
				margin:0px;
				width:55%;
				position:absolute;
				top:0px;
				left:18%;
				height:100%
			}
			
			.areapageli {
				padding-left:10px;
				height:44%;
				overflow:auto;
				position:absolute;
				top:55%;
				width:90%;
			}
			
			.areapage table{
				overflow:auto;
				padding:0px;
				margin:0px;
				width:93%;
			}
			
			.areapage td{
				
			}
		</style>
	</head>
	<body>
		<div class="divcitylist">
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
			<div class="searchcitylist">
				<input type="text"/>
				<input type="button" value="搜索城市" class="btnsearchcity"/>
				<input type="button" value="清空结果" class="clearsearchcity"/>
			</div>
		</div>
		<div class="infopage">
			<ul class="cityinfo hidden">
				<li>城市编号：<input type="text" /></li>
				<li>城市名称：<input type="text" /></li>
				<li>所属城市：<select>
						<option value="0">null</option>
						<c:forEach items="${citylist }" var="city">
							<option value="${city.cityId }">${city.cityName }</option>
						</c:forEach>
					</select>
				</li>
				<li>城市简介：<input type="text" /></li>
				<li><input type="button" class="saveupdatecity" value="保存修改"  /></li>
				<li class="areapageli">
					<div class="areapage">
						包含城区：
						<table rules="all" border="box">
						</table>
						<input class="btnaddareablock" value="新增城区" type="button"/>
						<input type="text" />
						<input class="btnsearcharea" type="button" value="搜索城区" />
					</div>
				</li>
			</ul>
			<div class="citypage">城市主页</div>
			<div class="districtinfo hidden">
				<table>
					<tr>
						<td class="header">片区编号:</td><td><input type="text" readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="header">片区名称:</td><td><input type="text" /></td>
					</tr>
					<tr>
						<td class="header">所属城区:</td>
						<td>
							<select>
								<option value = "0" selected="selected">null</option>					
								<c:forEach items="${arealist }" var="Area" >
									<option value ="${Area.areaId }">${Area.areaName }</option>	
								</c:forEach> 
							</select>  
						</td>
					</tr>
					<tr>
						<td class="header">片区简介:</td><td><input type="text" /></td>
					</tr>
				</table>
				<input class="buttonsavedis" type="button" value="保存">
				<input class="buttonadddis" type="button" value="添加">
				<input type="text" />
				<input class="buttonsearchdis" type="button" value="搜索地区">
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(function(){
			CITY.init();
		});
	</script>
</html>