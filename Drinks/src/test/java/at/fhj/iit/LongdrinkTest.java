package at.fhj.iit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@DisplayName("Testing Longdrink implementation")
public class LongdrinkTest {
    private Liquid water, wine, aperol, orangeJuice;
    private Longdrink l1, l2, l3;
    private ArrayList<Liquid> ingredients = new ArrayList<>();

    /**
     * inits an alcoholic and nonalcoholic liquid for EACH test
     */
    @BeforeEach
    void setup() throws ZeroPercentAlcoholException {
        // SETUP PHASE
        water = new Liquid("Wasser", 0.3, 0);
        wine = new Liquid("Wein", 0.125, 13);
        aperol = new Liquid("Aperol", 0.2, 15);
        orangeJuice = new Liquid("Orange Juice", 0.3, 0);

        ingredients.add(water);
        ingredients.add(aperol);
        ingredients.add(wine);
        l1 = new Longdrink("Drink1", "Pineapple", false, ingredients);
        ingredients.clear();

        ingredients.add(orangeJuice);
        ingredients.add(water);
        ingredients.add(wine);
        l2 = new Longdrink("Drink2", "Orange", true, ingredients);
        ingredients.clear();

    }

    @Test()
    @DisplayName("Test ZeroPercentAlcoholException")
    public void testZeroPercentAlcoholException() throws ZeroPercentAlcoholException {
        ingredients.add(orangeJuice);
        ingredients.add(water);
        Assertions.assertThrows(ZeroPercentAlcoholException.class,
                () -> l3 = new Longdrink("Drink3", "Cherry", true, ingredients));
        ingredients.clear();
    }


    @Test
    @DisplayName("Testing constructor Drink 1")
    public void testConstructorDrinkOne(){
        ingredients.add(aperol);
        ingredients.add(water);
        ingredients.add(wine);
        assertEquals(l1.isCreamy(), false);
        assertEquals(l1.getVolume(), 0.625, 0.001);
        assertEquals(l1.getAlcoholPercent(), 9.333, 0.001);
        assertEquals(l1.getFruitTopping(), "Pineapple");
        assertEquals(l1.getIngredients(), ingredients);
        ingredients.clear();
    }

    @Test
    @DisplayName("Testing constructor Drink 2")
    public void testConstructorDrinkTwo(){
        ingredients.add(orangeJuice);
        ingredients.add(water);
        ingredients.add(wine);
        assertEquals(l2.isCreamy(), true);
        assertEquals(l2.getVolume(), 0.725, 0.001);
        assertEquals(l2.getAlcoholPercent(), 4.333, 0.001);
        assertEquals(l2.getFruitTopping(), "Orange");
        assertEquals(l2.getIngredients(), ingredients);
        ingredients.clear();
    }

    @Test
    @DisplayName("Test Creamy setter")
    public void testCreamySetter(){
        l1.setCreamy(true);
        assertEquals(l1.isCreamy(), true);
    }

    @Test
    @DisplayName("Test FruitTopping setter")
    public void testFruitToppingSetter(){
        l1.setFruitTopping("");
        assertEquals(l1.getFruitTopping(), "");
    }

    @Test
    @DisplayName("Test ingredients adder")
    public void testIngredientsAdder(){
        ingredients.add(aperol);
        ingredients.add(water);
        ingredients.add(wine);
        ingredients.add(water);
        l1.add(water);
        assertEquals(l1.getIngredients(), ingredients);
        ingredients.clear();
    }

    @Test
    @DisplayName("Test ingredients adder")
    public void testIngredientsSetter(){
        ingredients.add(aperol);
        ingredients.add(water);
        ingredients.add(wine);
        ingredients.add(water);
        l1.setIngredients(ingredients);
        assertEquals(l1.getIngredients(), ingredients);
        ingredients.clear();
    }
}
