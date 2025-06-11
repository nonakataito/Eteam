package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // セッションから学校情報を取得
        School school = (School) request.getSession().getAttribute("school");

        // フォームから送られてきたデータを取得
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");

        // バリデーション（必要に応じて）
        if (name == null || name.trim().isEmpty() || name.length() > 20) {
            request.setAttribute("error", "科目名は1〜20文字で入力してください。");
            return "subject_create.jsp";  // 入力画面へ戻る
        }

        // Subject オブジェクトを作成
        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setName(name);
        subject.setSchool(school);

        // DAO で更新処理
        SubjectDAO dao = new SubjectDAO();
        boolean success = dao.insert(subject);

        System.out.println("----- 登録デバッグ開始 -----");
        System.out.println("cd: " + cd);
        System.out.println("name: " + name);
        System.out.println("school: " + (school != null ? school.getCd() : "null"));

        if (success) {
            return "/main/subject_create_done.jsp"; // 完了画面へ
        } else {
            request.setAttribute("error", "データベース更新に失敗しました。");
            return "../error.jsp"; // エラー時は入力画面へ戻す
        }
    }
}
