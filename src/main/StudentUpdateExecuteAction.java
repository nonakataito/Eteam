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
        // セッションから学校情報を取得
        School school = (School) request.getSession().getAttribute("school");

        // リクエストパラメータ取得
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String classNumStr = request.getParameter("class_num");

        // バリデーション
        if (name == null || name.trim().isEmpty() || name.length() > 20) {
            request.setAttribute("error", "氏名は1〜20文字で入力してください。");
            return "/main/student_update.jsp"; // 入力画面に戻る
        }

        // Studentオブジェクトを作成
        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setSchool(school);

        ClassNum classNum = new ClassNum();
        classNum.setClass_num(classNumStr);
        student.setClassNum(classNum);

        // チェックされていない場合は null なので false 扱い
        boolean isAttend = request.getParameter("is_attend") != null;
        student.setAttend(isAttend);

        // 更新処理
        StudentDao dao = new StudentDao();
        boolean success = dao.update(student);

        if (success) {
            return "/main/student_update_done.jsp";
        } else {
            request.setAttribute("error", "学生情報の更新に失敗しました。");
            return "/main/error.jsp";
        }
    }
}
