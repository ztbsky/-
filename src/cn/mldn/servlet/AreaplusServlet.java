package cn.mldn.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.service.IAreaplusService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Areaplus;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/areaplus")
public class AreaplusServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		IAreaplusService areaplusService = Factory.getServiceInstance("areaplus.service") ;
		try {
			int aid = Integer.parseInt(request.getParameter("aid")) ;
			List<Areaplus> all = areaplusService.listByArea(aid) ;
			
			
			JSONObject obj = new JSONObject() ;
			JSONArray array = new JSONArray() ;
			
			Iterator<Areaplus> iter = all.iterator() ;
			while (iter.hasNext()) {
				array.add(iter.next()) ;
			}
			obj.put("allplus", array) ;
			response.getWriter().println(obj);//request.setAttirbute(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
