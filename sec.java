import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class sec extends HttpServlet
{
	String driver,url;
	Connection c;
	Statement s;
	ResultSet rs;
	Cookie c1,c2;
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
		try
		{ 	Class.forName(driver);	}
		catch(ClassNotFoundException c)		
		{ 	pw.println("Driver Not Found");}
		try
		{
			String user = req.getParameter("user");
			String pass = req.getParameter("pass");
			String check = req.getParameter("c1");
			if(check!=null)
			{
			if(check.equals("y"))
			{
				c1=new Cookie("user",user);
				c2=new Cookie("pass",pass);
				c1.setMaxAge(30*60);
				c2.setMaxAge(30*60);
				res.addCookie(c1);
				res.addCookie(c2);
			}
			}
			c = DriverManager.getConnection(url);
			s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String query="SELECT * FROM  user WHERE username='"+user+"' AND password='"+pass+"'";
			rs=s.executeQuery(query);
			if(rs!=null)
			{
				rs.last();
			}
			else
			{
				rs.first();
			}
			if(rs.getRow()>0)
			{
				      pw.println("<br><br><center><font size=5 color=blue>You are a Valid User </font>");
				      pw.println("<html><body bgcolor=#99FF99><FORM METHOD=GET ACTION=home.html>");
				      pw.println("<br><br><INPUT TYPE=SUBMIT VALUE=Clicked-Here><BR> <BR>");
				      pw.println("<img border=0 src= file:///D:/kservlet/image/BD21313_.gif width=1000 height=30>");
				      pw.println("</center></form></body></html>"); 
			}
			else
			{
					pw.println("<br><br><center><font size=5 color =#800000 > You are not a Valid User!!!! Sign Up First </font>");
					pw.println("<br><html><body bgcolor=#66FF99><FORM METHOD=GET ACTION=index.html>");
					pw.println("<a href=index.html>");
					pw.print("<img border=0 src=file:///D:/kservlet/image/merlin.gif width=68 height=71>");
				                pw.println("<img border=0 src=file:///D:/kservlet/image/name-copy_04.gif width=81 height=33></a><br><br>");
				              	pw.println("<img border=0 src=file:///D:/kservlet/image/BD14710_.gif width=600 height=30>");
					pw.println("</center></form></body></html>"); 
				
			}
		}
		catch(SQLException e)
		{

				String tags="<HTML> <BODY>" +
				"<body background=pen.gif>" +
				"<font face=Trebuchet>" +
				"<p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"<img src=shop.GIF align=center width=103 height=85>" +
				"<font face=Impact color=RED size=16>&nbsp;&nbsp;&nbsp;&nbsp; Online Shopping Cart</font></font></p>" +
				"<CENTER>"+
				"<p color=Red>SQL Exception</p>"+e+
				"<BR> <HR WIDTH=400 color=RED>"+
				"<FORM METHOD=GET ACTION=project.html>" +
				"<INPUT TYPE=SUBMIT VALUE=Home> <BR> <BR>"+
			 	"<HR WIDTH=400 color=RED>" +
				"</CENTER></FORM></font></BODY></HTML>";
				pw.println(tags);
				
		}
	}
	public void destroy()
	{
		super.destroy();
		try
		{
			c.close();
		} catch(Exception e) {}
	}

}
