package shopcart.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import shopcart.dao.CalzadoDAO;

public class SearchEngineAction extends Action {

	 @Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("in action");
		 String callback = request.getParameter("callback");
		 String filter = request.getParameter("q");
         System.out.println("Data from ajax call " + callback);
         
		 response.setContentType("text/json");
		 StringBuffer calzadoNames = new StringBuffer();
		 CalzadoDAO autoCompleteDB = new CalzadoDAO();
		 List calzadosList = autoCompleteDB.selectData(filter);
//		 Iterator iterator = calzadosList.iterator();
//		 while(iterator.hasNext()){
//			 calzadoNames = calzadoNames.append(",").append((String)iterator.next());
//		 }
		 
//		 JSONObject json = new JSONObject();
//			json.accumulate(callback, calzadosList);
//		  
//		 PrintWriter pw = response.getWriter();
//		 pw.write( json.toString() );
//		 pw.flush();
//		 pw.close();
		 
		 String searchList = new Gson().toJson(calzadosList);
         response.getWriter().write( callback +"("+ searchList+ ");");
		 return null;
		
	}
}
