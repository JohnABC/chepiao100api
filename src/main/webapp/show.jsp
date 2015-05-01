<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'show.jsp' starting page</title>
    
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
			<th>车次</th>
			<th>发站/到站</th>
			<th>发时/到时</th>
			<th>运行时间</th>
			<th>参考票价</th>
			<th>参考余票</th>
			</tr>
	   </thead>
		<tbody>
		<c:forEach items="${chepiaolist}" var="name">
		  <tr>
            <td rowspan="2">${name.trainCode }</td>
            <td rowspan="2">${name.startStation }</td>
            <td rowspan="2">${name.startTime }</td>
            <td rowspan="2">${name.takeTime }</td>
            <td>商务座:&nbsp;&nbsp;${name.business_prc }</td>
            <td>${name.business }张</td>
          </tr>
          <tr>
            <td>特等座:&nbsp;&nbsp;${name.best_seat_prc }</td>
            <td>${name.best_seat }张</td>
          </tr>
          <tr>
            <td rowspan="7">${name.trainGrade }</td>
            <td rowspan="7">${name.arriveStation }</td>
            <td rowspan="7">${name.endTime }</td>
            <td rowspan="7">${name.day_diff }</td>
            <td>一等座:&nbsp;&nbsp;${name.one_seat_prc }</td>
            <td>${name.one_seat }张</td>
          </tr>
          <tr>
            <td>二等座:&nbsp;&nbsp;${name.two_seat_prc }</td>
            <td>${name.two_seat }张</td>
          </tr>
          <tr>
            <td>高级软座:${name.vag_sleeper_prc }</td>
            <td>${name.vag_sleeper }张</td>
          </tr>
          <tr>
            <td>软&nbsp;&nbsp;卧&nbsp;:&nbsp;&nbsp;&nbsp;${name.soft_sleeper_prc }</td>
            <td>${name.soft_sleeper }张</td>
          </tr>
          <tr>
            <td>硬&nbsp;&nbsp;卧&nbsp;:&nbsp;&nbsp;&nbsp;${name.hard_sleeper_prc }</td>
            <td>${name.hard_sleeper }张</td>
          </tr>
          <tr>
            <td>软&nbsp;&nbsp;座&nbsp;:&nbsp;&nbsp;&nbsp;${name.soft_seat_prc }</td>
            <td>${name.soft_seat }张</td>
          </tr>
          <tr>
            <td>硬&nbsp;&nbsp;座&nbsp;:&nbsp;&nbsp;&nbsp;${name.hard_seat_prc }</td>
            <td>${name.hard_seat }张</td>
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
