package en.egame.ws.settingurl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.websocket.Session;


public class SessionContext {
//	private static List<Session> sessions = new CopyOnWriteArrayList<Session>();\
	private static List<Session> sessions = new CopyOnWriteArrayList<Session>();

	public static List<Session> getSessions() {
		return sessions;
	}

	public static void main(String[] args) {
		
		List<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(1);
		list.add(2);
		for(Integer id : list){
			System.out.println(id);
			list.add(id*10);
		}
		
		System.out.println(list);
		
	
	}
	
//	public static void setSessions(List<Session> sessions) {
//		this.sessions = sessions;
//	}
}