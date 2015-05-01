<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">    
  </head>
  
  <body>
    This is my JSP page. <br>
    <div class="table-responsive">
    <table class="table table-condensed">
		<thead>
		   <tr>
			<th>航班信息</th>
			<th>起飞/降落时刻</th>
			<th>起/降机场</th>
			<th>飞行时间</th>
			<th>价格/准点率</th>
			</tr>
	   </thead>
		<tbody>
		<c:forEach items="${jipiaolist}" var="name">
		  <tr>
            <td>${name.carrierCom }&nbsp;&nbsp;${name.flightCode }</td>
            <td>${name.departureTime }</td>
            <td>${name.departureAirport }</td>
            <td rowspan="2">${name.costTime }</td>
            <td>${name.planeMemo }</td>
          </tr>
          <tr>
            <td>${name.planeType }&nbsp;&nbsp;(${name.planeSize})</td>
            <td>${name.arrivalTime }</td>
            <td>${name.arrivalAirport }</td>
            <td>${name.correctness }</td>
          </tr>
          </c:forEach>
		</tbody>	   
	</table>
	</div>
    
    
  	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="dist/js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="dist/js/bootstrap.min.js"></script>
  </body>
</html>
