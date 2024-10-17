// package com.recipeapp.ui;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Scanner;

// import com.recipeapp.datahandler.DataHandler;
// import com.recipeapp.model.Recipe; // Recipeクラスのインポート

// public class RecipeUI {
//     private BufferedReader reader;
//     private DataHandler dataHandler;

//     public RecipeUI(DataHandler dataHandler) {
//         reader = new BufferedReader(new InputStreamReader(System.in));
//         this.dataHandler = dataHandler;
//     }
    
//     public void displayMenu() {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Current mode: " + dataHandler.getMode());

//         while (true) {
//             try {
//                 System.out.println();
//                 System.out.println("Main Menu:");
//                 System.out.println("1: Display Recipes");
//                 System.out.println("2: Add New Recipe");
//                 System.out.println("3: Search Recipe");
//                 System.out.println("4: Exit Application");
//                 System.out.print("Please choose an option: ");

//                 String choice = reader.readLine();

//                 switch (choice) {
//                     case "1":
//                         displayRecipes(); // 「1」が選ばれた場合にdisplayRecipesメソッドを呼び出し
//                         break;
//                     case "2":
//                     addNewRecipe();
//                         break;
//                     case "3":
//                         break;
//                     case "4":
//                         System.out.println("Exiting the application.");
//                         return;
//                     default:
//                         System.out.println("Invalid choice. Please select again.");
//                         break;
//                 }
//             } catch (IOException e) {
//                 System.out.println("Error reading input from user: " + e.getMessage());
//             }
//         }
//     }

//     // DataHandlerから読み込んだレシピデータを整形してコンソールに表示するメソッド
//     private void displayRecipes() {
//         try {
//             ArrayList<Recipe> recipes = dataHandler.readData(); // DataHandlerからレシピデータを読み込む
//             if (recipes.isEmpty()) {
//                 System.out.println("No recipes available.");
//             } else {
//                 System.out.println("Recipes:");
//                 for (Recipe recipe : recipes) {
//                     System.out.println("-----------------------------------");
//                     System.out.println("Recipe Name: " + recipe.getName());
//                     System.out.println("Main Ingredients: " + recipe.getIngredients().stream()
//                             .map(ingredient -> ingredient.getName())
//                             .reduce((a, b) -> a + ", " + b).orElse(""));
//                 }
//                 System.out.println("-----------------------------------");
//             }
//         } catch (IOException e) {
//             System.err.println("Error reading file: " + e.getMessage());
//         }
//     }
// }

// private void addNewRecipe() {
//     Scanner scanner = new Scanner(System.in);
//     System.out.println("\nAdding a new recipe.");
//     System.out.print("Enter recipe name: ");
//     String recipeName = scanner.nextLine();
    
//     List<String> ingredients = new ArrayList<>();
//     System.out.println("Enter ingredients (type 'done' when finished):");
//     while (true) {
//         System.out.print("Ingredient: ");
//         String ingredient = scanner.nextLine();
//         if (ingredient.equalsIgnoreCase("done")) {
//             break;
//         }
//         ingredients.add(ingredient);
//     }

//     Recipe recipe = new Recipe(recipeName, ingredients);
//     try {
//         dataHandler.writeData(recipe);
//         System.out.println("Recipe added successfully.\n");
//     } catch (IOException e) {
//         System.out.println("Failed to add new recipe: " + e.getMessage());
//     }
// }

package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient; // Ingredientクラスのインポート
import com.recipeapp.model.Recipe; // Recipeクラスのインポート

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    //RecipeUI クラスのインスタンスを生成するためのメソッド。public 修飾子が付いているため、
    //他のクラスからこのクラスのインスタンスを作成することができる。
    //dataHandler: このコンストラクタは DataHandler 型の引数を受け取る。
    //DataHandler はレシピデータを読み書きするためのインターフェース
    
    public void displayMenu() {
        System.out.println("Current mode: " + dataHandler.getMode());
        /*
         * RecipeUI クラスのコンストラクタで設定された DataHandler 型のオブジェクト。
         * このオブジェクトは、データの読み書きを行うための実装。
         * getMode(): DataHandler インターフェースまたはその実装クラスに定義されているメソッド。
         * このメソッドは、現在のデータ処理モードを文字列として返す。
         */

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
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
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

//     // DataHandlerから読み込んだレシピデータを整形してコンソールに表示するメソッド
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

                /*
                 * private: このメソッドは RecipeUI クラスの内部からのみ呼び出せることを示す。
                 * void: このメソッドは値を返さない
                 * dataHandler オブジェクトを使用して、レシピデータを読み込み、ArrayList<Recipe> 型のリストに格納。
                 * readData() メソッドは、データハンドラーに実装された方法でレシピデータを取得。
                 * recipes リストが空であるかどうかを確認し、空であれば「レシピがありません」というメッセージを表示。
                 * else: リストが空でない場合は、「Recipes:」と表示し、各レシピをループで処理して表示。
                 * 各レシピの名前を表示するために、recipe.getName() メソッドを使用。
                 * recipe.getIngredients() メソッドを使用して、レシピに含まれる材料のリストを取得。
                 * stream(): 取得したリストをストリームに変換。各要素に対して操作を行うことがでる。
                 * map(ingredient -> ingredient.getName()): 各Ingredientオブジェクトから名前を取得するためのマッピングを行う。
                 * 材料名のストリームが生成される。
                 * reduce((a, b) -> a + ", " + b): 材料名をカンマで区切って結合。
                 * rElse(""): リストが空の場合に、空の文字列を返す。
                 */
                System.out.println("-----------------------------------");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


    // 新しいレシピを追加するメソッド
    private void addNewRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdding a new recipe.");
        System.out.print("Enter recipe name: ");
        String recipeName = scanner.nextLine();

        List<Ingredient> ingredients = new ArrayList<>();
        System.out.println("Enter ingredients (type 'done' when finished):");
        while (true) {
            System.out.print("Ingredient: ");
            String ingredientName = scanner.nextLine();
            if (ingredientName.equalsIgnoreCase("done")) {
                break;
            }
            ingredients.add(new Ingredient(ingredientName.trim()));
        }

        if (ingredients.isEmpty()) {
            System.out.println("No ingredients were added. Recipe not added.");
            return; // 空の場合はレシピを追加せず戻る
        }

        Recipe recipe = new Recipe(recipeName, new ArrayList<>(ingredients));
        try {
            dataHandler.writeData(recipe);
            System.out.println("Recipe added successfully.\n");
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}