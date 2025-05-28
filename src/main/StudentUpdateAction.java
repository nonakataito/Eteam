package main;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDao;
import tool.Action;


public class StudentUpdateAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 学生番号を取得
        String no = request.getParameter("no");
        System.out.println("受け取った学生番号: " + no); // ← ここ！

        // 学生情報を取得
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.get(no);
        System.out.println("取得した学生情報: " + student); // ← ここ！

        // クラス一覧を取得
        ClassNumDAO classDao = new ClassNumDAO();
        List<ClassNum> classList = classDao.findAll();

        // リクエストにセット
        request.setAttribute("student", student);
        request.setAttribute("classList", classList);

        List<Student> students = new ArrayList<>();
        if (student != null) {
            students.add(student);
        }
        request.setAttribute("students", students);

        // 表示先のJSPを返す
        return "/main/student_update.jsp";
    }
}
