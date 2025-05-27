package main;

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

        // 学生情報を取得
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.get(no);

        // クラス一覧を取得
        ClassNumDAO classDao = new ClassNumDAO();
        List<ClassNum> classList = classDao.findAll();  // ← DAOによりメソッド名が異なるかもしれません

        // リクエストにセット
        request.setAttribute("student", student);
        request.setAttribute("classList", classList);

        // 表示先のJSPを返す
        return "/main/student_update.jsp"; // または /jsp/studentUpdate.jsp など、環境により調整
    }
}
