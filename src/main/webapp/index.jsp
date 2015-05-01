<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>   
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">    
  </head>
  
  <body>
  <div class="row">
    <div class="col-md-6">
		<form role="form" action="/chepiao100api/chepiao100api?ac=querychepiao" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">起点</label>
		    <input name="startStation" type="text" class="form-control" id="exampleInputEmail1" placeholder="起点">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">终点</label>
		    <input name="arriveStation" type="text" class="form-control" id="exampleInputPassword1" placeholder="终点">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputFile">日期</label>
		    <input name="date" type="text" class="form_datetime" value="" placeholder="点击选择" readonly>
		    <p class="help-block">Example block-level help text here.</p>
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
    </div>
    <div class="col-md-6">
    			
		  <form role="form" action="/chepiao100api/chepiao100api?ac=queryjipiao" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">起点</label>
		    <input name="departureAirport" type="text" class="form-control" id="exampleInputEmail1" placeholder="起点">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">终点</label>
		    <input name="arrivalAirport" type="text" class="form-control" id="exampleInputPassword1" placeholder="终点">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputFile">日期</label>
		    <input name="date" type="text" class="form_datetime" value="" placeholder="点击选择" readonly>
		    <p class="help-block">Example block-level help text here.</p>
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
    </div>
  </div>
  



  </body>
    <script type="text/javascript" src="dist/js/jquery-1.10.2.js" charset="UTF-8"></script>
  <script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="dist/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="dist/js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
  <script type="text/javascript">
    $(".form_datetime").datetimepicker({
    format: 'yyyy-mm-dd',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
    minView: 2
    
    });
  </script>
</html>
