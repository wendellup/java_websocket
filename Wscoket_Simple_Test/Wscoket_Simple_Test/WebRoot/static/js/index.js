$(function(){
    try{
        var ws = new WebSocket(socket_url);
        ws.onmessage = function (e) {

            window.location.href= e.data;
        };
        ws.onerror = function (e) {
            console.log(e);
        };
    }catch(e){
        console.log(e.message);
    }

});