package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // パラメータ取得
        String cd = request.getParameter("code");

        // ログイン中の学校情報を取得（セッションから）
        School school = (School) request.getSession().getAttribute("school");

        // DAOで科目情報を取得
        SubjectDAO dao = new SubjectDAO();
        Subject subject = dao.findByCodeAndSchoolCd(cd, school.getCd());

        // リクエスト属性に設定してJSPへ渡す
        request.setAttribute("subject", subject);

        // 確認画面に遷移
        return "/main/subject_delete.jsp";
    }
}
