
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		HttpSession session = request.getSession();

		int Q_no1 = Integer.parseInt((String)session.getAttribute("Q_no"));
		
		String Question1 = (String) session.getAttribute("Question");
		String Response1 = request.getParameter("options");
		String subject = (String) session.getAttribute("subject3");
		int Test = Integer.parseInt(subject);

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA", "root", "svcdhoney1");
			Statement statement = con.createStatement();
			String sql = "select Q_no from User_Response";
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
			
				if (Q_no1 == rs.getInt("Q_no")) {
					
					String sql3 = "UPDATE User_Response SET Response = '" + Response1 + "',Test_id = '"+subject+"' WHERE Q_no = '" + Q_no1 + "'"; 
					PreparedStatement pstmt = con.prepareStatement(sql3);
					pstmt.executeUpdate();
					con.close();
					RequestDispatcher rd = request.getRequestDispatcher("Question.jsp");
					rd.forward(request, response);
					
					break;
				}
			}
			if(!rs.next()){
					
					String sql2 = "insert into User_Response(Test_id,Q_no,Question,Response) values(?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql2);
					pstmt.setInt(1, Test);
					pstmt.setInt(2, Q_no1);
					pstmt.setString(3, Question1);
					pstmt.setString(4, Response1);

					pstmt.executeUpdate();

			} 
			

			con.close();
			RequestDispatcher rd = request.getRequestDispatcher("Question.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void Syso(String string) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
