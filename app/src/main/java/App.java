import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            DataHandler dataHandler;

            // ユーザーの選択に基づいて適切なデータハンドラーをインスタンス化
            if ("2".equals(choice)) {
                dataHandler = new JSONDataHandler();
            } else {
                // 「1」と判断もしくは不正な入力の場合
                dataHandler = new CSVDataHandler();
            }

            // RecipeUIを生成してメニューを表示
            RecipeUI ui = new RecipeUI(dataHandler);
            ui.displayMenu();
            

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}