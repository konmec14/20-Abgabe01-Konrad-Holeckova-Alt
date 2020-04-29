package at.fhj.iit;

import java.util.ArrayList;

/**
 * Class represents a longdrink which uses liquid as part of its ingredients as well as cream and has toppings
 */
public class Longdrink extends Drink{
    private ArrayList<Liquid> ingredients;
    private String fruitTopping;
    private boolean isCreamy = false;

    /**
     * Creates a Drink object with given name, fruitTopping, cream and ingredients
     *
     * @param name name of the drink
     * @param fruitTopping a fruit on top of the longdrink
     * @param isCreamy tells, if there is cream inside the longdrink
     */
    public Longdrink(String name, String fruitTopping, boolean isCreamy) {
        super(name);
        ingredients = new ArrayList<Liquid>();
        this.isCreamy = isCreamy;
        this.fruitTopping = fruitTopping;
    }

    /**
     * Gets the volume of the ingredients and adds them together and returns that
     *
     * @return
     */
    @Override
    public double getVolume() {
        return 0;
    }

    /**
     * Gets the mean of the alcohol percentages of the ingredients and returns that
     *
     * @return
     */
    @Override
    public double getAlcoholPercent() {
        return 0;
    }

    /**
     *  checks if the longdrink is alcoholic
     *
     * @return
     */
    @Override
    public boolean isAlcoholic() {
        return true;
    }
}
