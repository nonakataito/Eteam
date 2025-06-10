package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // パラメータ取得
        String subjectCd = request.getParameter("subject_cd");
        String subjectName = request.getParameter("subject_name"); // ← 確認画面用。ここでは使っていないがOK

        // セッションからschoolを取得
        javax.servlet.http.HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");

        if (school == null) {
            // ログインしていない場合
            return "/login.jsp";
        }

        // 削除処理
        SubjectDAO dao = new SubjectDAO();
        boolean result = dao.delete(subjectCd, school.getCd());

        if (result) {
            // 削除成功 → 一覧画面へ遷移
            return "/main/subject_delete_done.jsp";
        } else {
            // 削除失敗 → エラーメッセージ付きでエラー画面へ
            request.setAttribute("error", "科目の削除に失敗しました。");
            return "/main/error.jsp";
        }
    }
}
