package controller_servlet;

import java.io.IOException;
import java.sql.Types;
import java.util.ArrayList;

// servlet core
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SqlQuery;

/**
 * Servlet implementation class Middleware
 */
@WebServlet("/Middleware")
public class Middleware extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    @Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	
//    	//驗證使用者身份
//    	if(SqlQuery.userAuthentication(request, response)) {    		
//    		//重新導向「首頁」
//    		response.sendRedirect(request.getContextPath() + "/index.jsp"); //亦可使用相對本頁面的路徑(即"index.jsp")
//    	}
//    	else
//    		//重新導向「登入表單」
//    		response.sendRedirect(request.getContextPath() + "/_login-form.jsp");//亦可使用相對本頁面的路徑(即"_login-form.jsp")
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// store order data to sql server
		req.setCharacterEncoding("UTF-8");
		// 若form name 為"orderForm"，則到sql撈完資料後將結果傳送到"/showOrdered.jsp"顯示
		if ("orderForm".equals(req.getParameter("FormName"))) {
			int count = 0;
			for (int i = 1; i <= 9; i++) {
				if ( "0".equals((String) req.getParameter("item_" + i)) ) {
					count++;
				}
			}
			if (count != 9) {
				ArrayList<ArrayList<String>> storedData = SqlQuery.storeOrderdataToSql(req);
				req.setAttribute("ordered", storedData);
				req.getRequestDispatcher("/showOrdered.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			}
		} else if ("showDataByIdForm".equals(req.getParameter("FormName"))) {
			int inputID = Types.INTEGER;
			String email = null;
			if (!("".equals(req.getParameter("queryId")))) {
				inputID = Integer.valueOf(req.getParameter("queryId"));
			}
			if (!("".equals(req.getParameter("email")))) {
				email = (String) req.getParameter("email");
			}
			ArrayList<ArrayList<String>> queryData = SqlQuery.queryOrderdataById(req, inputID, email);
			req.setAttribute("queryData", queryData);
			req.getRequestDispatcher("/showQueryById.jsp").forward(req, resp);
		} else if ("updateForm".equals(req.getParameter("FormName"))) {
			int inputID = Types.INTEGER;
			String email = null;
			if (!("".equals(req.getParameter("queryId")))) {
				inputID = Integer.valueOf(req.getParameter("queryId"));
			}
			if (!("".equals(req.getParameter("email")))) {
				email = (String) req.getParameter("email");
			}
			ArrayList<ArrayList<String>> queryData = SqlQuery.updateOrderdataById(req, inputID, email);
			req.setAttribute("queryData", queryData);
			req.getRequestDispatcher("/showQueryById.jsp").forward(req, resp);
		} else if ("deleteForm".equals(req.getParameter("FormName"))) {
			int inputID = Types.INTEGER;
			String email = null;
			if (!("".equals(req.getParameter("queryId")))) {
				inputID = Integer.valueOf(req.getParameter("queryId"));
			}
			if (!("".equals(req.getParameter("email")))) {
				email = (String) req.getParameter("email");
			}
			ArrayList<ArrayList<String>> queryData = SqlQuery.deleteOrderdataById(req, inputID, email);
			req.setAttribute("queryData", queryData);
			req.getRequestDispatcher("/showQueryById.jsp").forward(req, resp);
		}

	}

}
