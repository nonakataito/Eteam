package tool;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Account.LoginExecuteAction;
import Account.LogoutAction;
import Account.StudentListAction;

@WebServlet("/app")
public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        Action handler;

        switch (action) {
            case "login":
                handler = new LoginExecuteAction();
                break;
            case "logout":
                handler = new LogoutAction();
                break;
            case "student_list":
                handler = new StudentListAction();
                break;
            case "subject_add":
                handler = new SubjectAddAction();
                break;
            default:
                handler = new UnknownAction();
        }

        String nextPage = handler.execute(request, response);
        if (nextPage != null) {
            request.getRequestDispatcher(nextPage).forward(request, response);
        }
    }
}
