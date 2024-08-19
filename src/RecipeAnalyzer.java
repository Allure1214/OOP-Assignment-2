public interface RecipeAnalyzer {
    boolean isVegetarian();
    Enums.Cuisine checkCuisine();
    boolean isSuitableForDiet();
}