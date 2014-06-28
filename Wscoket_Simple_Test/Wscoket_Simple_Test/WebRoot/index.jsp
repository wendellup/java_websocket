<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   var webSocket =  new WebSocket('ws://202.102.103.139:8080/ws/handler');
   webSocket.onmessage = function(event) {showMessage(event);}
   function showMessage(event){
	   document.getElementById("showContainer").innerHTML+="<br/>"+event.data;
   }
   
   function sendMsg(){
	   webSocket.send("hello!");
   }
</script>
</head>
<body>
<div id="showContainer"></div>
<input type="button" value="send" onclick="sendMsg()"></input>  
</body>
</html>