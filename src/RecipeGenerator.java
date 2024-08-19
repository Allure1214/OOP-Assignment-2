public interface RecipeGenerator {
    void generateRecipe(String name, String description, Enum protein, Enum nutritionalStyle, Enum cuisine);
    String getFormattedRecipe();
    void addIngredient(Ingredient ingredient);
}