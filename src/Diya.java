/**
 * Name and ID: Tanveer Reza
 * Assignment # 2
 * Due Date: 09/11/2024
 * The Diya enum represents different types of Diyas with their respective names, decorative values, and material costs.
 */
public enum Diya {
    STARRY_NIGHT("Starry Night Diyas", 8, 3.00),
    LOTUS_BLOSSOM("Lotus Blossom Diyas", 7, 2.50),
    OCEAN_WAVE("Ocean Wave Diyas", 9, 4.00),
    SUNSET_GLOW("Sunset Glow Diyas", 6, 2.00),
    MYSTIC_FOREST("Mystic Forest Diyas", 7, 3.50);

    private final String name;
    private final int decorativeValue;
    private final double materialCost;

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     * Constructs a Diya enum constant with the specified name, decorative value, and material cost.
     * @param name the name of the Diya
     * @param decorativeValue the decorative value of the Diya
     * @param materialCost the material cost of the Diya
     */
    Diya(String name, int decorativeValue, double materialCost) {
        this.name = name;
        this.decorativeValue = decorativeValue;
        this.materialCost = materialCost;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     * Gets the decorative value of the Diya.
     * @return the decorative value of the Diya
     */
    public int getDecorativeValue() {
        return decorativeValue;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     * Gets the material cost of the Diya.
     * @return the material cost of the Diya
     */
    public double getMaterialCost() {
        return materialCost;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     * Returns a string representation of the Diya.
     * @return a string representation of the Diya
     */
    @Override
    public String toString() {
        return "Diya{" +
                "name='" + name + '\'' +
                ", decorativeValue=" + decorativeValue +
                ", materialCost=" + materialCost +
                '}';
    }
}