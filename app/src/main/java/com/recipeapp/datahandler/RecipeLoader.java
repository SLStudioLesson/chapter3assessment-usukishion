package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;


public class RecipeLoader {
    public static ArrayList<Recipe> loadRecipes(String filePath) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String recipeName = parts[0];
                    ArrayList<Ingredient> ingredients = new ArrayList<>();
                    for (int i = 1; i < parts.length; i++) {
                        ingredients.add(new Ingredient(parts[i].trim()));
                    }
                    recipes.add(new Recipe(recipeName, ingredients));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return recipes;
    }
}
