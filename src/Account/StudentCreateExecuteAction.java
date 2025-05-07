package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 入力されたパラメータを取得
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        int enterYear = Integer.parseInt(request.getParameter("enterYear"));
        String classNumStr = request.getParameter("classNum");
        boolean isAttend = Boolean.parseBoolean(request.getParameter("isAttend"));
        String schoolCd = request.getParameter("schoolCd");

        // 学生情報を構築
        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setEnterYear(enterYear);
        student.setAttend(isAttend);

        School school = new School();
        school.setCd(schoolCd);
        student.setSchool(school);

        ClassNum classNum = new ClassNum();
        classNum.setClass_num(classNumStr);
        student.setClassNum(classNum);

        // DAOを使って保存
        StudentDao dao = new StudentDao();
        boolean result = dao.save(student);

        // 結果に応じて画面遷移
        if (result) {
            response.sendRedirect("student_list.jsp");
        } else {
            request.setAttribute("error", "登録に失敗しました");
            request.getRequestDispatcher("student_create.jsp").forward(request, response);
        }
    }
}
