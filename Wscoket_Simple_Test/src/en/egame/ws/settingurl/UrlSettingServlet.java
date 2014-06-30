package en.egame.ws.settingurl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;


public class UrlSettingServlet extends HttpServlet {
	Map<String, String> data = new HashMap();

	public void init() throws ServletException {
		InputStream is = getClass().getResourceAsStream("/data.propertis");
		if (is != null) {
			Properties p = new Properties();
			try {
				p.load(is);
				Enumeration ks = p.keys();
				while (ks.hasMoreElements()) {
					String k = (String) ks.nextElement();
					this.data.put(k, (String) p.get(k));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String key = req.getParameter("key");
		String result = "FAIL";
		String url_result = "";
		if ((key != null) && (key.trim().length() > 0)) {
			url_result = (String) this.data.get(key);
			if ((url_result != null) && (url_result.trim().length() > 0)) {
				
				
				List<Session> sessions = SessionContext.getSessions();
				for (Session s : sessions) {
					try {
						s.getBasicRemote().sendText(url_result);
					} catch (IOException e) {
						e.printStackTrace();
					} finally{
						try {
							s.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
//					sessions.remove(s);
				}
//				result = "OK";
			}
		}

//		resp.setContentType("text/html");
//		resp.getWriter().print(
//				"{\"result\":\"" + result + "\",\"url\":\"" + url_result
//						+ "\"}");
	}
}