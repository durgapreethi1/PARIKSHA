

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class MultipleFruitsServlet
 */
@WebServlet("/createtestservlet")
public class createtestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createtestservlet() {
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

		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA","root","svcdhoney1");
			Statement statement = con.createStatement();
					
			String sql1 = "insert into Questions(Q_no, Test_id, Subject_id, Question, option1, option2, option3, option4, Correct_option) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			String []checkedValues = request.getParameterValues("cname");
			String testName=request.getParameter("testName");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			String Date = request.getParameter("date");
			
			String sql3 = "select count(distinct Test_id) as Result from Tests";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql3);
			rs.next();
			int tid = rs.getInt("Result");
			tid++;
			int qid1 = 0;
			for(String a: checkedValues) {
				int qid = Integer.parseInt(a);
				String sql2 = "SELECT * FROM multipleTests where (Q_id = "+ qid +") && (subject_id = 1)";
				Statement stmnt = con.createStatement();
				ResultSet rrs = stmnt.executeQuery(sql2);
				
				
				String sid = (String) session.getAttribute("s1");
						
				
				while(rrs.next()) {
					qid1 = qid1+1;
					
					String Question1 = rrs.getString("Question");
					String op1 = rrs.getString("option1");
					String op2 = rrs.getString("option2");
					String op3 = rrs.getString("option3");
					String op4 = rrs.getString("option4");
					String soln = rrs.getString("correct_option");
					ps1.setInt(1, qid1);
					ps1.setInt(2,  tid);
					ps1.setInt(3, Integer.parseInt(sid));
					ps1.setString(4, Question1);
					ps1.setString(5, op1);
					ps1.setString(6, op2);
					ps1.setString(7, op3);
					ps1.setString(8, op4);
					ps1.setString(9, soln);
					ps1.executeUpdate();
									}
			}
			String sid1 = (String) session.getAttribute("s1");
			String sql4 = "insert into Tests(Subject_name,Test_name,Test_id,Test_date) values(?,?,?,?)";
			PreparedStatement ps2 = con.prepareStatement(sql4);
			String sql5 = "select Subject_name from Subjects where Subject_id = "+sid1+"";
			Statement stmnt1 = con.createStatement();
			ResultSet r = stmnt1.executeQuery(sql5);
			String Topic = request.getParameter("Topic");
			rs.getInt("Result");
			r.next();
			ps2.setString(1,r.getString("Subject_name"));
			ps2.setString(2,Topic);
			ps2.setInt(3,tid);
			ps2.setString(4,Date);
			ps2.executeUpdate();
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminTests.jsp");
			dispatcher.forward( request, response ) ;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}