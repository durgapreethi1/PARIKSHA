
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScoreServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA", "root", "svcdhoney1");
			Statement statement = con.createStatement();
			Statement statement1 = con.createStatement();
			HttpSession session = request.getSession();
			String subject = (String) session.getAttribute("subject4");
			System.out.println(subject);
			int c = 0;
			
			
		
			String sql = "select Question,Q_no,Test_id,Response from User_Response";
			ResultSet rs = statement.executeQuery(sql);
			String sql1 = "select Question,Q_no,Test_id,Correct_option from Questions";
			ResultSet rs1 = statement1.executeQuery(sql1);
			
			while(rs.next()) {
				if(rs1.next()) {
					
				
					
				if((rs.getInt("Test_id") == rs1.getInt("Test_id")) && (rs.getInt("Q_no") == rs1.getInt("Q_no"))&& (rs.getString("Response").equals(rs1.getString("Correct_option")))) {
					System.out.println("SSS");
					c++;
					System.out.println(c);
					
				}
				}
			}
			request.setAttribute("result", c);
			
	
			
			
		
			RequestDispatcher rd = request.getRequestDispatcher("Score.jsp");
			rd.forward(request, response);
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
