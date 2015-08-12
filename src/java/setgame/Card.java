/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame;

/**
 *
 * @author jyothsna
 */
public class Card {
    private String identifier;
    private int number;
    private String color;
    private String shape;
    private String shade;
    
    public Card(String identifier, int number, String shape, 
            String color, String shade) {
        this.identifier = identifier;
        this.number = number;
        this.color = color;
        this.shape = shape;
        this.shade = shade;
    }
    
    @Override
    public String toString() {
        return "Card: " + "identifier[" + getIdentifier() + "] number[" + 
                getNumber() + "] color[" + getColor() + "] shape[" + getShape() + 
                "] shade[" + getShade();
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @return the shade
     */
    public String getShade() {
        return shade;
    }
}
