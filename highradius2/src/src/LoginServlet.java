package src;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import src.LoginBean;
import src.LoginDao;
 
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public LoginServlet() {
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
 
    LoginBean loginBean = new LoginBean();
 
    loginBean.setUserName(userName);
    loginBean.setPassword(password);
 
    LoginDao loginDao = new LoginDao();
 
    try
    {
        String userValidate = loginDao.authenticateUser(loginBean);
 
        if(userValidate.equals("Level 1_user_level"))
        {
            System.out.println("Admin's Home");
 
            HttpSession session = request.getSession(); 
            session.setAttribute("Level 1", userName); 
            request.setAttribute("userName", userName);
 
            request.getRequestDispatcher("/JSP/Level1.jsp").forward(request, response);
        }
        else if(userValidate.equals("Level 2_user_level"))
        {
            System.out.println("Editor's Home");
 
            HttpSession session = request.getSession();
            session.setAttribute("Level 2", userName);
            request.setAttribute("userName", userName);
 
            request.getRequestDispatcher("/JSP/Level2.jsp").forward(request, response);
        }
        else if(userValidate.equals("Level 3_user_level"))
        {
            System.out.println("User's Home");
 
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("Level 3", userName);
            request.setAttribute("userName", userName);
 
            request.getRequestDispatcher("/JSP/Level3.jsp").forward(request, response);
        }
        else
        {
            System.out.println("Error message = "+userValidate);
            request.setAttribute("errMessage", userValidate);
 
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    catch (IOException e1)
    {
        e1.printStackTrace();
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
} //End of doPost()
}

