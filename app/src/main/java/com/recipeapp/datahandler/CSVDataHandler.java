package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    // デフォルトコンストラクタ
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    // パラメータ付きコンストラクタ
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // 現在のモードを返す
    @Override
    public String getMode() {
        return "CSV";
    }

    //レシピデータを読み込み、Recipeオブジェクトのリストとして返す
    @Override
    public ArrayList<Recipe> readData() throws IOException { //readData メソッドをオーバーライド（再定義）
        ArrayList<Recipe> recipes = new ArrayList<>();//オブジェクトを格納するための ArrayList を作成。読み込んだレシピを保持するためのもの。
        
        // ファイルを読み込む
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            /*
             * BufferedReader: テキストファイルを効率的に読み込むためのクラス。
             * FileReader と組み合わせて使用することで、ファイルから行単位でデータを読み込むことができる。
             */
            String line;
            while ((line = br.readLine()) != null) {
            /*
             * 読み込んだ行を格納するための変数。
             * 読み込んだ行が null でない限り、ループが続く。
             */
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue;
                /*
                 * line.split(",", 2): 読み込んだ行をカンマで分割し、最大2つの部分に分ける。
                 * if (parts.length < 2) continue;: 分割された部分が2未満（レシピ名と材料がない場合）は、次の行へスキップ。
                 */
                String recipeName = parts[0].trim();
                /*
                 * parts[0].trim(): 最初の部分（レシピ名）から前後の空白を削除して、recipeName に格納。
                 */
                String[] ingredientsData = parts[1].split(", ");
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (String ingredientName : ingredientsData) {
                    ingredients.add(new Ingredient(ingredientName.trim()));
                    /*
                     * parts[1].split(", "): 2番目の部分（材料リスト）をカンマで分割。各材料が個別の要素として ingredientsData に格納。
                     * ArrayList<Ingredient> ingredients = new ArrayList<>();: Ingredient オブジェクトを格納するためのリストを作成。
                     * for (String ingredientName : ingredientsData): 分割された材料データをループで処理。
                     */
                }

                recipes.add(new Recipe(recipeName, ingredients));
                /*
                 * Recipe クラスのコンストラクタが呼び出されている。
                 * recipeName: 読み込んだレシピ名（String 型）を渡している。
                 * ingredients: 材料のリスト（ArrayList<Ingredient> 型）を渡している。
                 * Recipe クラスの新しいインスタンスが作成され、指定されたレシピ名と材料がそのオブジェクトに格納。
                 * recipes は ArrayList<Recipe> 型のリストで、読み込んだ全ての Recipe オブジェクトを格納。
                 * add(...) メソッドは、リストの末尾に新しい Recipe オブジェクトを追加。
                 */
            }
        }
        return recipes;
        
    }

    // 指定されたRecipeオブジェクトを追加する
    @Override
    public void writeData(Recipe recipe) throws IOException {
        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            // レシピ名と材料をカンマ区切りで書き込む
            writer.print(recipe.getName());
            for (Ingredient ingredient : recipe.getIngredients()) {
                writer.print("," + ingredient.getName());
            }
            writer.println();
        }
    }
    @Override
public ArrayList<Recipe> searchData(String keyword) throws IOException {
    
    return new ArrayList<>();
}
}


    // // 指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返す（実装未）
    // @Override
    // public ArrayList<Recipe> searchData(String keyword) throws IOException {
    //     // 実装は後の設問で行います
    //     return null;
    
