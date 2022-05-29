package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	int id=Integer.parseInt(request.getParameter("sid"));
	Connection scon=Dbconnect.getConnection();
	try
	{
		Statement st=scon.createStatement();
		String sql="Select * from student where sid="+id;
		ResultSet rt=st.executeQuery(sql);
		if(rt.next())
		{
			out.println(rt.getString("sid"));
			out.println(rt.getString("sname"));
			out.println(rt.getString("spass"));
			out.println(rt.getString("sfees"));
		}
		else
		{
			out.println(rt.getString("id not exists"));
		}
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
