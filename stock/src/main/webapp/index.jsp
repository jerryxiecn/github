<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>家庭股票分析</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="学习">
<meta http-equiv="description" content="springmvc+mybatis+easyui示例项目">
<jsp:include page="inc.jsp"></jsp:include>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',href:'/stock/layout/north.jsp'" style="height: 60px;overflow: hidden;" class="logo"></div>
	<div data-options="region:'center',title:'欢迎使用家庭数据分析系统',href:'/stock/layout/center.jsp'" style="overflow: hidden;"></div>
	<div data-options="region:'south',href:'/stock/layout/south.jsp'" style="height: 27px;overflow: hidden;"></div>
	<div data-options="region:'west',title:'功能导航',href:'/stock/layout/west.jsp'" style="width: 200px;overflow: hidden;"></div>
</body>
</html>