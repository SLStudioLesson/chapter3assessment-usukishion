package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    // デフォルトコンストラクタ
    public CSVDataHandler() {
        this.filePath = "C:\\Users\\user\\Desktop\\chapter3assessment-usukishion\\app\\src\\main\\resources";
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

    // レシピデータを読み込み、Recipeオブジェクトのリストとして返す（実装未）
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        
        // ファイルを読み込む
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue;

                String recipeName = parts[0].trim();
                String[] ingredientsData = parts[1].split(", ");
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (String ingredientName : ingredientsData) {
                    ingredients.add(new Ingredient(ingredientName.trim()));
                }

                recipes.add(new Recipe(recipeName, ingredients));
            }
        }
        return recipes;
        
    }

    // 指定されたRecipeオブジェクトを追加する（実装未）
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 実装は後の設問で行います
    }

    // 指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返す（実装未）
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        // 実装は後の設問で行います
        return null;
    }
}
