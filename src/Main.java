import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a list of recipes
        ArrayList<Recipe> recipeList = new ArrayList<>();

        // Create and add recipes to the list
        Recipe pastaPrimavera = new Recipe();
        pastaPrimavera.generateRecipe("Pasta Primavera", "A light and fresh vegetarian pasta.", Enums.Protein.VEGETARIAN, Enums.NutritionalStyle.HEALTHY, Enums.Cuisine.PERSIAN);
        pastaPrimavera.addIngredient(new Ingredient("Pasta", 200, "grams"));
        pastaPrimavera.addIngredient(new Ingredient("Broccoli", 100, "grams"));
        pastaPrimavera.addIngredient(new Ingredient("Garlic", 2, "cloves"));

        Recipe chickenSalad = new Recipe();
        chickenSalad.generateRecipe("Chicken Salad", "A healthy chicken salad with mixed greens.", Enums.Protein.CHICKEN, Enums.NutritionalStyle.HEALTHY, Enums.Cuisine.AMERICAN);
        chickenSalad.addIngredient(new Ingredient("Chicken Breast", 150, "grams"));
        chickenSalad.addIngredient(new Ingredient("Lettuce", 100, "grams"));
        chickenSalad.addIngredient(new Ingredient("Tomato", 50, "grams"));

        Recipe beefStirFry = new Recipe();
        beefStirFry.generateRecipe("Beef Stir-Fry", "A delicious low-carb beef stir-fry.", Enums.Protein.BEEF, Enums.NutritionalStyle.HIGH_FAT, Enums.Cuisine.CHINESE);
        beefStirFry.addIngredient(new Ingredient("Beef", 200, "grams"));
        beefStirFry.addIngredient(new Ingredient("Broccoli", 150, "grams"));
        beefStirFry.addIngredient(new Ingredient("Soy Sauce", 50, "ml"));

        Recipe grilledSalmon = new Recipe();
        grilledSalmon.generateRecipe("Grilled Salmon", "A hearty and healthy grilled salmon.", Enums.Protein.FISH, Enums.NutritionalStyle.HIGH_FAT, Enums.Cuisine.MEDITERRANEAN);
        grilledSalmon.addIngredient(new Ingredient("Salmon", 200, "grams"));
        grilledSalmon.addIngredient(new Ingredient("Olive Oil", 1, "tbsp"));
        grilledSalmon.addIngredient(new Ingredient("Lemon", 1, "slice"));

        Recipe turkeyChili = new Recipe();
        turkeyChili.generateRecipe("Turkey Chili", "A spicy turkey chili.", Enums.Protein.TURKEY, Enums.NutritionalStyle.HIGH_FAT, Enums.Cuisine.MEXICAN);
        turkeyChili.addIngredient(new Ingredient("Ground Turkey", 250, "grams"));
        turkeyChili.addIngredient(new Ingredient("Chili Powder", 1, "tbsp"));
        turkeyChili.addIngredient(new Ingredient("Tomato", 100, "grams"));

        Recipe veggieStirFry = new Recipe();
        veggieStirFry.generateRecipe("Veggie Stir-Fry", "A quick and healthy vegetarian stir-fry.", Enums.Protein.VEGETARIAN, Enums.NutritionalStyle.HEALTHY, Enums.Cuisine.ASIAN);
        veggieStirFry.addIngredient(new Ingredient("Tofu", 150, "grams"));
        veggieStirFry.addIngredient(new Ingredient("Bell Pepper", 100, "grams"));
        veggieStirFry.addIngredient(new Ingredient("Soy Sauce", 30, "ml"));

        Recipe porkTacos = new Recipe();
        porkTacos.generateRecipe("Pork Tacos", "Tasty pork tacos with a Mexican twist.", Enums.Protein.PORK, Enums.NutritionalStyle.HIGH_FAT, Enums.Cuisine.MEXICAN);
        porkTacos.addIngredient(new Ingredient("Pork", 200, "grams"));
        porkTacos.addIngredient(new Ingredient("Taco Shells", 3, "pieces"));
        porkTacos.addIngredient(new Ingredient("Avocado", 50, "grams"));

        recipeList.add(pastaPrimavera);
        recipeList.add(chickenSalad);
        recipeList.add(beefStirFry);
        recipeList.add(grilledSalmon);
        recipeList.add(turkeyChili);
        recipeList.add(veggieStirFry);
        recipeList.add(porkTacos);


        // Sort recipes by name using Comparable
        Collections.sort(recipeList);
        System.out.println("Recipes sorted by name:");
        for (int i = 0; i < recipeList.size(); i++) {
            System.out.println((i + 1) + ". " + recipeList.get(i).getFormattedRecipe().split("\n")[0]);
        }

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to select a recipe
        System.out.print("\nEnter the number of the recipe you want to view: ");
        int choice = scanner.nextInt();

        // Validate choice
        if (choice < 1 || choice > recipeList.size()) {
            System.out.println("Invalid choice. Please try again.");
        } else {
            // Display the selected recipe
            Recipe selectedRecipe = recipeList.get(choice - 1);
            System.out.println("\nYou selected:");
            System.out.println("--------------------------------------------");
            System.out.println(selectedRecipe.getFormattedRecipe());

            // Check if the recipe is vegetarian
            System.out.println("Is vegetarian: " + selectedRecipe.isVegetarian());
            System.out.println("Is suitable for diet: " + selectedRecipe.isSuitableForDiet());
            System.out.println("The cuisine is from: " + selectedRecipe.checkCuisine());
            System.out.println("--------------------------------------------");

            // Demonstrate cloning the selected recipe
            Recipe clonedRecipe = selectedRecipe.clone();
            System.out.println("\nCloned Recipe:");
            System.out.println("--------------------------------------------");
            System.out.println(clonedRecipe.getFormattedRecipe());

            System.out.println("--------------------------------------------");
        }

        // Close the scanner
        scanner.close();
    }
}
