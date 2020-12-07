import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class existinguser extends HttpServlet
{
	
	public void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException , IOException
	{
		String n;
		String v[] = new String[2];
		v[0] = "";
		v[1] = "";
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie c[]=req.getCookies();
		if(c!=null)
		{
			for( int i = 0;i<c.length;i++)
			{
				n=c[i].getName();
				if(n.equals("user") )
					v[0]=c[i].getValue();				
				if(n.equals("pass") )
					v[1]=c[i].getValue();				
					
			}
		}
		pw.println("<html><body>");

		pw.println("<table border=0 width=103% height=20% id=table1>");
		pw.println("<tr><td rowspan=2 bgcolor=#FF9900><img src=../../Documents%20and%20Settings/sugi/My%20Documents/My%20Web%20Sites/celebration.jpg width=275 height=87></td>");
		pw.println("<td bgcolor=#FF9900><p align=center style=margin-top: 5><font face=gr><b><font style=font-size: 25pt color=#990099>TechMart India</font></b></font></td>");
		pw.println("<td rowspan=2 bgcolor=#FF9900><img border=0 src=../../Documents%20and%20Settings/sugi/My%20Documents/My%20Web%20Sites/gift-box.gif width=161 height=82><p style=line-height: 150%; margin-top: 0; margin-bottom: 0 align=right>");
		pw.println("<font size=2>Existing User?</font><span style=font-size: 9pt> </span>");
		pw.println("<span style=font-size: 11pt; font-weight: 700><a title=Click to sign in href=existinguser.html>Sign-In</a>&nbsp;&nbsp; </span></p><p style=line-height: 150%; margin-top: 0; margin-bottom: 5 align=right>");
		pw.println("<font size=2>New User?</font><span style=font-size: 9pt; font-style: italic></span><span style=font-size: 11pt; font-weight: 700>");
		pw.println("<a title='Click to create new account' href=newuser.html>Sign-Up</a>&nbsp;&nbsp; </span></td></tr><tr><td bgcolor=#FF9900>");
		pw.println("<p style=margin-bottom: -3px align=left><font face=Garamond><span style=font-size: 11pt; font-weight: 700>");
		pw.println("<font color=#0000FF>Product Search</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;);
		pw.println("<font color=#0000FF>&nbsp; <a href=index.html>Home&nbsp;<img border=0 src=images/cart.gif width=23 height=15></a></font></span></font></p><p><input type=text name=search size=27>");
		pw.println("<input border=0 src=../../Documents%20and%20Settings/sugi/My%20Documents/My%20Web%20Sites/go.gif name=I4 align=absbottom width=25 height=23 type=image></td>");
		pw.println("</tr></table><table border=0 width=101% height=80% id=table2 style=border-right-width: 0px; border-top-width: 0px>");
		pw.println("<tr width = 100% height = 30%><td align=center width=21%><table border=0 cellspacing=1height = 100% style=border-collapse: collapse bordercolor=#111111 width = 100% id=table3 bgcolor=#FF9933 align=left>");
		pw.println("<tr><td colspan=2  bgcolor=#FF9933 align=center><p style=margin-top: 0; margin-bottom: 0><font color=#66FF99><span style=font-size: 11pt; font-weight: 700>Shopping Status</span></font></td>");
		pw.println("</tr><tr><td align=center width=56%><font color=#66FF99><span style=font-size: 10pt; font-weight: 700>Total Items</span></font></td><td align=center width=31%><font color=#66FF99><b>(&nbsp;)</b></font></td>");
		pw.println("</tr><tr><td height=22 align=center width=56% ><font color=#66FF99><span style=font-size: 10pt; font-weight: 700>Total Price</span></font></td>");
		pw.println("<td height=22 align=center width=31% ><font color=#66FF99><b>(&nbsp;)</b></font></td></tr><tr><td align=center width=56% >&nbsp;</td>");
		pw.println("<td align=center width=31% >&nbsp;</td></tr><tr><td  colspan=2 align=center><p align=center><img border=0 src=../../Documents%20and%20Settings/sugi/My%20Documents/My%20Web%20Sites/Bill.GIF width=48 height=22></td>");
		pw.println("</tr></table></td>");
		//middle cell

		pw.println("<td align=right rowspan=3 valign=top background=images/Moon%20flower.jpg><form method=POST action=sec>");
		pw.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>");						
		pw.println("<p align=left><b><font color=#FF0000>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Name</font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("<input type=text name=username size=20 value = " + v[0] +"></p>");
		pw.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=#FF0000><b>&nbsp;Password</b></font>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("<input type=text name=password size=20 value = " + v[0] +"><br><input type=checkbox name=c1 value=y >Remember My User Name and Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("<input type=submit value=Login name=B1></p></form><p>&nbsp;</td></tr><tr width = 30%><td width=21%><img border=0 src=images/buyelectronic.GIF width=160 height=133></td></tr>");

		//close middle cell
		pw.println("<tr width = 40%><td width=21% align=center>");
		pw.println("<table border=1 cellspacing=1 style=border-collapse: collapse bordercolor=#FF9933 width=151 id=table4 height=132><tr><td width=145 bgcolor=#FF9933 height=21><p align=center><b><font size=4 face=Garamond color=#FFFFFF>");
		pw.println("What we accept?</font></b></td></tr><tr><td height=107 ><p align=center>&nbsp;<img border=0 src=../../Documents%20and%20Settings/sugi/My%20Documents/My%20Web%20Sites/visa.gif width=75 height=75> </td></tr></table></td></tr></table>");
		
		//pw.println("<b><font face=Monotype Corsiva size=5 color=red>MY SHOPPING CARD</font></b><br><br>");
		//pw.println("<form method=post action = sec>");
		//pw.println("<table width = 60% aligh = Center cellpadding = 2 cellspacing = 12>");
		//pw.println("<tr><td align=left><font color = green > <b>User Name</td><td align=left> <input type = text name = user value = " + v[0] +"></td></tr>");
		//pw.println("<tr><td align=left> <font color = green ><b>Password  </td><td align=left> <input type = password name = pass value = " + v[1] +"></td></tr>");
		//pw.println("<tr><td></td><td><font color = blue ><b><input type=checkbox name=c1 value=y >Remember My User Name and Password</td></tr>");
		//pw.println("<tr><td align=center> <input type = Submit value = Submit></td></tr></table>");
	
		pw.println("</form></body></html>");
	}
}