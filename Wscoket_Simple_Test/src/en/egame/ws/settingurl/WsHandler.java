package en.egame.ws.settingurl;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/ws/handler")
public class WsHandler {
	private Session session;

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		SessionContext.getSessions().add(session);
		System.out.println("session.getId():"+session.getId()
				+",SessionContext.getSessions().size():"
				+SessionContext.getSessions().size());
	}

	@OnMessage
	public void onMessage(String msg) {
		System.out.println(msg);
		System.out.println("session.getId():"+session.getId()
				+",SessionContext.getSessions().size():"
				+SessionContext.getSessions().size());
	}

	@OnClose
	public void onEnd() {
		if (this.session != null){
			SessionContext.getSessions().remove(this.session);
			System.out.println("session.getId():"+session.getId()
					+",SessionContext.getSessions().size():"
					+SessionContext.getSessions().size());
		}
	}
}