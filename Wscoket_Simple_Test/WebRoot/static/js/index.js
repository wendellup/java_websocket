var url;
var ws = null;

$(function(){
//	initWebSocket();
	//服务器重启后, 3秒请求一次, 重连websocket.
	timerID = setInterval("initWebSocket()", 2000);

});

function initWebSocket(){
	try{
//		alert(ws);
		if(ws==null){
//			alert("initWebSocket");
			ws = new WebSocket(socket_url);
			ws.onmessage = function (e) {
				url = e.data;
				window.location.href= e.data;
			};
			ws.onerror = function (e) {
				console.log(e);
			};
			ws.onclose = function(e){
//				alert("close");
				ws = null;
			};
		}
        
        
    }catch(e){
        console.log(e.message);
    }
}