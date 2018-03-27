

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
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
		

		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Error: unable to load driver class!");

		}
		try {
			

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARIKSHA", "root", "svcdhoney1");

			Statement statement = con.createStatement();
			HttpSession session = request.getSession();
			
			String subjectname = request.getParameter("subjecttitle");
			String Name = request.getParameter("title");
			String Date = request.getParameter("date");
			
			
			String sql1 = "select * from Tests where Subject_name = ? and Test_name = ?";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(1, subjectname);
			ps.setString(2, Name);
			
			ResultSet rs = ps.executeQuery(); 
			rs.next();
			int n = rs.getInt("Test_id");
				
				String sql = "insert into Tests(Subject_name,Test_name,Test_id,Test_date) values(?,?,?,?)";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, subjectname);
				pstmt.setString(2, Name);
				//pstmt.setTime(2, null);
				pstmt.setInt(3, n);
				pstmt.setString(4,Date);

				pstmt.executeUpdate();
			
			con.close();
			RequestDispatcher rd = request.getRequestDispatcher("adminTests.jsp");
			rd.forward(request, response);
			
			
	}catch (SQLException e) {
		 e.printStackTrace();
	}

}
}
