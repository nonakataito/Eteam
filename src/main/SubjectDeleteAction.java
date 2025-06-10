package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // セッションから学校情報を取得
        School school = (School) request.getSession().getAttribute("school");
        if (school == null) {
            return "/login.jsp";
        }

        // リクエストパラメータから科目コードを取得
        String subjectCd = request.getParameter("subject_cd");

        // DAOを使って該当の科目情報を取得
        SubjectDAO dao = new SubjectDAO();
        Subject subject = dao.findByCodeAndSchoolCd(subjectCd, school.getCd());

        // 該当の科目情報をリクエストに設定
        request.setAttribute("subject", subject);

        // 確認画面に遷移
        return "/main/subject_delete.jsp";
    }
}
