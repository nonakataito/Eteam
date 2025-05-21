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
            String path = request.getServletPath();

            // ② 拡張子 .action を取り除き、"Action" を末尾に追加
            //     "/main/LoginExecute.action" → "main/LoginExecuteAction"
            String className = path.substring(1, path.length() - ".action".length()) + "Action";

            // ③ パッケージ形式に変換（スラッシュ → ドット）
            //     "main/LoginExecuteAction" → "main.LoginExecuteAction"
            className = className.replace('/', '.');

            // ④ 動的にアクションクラスをロードしてインスタンス生成
            Action action = (Action) Class.forName(className)
                    .getDeclaredConstructor().newInstance();

            // ⑤ executeメソッドを実行 → 遷移先URLを取
            String url = action.execute(request, response);

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
