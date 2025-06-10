package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
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

        boolean isAttend = (isAttendParam != null);

        // 学生オブジェクトの作成
        Student student = new Student();
        student.setNo(no);
        student.setName(name);

        ClassNum cn = new ClassNum();
        cn.setClass_num(classNum);
        student.setClassNum(cn);

        student.setAttend(isAttend);

        // 更新処理
        StudentDao dao = new StudentDao();
        dao.update(student);

        // 完了メッセージなど必要ならここで設定
        request.setAttribute("message", "学生情報を更新しました。");

        // リダイレクトまたは転送先
        return "redirect:StudentList.action";
    }
}
