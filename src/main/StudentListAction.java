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
        String entYearStr = request.getParameter("f1");
        String classNum = request.getParameter("f2");
        String attendStr = request.getParameter("f3");

        School school = (School) request.getSession().getAttribute("school");

        if (school == null) {
            System.out.println("school がセッションにありません");
            return "/login.jsp";
        }

        System.out.println("school = " + school.getCd());

        StudentDao dao = new StudentDao();
        List<Student> studentList;

        boolean hasEntYear = entYearStr != null && !entYearStr.isEmpty();
        boolean hasClassNum = classNum != null && !classNum.isEmpty();
        boolean hasAttend = attendStr != null;

        boolean isAttend = "on".equals(attendStr);

        if (hasEntYear && hasClassNum) {
            int entYear = Integer.parseInt(entYearStr);
            studentList = dao.filter(school, entYear, classNum, isAttend);
        } else if (hasEntYear) {
            int entYear = Integer.parseInt(entYearStr);
            studentList = dao.filter(school, entYear, isAttend);
        } else if (hasAttend) {
            studentList = dao.filter(school, isAttend);
        } else {
            studentList = dao.findAll(school);
        }

        System.out.println("取得件数: " + studentList.size());

        request.setAttribute("studentList", studentList);
        return "/main/student_list.jsp";
    }
}
