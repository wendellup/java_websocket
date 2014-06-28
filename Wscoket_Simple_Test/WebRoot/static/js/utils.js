//var base_url = "http://127.0.0.1:8080/api/v1/screen";
// var base_url = "../others";
var socket_url = "ws://127.0.0.1:8080/Wscoket_Simple_Test/ws/handler";

function toGetMinutes(str){
    var arr = str.split(":");
    return parseInt(arr[0],10)*60+parseInt(arr[1],10);
}
function toGetSeconds(str){
	var arr = str.split(":");
	return parseInt(arr[1],10)*60+parseInt(arr[2],10);
}

function formatNumber (num) {
    if(num != null){
    	return num.toString().replace(/[0-9]+?(?=(?:([0-9]{3}))+$)/g,function(a){return a+','});
    }
}
function getExtender(){
    var Extender = {
        extend: function() {
            arguments[0] = arguments[0] || {};
            for (var i = 1; i < arguments.length; i++)
            {
                for (var key in arguments[i])
                {
                    if (arguments[i].hasOwnProperty(key))
                    {
                        if (typeof(arguments[i][key]) === 'object') {
                            if (arguments[i][key] instanceof Array) {
                                arguments[0][key] = arguments[i][key];
                            } else {
                                arguments[0][key] = Extender.extend(arguments[0][key], arguments[i][key]);
                            }
                        } else {
                            arguments[0][key] = arguments[i][key];
                        }
                    }
                }
            }
            return arguments[0];
        }
    };
    window.Extender = Extender;
}
function connectWebSocket(){
    try{
        var ws = new WebSocket(socket_url);

        ws.onmessage = function (e) {
            if(!!window.worker){
                window.worker.terminate();
            };
            window.location.href= e.data;
        };
        ws.onerror = function (e) {
            console.log(e);
        }
    }catch(e){
        console.log(e.message);
    }
}