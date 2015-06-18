package com.kchima;

public class Apple {

    final String colour;
    final int weight;
    
    public Apple(String colour, int weight) {
        this.colour = colour;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        result = 31 * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Apple)) {
            return false;
        }
        
        if (obj == this) {
            return true;
        }
        
        Apple other = (Apple) obj;
        return ((this.colour != null && this.colour.equals(other.colour) || this.colour == null && other.colour == null) && (this.weight == other.weight));
    }

    @Override
    public String toString() {
        return String.format("Apple(colour=%s, weight=%d)", colour, weight);
    }
}
