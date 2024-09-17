package Week_8;

import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<>();
    }

    // Add a registration plate and owner
    public boolean add(RegistrationPlate plate, String owner) {
        if (!owners.containsKey(plate)) {
            owners.put(plate, owner);
            return true; // New owner added
        }
        return false; // Plate already has an owner
    }

    // Get the owner of a registration plate
    public String get(RegistrationPlate plate) {
        return owners.get(plate); // Returns null if no owner is found
    }

    // Delete the registration plate and its associated owner
    public boolean delete(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            owners.remove(plate);
            return true; // Owner deleted
        }
        return false; // No owner was connected to the plate
    }

    // Print all registration plates stored
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }

    // Print all owners, ensuring each owner is printed only once
    public void printOwners() {
        HashSet<String> uniqueOwners = new HashSet<>(owners.values()); // To ensure uniqueness
        for (String owner : uniqueOwners) {
            System.out.println(owner);
        }
    }
}


