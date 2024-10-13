package Product;

import java.util.Optional;

/**
 * Interface for all products
 */
public interface Product {
    /**
     * get the name of the product
     *
     * @return the name of the product
     */
    String getName();

    /**
     * get the portion of the product
     *
     * @return the portion of the product
     */
    String getPortion();

    /**
     * set the portion of the product, and return the portion set
     *
     * @param portion portion of the product
     * @return the portion of the product set
     */
    String setPortion(String portion);

    /**
     * get the price of the product
     *
     * @return the price of the product
     */
    double getPrice();

    /**
     * set the price of the product, and return the price set
     *
     * @param price price of the product
     * @return the price of the product set
     */
    double setPrice(double price);

    /**
     * compare the product with another object
     *
     * @param o object to compare
     * @return true if the product is equal to the object, false otherwise
     */
    boolean equals(Object o);

    /**
     * get the hash code of the product
     *
     * @return the hash code of the product
     */
    int hashCode();
}

