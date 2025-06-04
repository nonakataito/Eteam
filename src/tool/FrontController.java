package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * フロントコントローラ (Front Controller)
 * すべてのリクエストを一元管理し、適切なアクションクラスを実行する
 */
@WebServlet(urlPatterns = {"*.action"}) // .action で終わるすべてのリクエストを処理
public class FrontController extends HttpServlet {

    /**
     * POSTリクエストの処理
     * - リクエストされたURLからアクション名を導出し、対応するクラスを実行
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("FrontController POST 処理開始");

        // エラー出力用
        PrintWriter out = response.getWriter();

        try {
            // ① パス取得: 例 → "/main/LoginExecute.action"
            String path = request.getServletPath().substring(1, request.getServletPath().length() - ".action".length());


         // スラッシュの位置でパッケージとクラス名を分割
	         int slash = path.lastIndexOf('/');
	         String packageName = path.substring(0, slash); // "main"
	         String classBase = path.substring(slash + 1);  // "studentCreateExecute"

	         // クラス名の先頭を大文字に変換 → "StudentCreateExecute"
	         String className = packageName + "." + classBase.substring(0, 1).toUpperCase() + classBase.substring(1) + "Action";

	         // → "main.StudentCreateExecuteAction"

            // ② 拡張子 .action を取り除き、"Action" を末尾に追加
            //     "/main/LoginExecute.action" → "main/LoginExecuteAction"            String className = path.substring(1, path.length() - ".action".length()) + "Action";


            // ④ 動的にアクションクラスをロードしてインスタンス生成
            Action action = (Action) Class.forName(className)
                    .getDeclaredConstructor().newInstance();

            // ⑤ executeメソッドを実行 → 遷移先URLを取得
            String url = action.execute(request, response);

            if (url.startsWith("redirect:")) {
                response.sendRedirect(url.substring("redirect:".length()));
            } else {
                request.getRequestDispatcher(url).forward(request, response);
            }


            // ⑥ フォワード
            request.getRequestDispatcher(url).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace(out); // スタックトレース出力（開発中のみ表示推奨）
        }
    }


    /**
     * GETリクエストの処理
     * - POSTと同様の処理を実行
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
