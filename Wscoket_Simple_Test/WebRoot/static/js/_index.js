var url;

$(function(){
    try{
        var ws = new WebSocket(socket_url);
        ws.onmessage = function (e) {
//        	alert(e.data);
        	url = e.data;
//            window.location.href= e.data;
        };
        ws.onerror = function (e) {
            console.log(e);
        };
        ws.onclose = function(e){
//        	alert("close"+", e.data="+e.data+", url"+url);
        	if(e.data){
        		alert("e.data:"+e.data);
        	}
        	if(!e.data){
        		alert("!e.data:"+!e.data);
        	}
        	if(!!e.data){
        		alert("!!e.data:"+!!e.data);
        	}
        	if(!!url){
        		window.location.href= url;
        	}
        };
        
        
    }catch(e){
        console.log(e.message);
    }

});