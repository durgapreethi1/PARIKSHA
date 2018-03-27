

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertQuestionServlet
 */
@WebServlet("/InsertQuestionServlet")
public class InsertQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestionServlet() {
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
		String sid= (String) request.getParameter("sid");
		//String tid= request.getParameter("tid");
		Connection con = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Error: unable to load driver class!");

		}
		
		int tid = 1;
		String qid= (String)request.getParameter("Q_no");
		String Question = request.getParameter("question");
		String Option1 = request.getParameter("op1");
		String Option2 = request.getParameter("op2");
		String Option3 = request.getParameter("op3");
		String Option4 = request.getParameter("op4");
		String Solution = request.getParameter("Correct_option");

		
		try {
		String sql = "insert into Questions(subject_id,Test_id,Q_no,question, option1, option2, option3, option4, Correct_option) values(?,?,?,?,?,?,?,?,?)";
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA","root","svcdhoney1");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, qid);
		ps.setString(2,sid);
		ps.setInt(3, tid);
		ps.setString(4, Question);
		ps.setString(5, Option1);
		ps.setString(6, Option2);
		ps.setString(7, Option3);
		ps.setString(8, Option4);
		ps.setString(9,  Solution);
		ps.executeUpdate();
		//PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("JSTLSample.jsp");
		rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
		//doGet(request, response);



