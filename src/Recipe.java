import java.util.ArrayList;

public abstract class Recipe implements RecipeGenerator, RecipeAnalyzer, Comparable<Recipe>, Cloneable {
    private String name;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private Enums.Protein protein;
    private Enums.NutritionalStyle nutritionalStyle;
    private Enums.Cuisine cuisine;

    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    public void generateRecipe(String name, String description, Enums.Protein protein, Enums.NutritionalStyle nutritionalStyle, Enums.Cuisine cuisine) {
        this.name = name;
        this.description = description;
        this.protein = protein;
        this.nutritionalStyle = nutritionalStyle;
        this.cuisine = cuisine;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public String getFormattedRecipe() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recipe Name: ").append(this.name).append("\n");
        sb.append("Description: ").append(this.description).append("\n");
        sb.append("Ingredients:\n");
        for (Ingredient ingredient : ingredients) {
            sb.append("- ").append(ingredient.getName()).append(": ").append(ingredient.getQuantity()).append(" ").append(ingredient.getUnit()).append("\n");
        }
        return sb.toString();
    }

    public boolean isVegetarian() {
        return this.protein == Enums.Protein.VEGETARIAN;
    }

    // Implement the Comparable interface to compare recipes by name
    @Override
    public int compareTo(Recipe other) {
        return this.name.compareTo(other.name);
    }

    public boolean isSuitableForDiet() {
        return this.nutritionalStyle == Enums.NutritionalStyle.HEALTHY;
    }

    public Enums.Cuisine checkCuisine(){
        return this.cuisine = cuisine;
    }

    // Implement the Cloneable interface to allow cloning of Recipe objects
    @Override
    public Recipe clone() {
        try {
            Recipe cloned = (Recipe) super.clone();
            cloned.ingredients = new ArrayList<>(this.ingredients);  // Deep copy of ingredients
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
