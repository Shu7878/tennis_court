package tennisCourtServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tennisCourtServie.DeleteCourt;

/**
 * Servlet implementation class DeleteCourtServlet
 */
@WebServlet("/DeleteCourt")
public class DeleteCourtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String courtId = request.getParameter("courtId");
		String jsp;

		try{
			int id = Integer.parseInt(courtId);
			request.setAttribute("court_id", id);
			request.setAttribute("confirmMessage", "ID:" + id + "を削除しますか");
			jsp = "/delete.jsp";
		}catch(NumberFormatException e){
			request.setAttribute("errorMessage", "数値を入力してください");
			jsp = "/error.jsp";
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String jsp;

		try{
			//テニスコート情報削除
			DeleteCourt delete = new DeleteCourt();
			delete.execute(request);
			jsp = "/delete.jsp";
		}catch(NumberFormatException e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "削除するIDが不正です");
			jsp = "/error.jsp";
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "JDBCのエラーです");
			jsp = "/error.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "エラーが発生しました");
			jsp = "/error.jsp";
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}
