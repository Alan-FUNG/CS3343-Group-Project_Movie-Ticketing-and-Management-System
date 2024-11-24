package release.product;


import release.exception.ExProductNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Snack class that implements ProductWithPortion interface
 */
public class Snack implements ProductWithPortion {
    private final String name;
    private final double price;
    private String portion;
    private static final List<Snack> allSnacks = new ArrayList<>();

    /**
     * Constructor for Snack class, add the snack for the list of all snacks constructed
     *
     * @param name    name of the snack
     * @param price   price of the snack
     * @param portion portion of the snack
     */
    public Snack(String name, double price, String portion) {
        this.name = name;
        this.price = price;
        this.portion = portion;
        allSnacks.add(this);
    }

    /**
     * check if the snack is equal to another object
     *
     * @param object object to compare
     * @return true if the snack is equal to the object, false otherwise
     */

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Snack snack = (Snack) object;
        return Double.compare(price, snack.price) == 0 && Objects.equals(name, snack.name) && Objects.equals(portion,
                snack.portion);
    }


    /**
     * get the hash code of the snack
     *
     * @return the hash code of the snack
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price, portion);
    }

    /**
     * get all snacks
     *
     * @return list of all snacks
     */
    public static List<Snack> getAllSnacks() {
        return allSnacks;
    }

    /**
     * get the name of the snack
     *
     * @return the name of the snack
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * get the portion of the snack
     *
     * @return the portion of the snack
     */
    @Override
    public String getPortion() {
        return portion;
    }

    /**
     * set the portion of the snack, and return the portion set
     *
     * @param portion portion of the snack
     * @return the portion of the snack set
     */
    @Override
    public String setPortion(String portion) {
        this.portion = portion;
        return getPortion();
    }

    /**
     * get the price of the snack
     *
     * @return the price of the snack
     */
    @Override
    public double getPrice() {
        return price;
    }


    /**
     * search for a snack by name
     *
     * @param name name of the snack
     * @return the snack found
     * @throws ExProductNotFound if the snack is not found
     */
    public static Snack searchSnack(String name) throws ExProductNotFound {
        for (Snack snack : allSnacks) {
            if (snack.getName().equals(name)) {
                return snack;
            }
        }
        throw new ExProductNotFound(String.format("[Exception] Snack %s not found", name));
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Portion: " + portion + ", Price: " + price;
    }

    public String formattedToString() {
        // name portion price
        StringBuilder results = new StringBuilder(String.format("%-20s%2s", name, " "))
                .append(String.format("%-5s%2s", portion, " "))
                .append(String.format("$%-4.1f%1s", price, " "));
        return results.toString();
    }
}
