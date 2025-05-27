package mainmenu;
//a
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/mainmenu/A"})
public class A extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		// UTF-8 を設定
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
//        k
        
        
        
        
       
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/kaihatsu");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
			"select * from student");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("NO"));
				out.println("：");
				out.println(rs.getString("NAME"));
				out.println("：");
				out.println(rs.getInt("ENT_YEAR"));
				out.println("<br>");
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
