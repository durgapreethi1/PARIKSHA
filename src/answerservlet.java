

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class answerservlet
 */
@WebServlet("/answerservlet")
public class answerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public answerservlet() {
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
		//doGet(request, response
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA","root","svcdhoney1");
			//Statement statement = con.createStatement();
			
			//String testName=request.getParameter("testName");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
		HttpSession session = request.getSession();
		String p = (String) session.getAttribute("T");
		String sql = "select count(Q_no) as num from Questions where Test_id = "+p+"";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		rs.next();
		String sql1 = "select Q_no,Correct_option from Questions where Test_id = "+p+"";
		Statement s1 = con.createStatement();
		ResultSet r = s1.executeQuery(sql1);
		String[] Answer = new String[rs.getInt("num")];
		r.next();
		int i,score = 0;
		for(i = 0;i < rs.getInt("num");i++ ){
			String Response1 = request.getParameter(Integer.toString(i+1));
			//out.println(i);
			if(Response1 == null) {
				Response1 = "0";
			}
			Answer[i] = Response1;
		//	out.println(Answer[i]);
			if((i+1) == r.getInt("Q_no") && Answer[i].equalsIgnoreCase(r.getString("Correct_option")) && Answer[i] != "0") {
				score++;
			}
			r.next();
			
		
		
		}
		request.setAttribute("result", score);
	//	out.println("score is " + score);
		
		RequestDispatcher rd = request.getRequestDispatcher("Score.jsp");
		rd.forward(request, response);
		con.close();
		
		
		
		
		
		} catch(SQLException e)	 {
			e.printStackTrace();
		}
 
 
	}

}
