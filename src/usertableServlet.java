

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
 * Servlet implementation class usertableServlet
 */
@WebServlet("/usertableServlet")
public class usertableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usertableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA", "root", "svcdhoney1");
			Statement statement = con.createStatement();
			//String sql = "select Q_no from User_Response";
			//ResultSet rs = statement.executeQuery(sql);
			
			Statement statement1= con.createStatement();
			Statement statement2= con.createStatement();
			
				String sql1 = "drop table User_Response";
				statement1.executeUpdate(sql1);
				String sql2 = "create table User_Response(Test_id int,Q_no int,Question varchar(100),Response varchar(7))";
				statement2.executeUpdate(sql2);
			

			con.close();
			RequestDispatcher rd = request.getRequestDispatcher("TableTests.jsp");
			rd.forward(request, response);

		

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
