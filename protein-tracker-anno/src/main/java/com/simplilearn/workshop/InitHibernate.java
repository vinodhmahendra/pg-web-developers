package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.workshop.model.User;
import com.simplilearn.workshop.util.HibernateUtil;

@WebServlet("/init")
public class InitHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public InitHibernate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");

                SessionFactory factory = HibernateUtil.getSessionFactory();
                //retrieve a hibenate session       
                Session session = factory.openSession();
                out.println("Hibernate Session opened.<br>");
                out.println("Saving User Data..... .<br>");
                
                // begin new  transaction
                session.beginTransaction();
                
                User user = new User();
                user.setName("vinodh");
                user.setGoal(250);
                
                //execute database operation
                session.save(user);
                
                // commit transaction
                session.getTransaction().commit();
                out.println("User Data is Saved.<br>");
                
                
                
                session.beginTransaction();
                // retrieve the user
                User loadedUser = (User)session.get(User.class, 1);
                out.println("Name : " + loadedUser.getName() + "<br/>");
                out.println("Goal : " + loadedUser.getGoal() + "<br/>");
                
                //manipulate the loaded user
                loadedUser.setTotal(loadedUser.getTotal() + 50);
                
                session.getTransaction().commit(); // auto updating
                
                //Flush and Close Session
                session.close();
                out.println("Hibernate Session closed.<br>");
               
                
                out.println("</body></html>");
                   
                    
		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
