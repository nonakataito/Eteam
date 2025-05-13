package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Account.LogoutAction;
import Account.StudentListAction;

@WebServlet("/app")
public class FrontController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");  // 例: login, logout, student_list

        Action handler = null;

        switch (action) {
            case "login":
                handler = new LoginAction();
                break;
                /*もし「action=login」なら、LoginAction というクラスの処理を使うという意味です。
                他の処理も case を追加していけばOKです。*/
            case "logout":
                handler = new LogoutAction();
                break;
            case "student_list":
                handler = new StudentListAction();
                break;
            case "subject_add":
                handler = new SubjectAddAction();
                break;
            // 他のアクションもここに追加
            default:
                handler = new UnknownAction();
        }

        if (handler != null) {
            String nextPage = handler.execute(request, response);
            if (nextPage != null) {
                request.getRequestDispatcher(nextPage).forward(request, response);
            }
        }
    }
}
