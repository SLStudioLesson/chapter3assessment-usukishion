package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;

public class JSONDataHandler implements DataHandler {

    // 現在のモードを返す
    @Override
    public String getMode() {
        return "JSON";
    }

    // レシピデータを読み込み、Recipeオブジェクトのリストとして返す（実装未）
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        // 実装は行わないのでnullを返します
        return null;
    }

    // 指定されたRecipeオブジェクトを追加する（実装未）
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 実装は行わないので定義のみ
    }

    // 指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返す（実装未）
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        // 実装は行わないのでnullを返します
        return null;
    }
}
