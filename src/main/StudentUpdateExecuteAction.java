package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    // パラメータの取得
	    String no = request.getParameter("no");
	    String name = request.getParameter("name");
	    String classNum = request.getParameter("class_num");
	    String isAttendParam = request.getParameter("is_attend");
	    String schoolCd = request.getParameter("school_cd");

	    boolean isAttend = (isAttendParam != null);

	    // 学生オブジェクトの作成
	    School school = new School();
	    school.setCd(schoolCd);

	    Student student = new Student();
	    student.setNo(no);
	    student.setName(name);

	    ClassNum cn = new ClassNum();
	    cn.setClass_num(classNum);
	    student.setClassNum(cn);

	    student.setAttend(isAttend);
	    student.setSchool(school);  // ← student を生成した後にセット！

	    // 更新処理
	    StudentDao dao = new StudentDao();
	    dao.update(student);

	    request.setAttribute("message", "学生情報を更新しました。");

	    System.out.println("更新対象: no=" + student.getNo() +
                ", name=" + student.getName() +
                ", class=" + student.getClassNum().getClass_num() +
                ", attend=" + student.isAttend() +
                ", school=" + student.getSchool().getCd());

	    return "redirect:StudentList.action";
	}
}
