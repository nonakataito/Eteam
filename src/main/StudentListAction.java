package main;
//ava
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentListAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 仮で固定パラメータを使用
        School school = new School(); school.setCd("001");
        int year = 2021;
        String classNum = "A";
        boolean isAttend = true;

        StudentDao dao = new StudentDao();
        List<Student> list = dao.filter(school, year, classNum, isAttend);
        request.setAttribute("students", list);
        request.getRequestDispatcher("student_list.jsp").forward(request, response);
		return classNum;
    }
}
