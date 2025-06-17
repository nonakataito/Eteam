package main;

//java
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 入力されたパラメータを取得
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        int entYear = Integer.parseInt(request.getParameter("ent_year"));
        String classNumStr = request.getParameter("class_num");
        boolean isAttend = Boolean.parseBoolean(request.getParameter("isAttend"));
        String schoolCd = request.getParameter("schoolCd");

        // 学生情報を構築
        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setEntYear(entYear);
        student.setAttend(true);

        School school = (School) request.getSession().getAttribute("school");
        if (school == null) {
            return "/login.jsp"; // セッション切れ対応
        }
        student.setSchool(school);


        ClassNum classNum = new ClassNum();
        classNum.setClass_num(classNumStr);
        student.setClassNum(classNum);

        // DAOを使って保存
        StudentDao dao = new StudentDao();
        boolean result = dao.save(student);

        // 結果に応じて画面遷移
     // 結果に応じて画面遷移
        if (result) {
            return "redirect:StudentList.action"; // ← 統一
        } else {
            request.setAttribute("error", "登録に失敗しました");
            return "../error.jsp"; // ← これは JSP なのでそのままでOK
        }

    }
}
