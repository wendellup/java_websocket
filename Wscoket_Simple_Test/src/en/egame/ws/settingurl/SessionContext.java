package en.egame.ws.settingurl;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;


public class SessionContext {
	private static List<Session> sessions = new ArrayList();

	public static List<Session> getSessions() {
		return sessions;
	}

	public static void setSessions(List<Session> sessions) {
		sessions = sessions;
	}
}