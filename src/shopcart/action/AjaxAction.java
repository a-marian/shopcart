package shopcart.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import shopcart.form.AjaxForm;

public class AjaxAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			    AjaxForm ajaxForm = (AjaxForm)form;
			    response.setContentType("text/text;charset=utf-8");
			    response.setHeader("cache-control", "no-cache");
			    PrintWriter out = response.getWriter();
			    out.println("Hello " + ajaxForm.getName());
			    out.flush();
			    return null;
			}

}
