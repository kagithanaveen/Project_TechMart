import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class newuser extends HttpServlet
{
	String driver, url;
	Connection c;
	PreparedStatement pt;
	public void init() throws ServletException
	{
		ServletContext context=getServletContext();
		driver=context.getInitParameter("driver");
		url=context.getInitParameter("url");
	}
	public void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		try
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			pw.println("Driver Not Found");
		}
		try
		{
			
			c = DriverManager.getConnection(url);
			pt = c.prepareStatement("insert into user values(?,?)");
			pt.setString(1,user);
			pt.setString(2,pass);
			pt.executeUpdate();
			pw.println("<html><body>");
			pw.println("<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			pw.println("<font color = Blue><b>User Name&nbsp;&nbsp;: "+user);
			pw.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			pw.println("Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+pass);
			pw.println("</font><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			pw.println("<font color = green>Your User Account Create Sucessfully</font>");
			pw.println("<a href= index.html>");
			pw.println("<img border =0 src=file:///D:/kservlet/image/back1.JPG width=130 height=40 align = middle></a>");
  

		}
		catch(Exception e)
		{
			pw.println("error"+e);
		}
	}
}