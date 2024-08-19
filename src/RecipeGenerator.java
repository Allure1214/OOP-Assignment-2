public interface RecipeGenerator {
    void generateRecipe(String name, String description);
    String getFormattedRecipe();
    void addIngredient(Ingredient ingredient);
}