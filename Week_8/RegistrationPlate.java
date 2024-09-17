package Week_8;

import java.util.Objects;

public class RegistrationPlate {
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }


    public String toString() {
        return country + " " + regCode;
    }

    // Override equals method to compare registration plates by regCode and country
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegistrationPlate that = (RegistrationPlate) obj;
        return Objects.equals(regCode, that.regCode) && Objects.equals(country, that.country);
    }

    // Override hashCode method to combine hashCodes of regCode and country
    @Override
    public int hashCode() {
        return Objects.hash(regCode, country);
    }
}

