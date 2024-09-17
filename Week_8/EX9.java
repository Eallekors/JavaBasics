package Week_8;

import java.util.ArrayList;
import java.util.HashMap;

public class EX9 {
    public static void main(String[] args) {
        VehicleRegister register = new VehicleRegister();

        RegistrationPlate reg1 = new RegistrationPlate("FI", "ABC-123");
        RegistrationPlate reg2 = new RegistrationPlate("FI", "UXE-465");
        RegistrationPlate reg3 = new RegistrationPlate("D", "BWQ-431");
        RegistrationPlate reg4 = new RegistrationPlate("FI", "XYZ-789");


        register.add(reg1, "Arto");
        register.add(reg2, "Pekka");
        register.add(reg3, "Jürgen");
        register.add(reg4, "Arto"); // Arto owns multiple cars


        System.out.println("Registration plates:");
        register.printRegistrationPlates();


        System.out.println("\nCar owners:");
        register.printOwners();
    }
}
