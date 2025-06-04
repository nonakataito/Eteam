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
	        return "/login.jsp";
	    }

	    boolean isAttend = "on".equals(attendStr);
	    StudentDao dao = new StudentDao();
	    List<Student> studentList;

	    boolean hasEntYear = entYearStr != null && !entYearStr.isEmpty();
	    boolean hasClassNum = classNum != null && !classNum.isEmpty();

	    if (hasEntYear && hasClassNum) {
	        int entYear = Integer.parseInt(entYearStr);
	        studentList = dao.filter(school, entYear, classNum, isAttend);
	    } else if (hasEntYear) {
	        int entYear = Integer.parseInt(entYearStr);
	        studentList = dao.filter(school, entYear, isAttend);
	    } else if (hasClassNum) {
	        studentList = dao.filter(school, classNum, isAttend); // ← 新しく追加したメソッド
	    } else {
	        studentList = dao.filter(school, isAttend);
	    }

	    request.setAttribute("studentList", studentList);
	    return "/main/student_list.jsp";
	}
}
