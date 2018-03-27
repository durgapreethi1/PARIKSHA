

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class PreviousQuestionServlet
 */
@WebServlet("/PreviousQuestionServlet")
public class PreviousQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviousQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//doGet(request, response);
		Connection con = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String subject = (String) session.getAttribute("subject3");
		
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Error: unable to load driver class!");

		}
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA", "root", "svcdhoney1");

			Statement statement = con.createStatement();
			
			
			int p = 0;
			
			
			
			if(session.getAttribute("Q_no")!=null)
			{
				p = Integer.parseInt((String) session.getAttribute("Q_no"));
				
				
				
			} else {
				//p = Integer.parseInt(request.getParameter("Q_no"));
				p = 0;
			}
			
			if(p < 0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
				dispatcher.forward( request, response ) ;
					
				
			} else {
			String sql = "SELECT Q_no,Question,option1,option2,option3,option4 FROM Questions where Q_no = "+(p-1)+" and Test_id = "+subject+"";
			
			
			ResultSet rs = statement.executeQuery(sql);
			
			
			
			if(rs.next()) {
				
				String Q_no1 = rs.getString("Q_no");
				String Question1 = rs.getString("Question");

				String op1 = rs.getString("option1");
				String op2 = rs.getString("option2");
				String op3 = rs.getString("option3");
				String op4 = rs.getString("option4");
				
				session.setAttribute("Q_no",Q_no1 );
				session.setAttribute("Question",Question1 );
				session.setAttribute("option1",op1 );
				session.setAttribute("option2",op2 );
				session.setAttribute("option3",op3 );
				session.setAttribute("option4",op4 );
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
			dispatcher.forward( request, response );
				
			}
			
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//doGet(request, response);
	}

	private char[] typeof(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
