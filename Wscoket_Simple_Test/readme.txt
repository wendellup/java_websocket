1.tomcat使用7.0的最高版,确保tomcat的目录下包含websocket-api.jar


演示步骤:
	a.浏览器打开页面:http://127.0.0.1:8080/Wscoket_Simple_Test/static/html/page02.html 
	b.浏览器打开另外一个页面:http://127.0.0.1:8080/Wscoket_Simple_Test/setting?key=2
,第一个页面就会进行跳转


2014.6.30号版本解决了问题:
1.Software caused connection abort: socket write error。(服务器端发送给客户端一条跳转指令后即将socket关闭)。
2.服务器重启, 浏览器自动发送请求, 进行websocket重连。