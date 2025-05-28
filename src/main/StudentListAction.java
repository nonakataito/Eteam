package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentListAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // パラメータ取得
        String entYearStr = request.getParameter("f1");
        String classNum = request.getParameter("f2");
        String attendStr = request.getParameter("f3");

        // ログイン中の学校を取得（セッションに保持されている想定）
        School school = (School) request.getSession().getAttribute("school");

        // チェックボックス「在学中」→ true/false に変換
        boolean isAttend = "on".equals(attendStr);

        StudentDao dao = new StudentDao();
        List<Student> studentList;

        if (entYearStr != null && classNum != null && !entYearStr.isEmpty() && !classNum.isEmpty()) {
            int entYear = Integer.parseInt(entYearStr);
            studentList = dao.filter(school, entYear, classNum, isAttend);
        } else if (entYearStr != null && !entYearStr.isEmpty()) {
            int entYear = Integer.parseInt(entYearStr);
            studentList = dao.filter(school, entYear, isAttend);
        } else {
            studentList = dao.filter(school, isAttend);
        }

        request.setAttribute("studentList", studentList);
        return "/main/student_list.jsp";
    }
}
