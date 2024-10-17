package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Recipe; // Recipeクラスのインポート

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes(); // 「1」が選ばれた場合にdisplayRecipesメソッドを呼び出し
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    // DataHandlerから読み込んだレシピデータを整形してコンソールに表示するメソッド
    private void displayRecipes() {
        try {
            ArrayList<Recipe> recipes = dataHandler.readData(); // DataHandlerからレシピデータを読み込む
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
            } else {
                System.out.println("Recipes:");
                for (Recipe recipe : recipes) {
                    System.out.println("-----------------------------------");
                    System.out.println("Recipe Name: " + recipe.getName());
                    System.out.println("Main Ingredients: " + recipe.getIngredients().stream()
                            .map(ingredient -> ingredient.getName())
                            .reduce((a, b) -> a + ", " + b).orElse(""));
                }
                System.out.println("-----------------------------------");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

