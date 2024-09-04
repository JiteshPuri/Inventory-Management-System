import java.util.Scanner;

public class Main {
    private static MedicationDAO medicationDAO = new MedicationDAO();
    private static SupplierDAO supplierDAO = new SupplierDAO();
    private static InventoryDAO inventoryDAO = new InventoryDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Medication");
            System.out.println("2. View Medication");
            System.out.println("3. Add Supplier");
            System.out.println("4. View Supplier");
            System.out.println("5. Add Inventory");
            System.out.println("6. View Inventory");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMedication(scanner);
                    break;
                case 2:
                    viewMedications();
                    break;
                case 3:
                    addSupplier(scanner);
                    break;
                case 4:
                    viewSuppliers();
                    break;
                case 5:
                    addInventory(scanner);
                    break;
                case 6:
                    viewInventory();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addMedication(Scanner scanner) {
        System.out.println("Enter medication name: ");
        String name = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter quantity in stock: ");
        int quantityInStock = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Medication medication = new Medication(name, description, price, quantityInStock);
        try {
            medicationDAO.addMedication(medication);
            System.out.println("Medication added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding medication: " + e.getMessage());
        }
    }

    private static void viewMedications() {
        try {
            medicationDAO.getMedications().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error fetching medications: " + e.getMessage());
        }
    }

    private static void addSupplier(Scanner scanner) {
        System.out.println("Enter supplier name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        Supplier supplier = new Supplier(name, email, phoneNumber, address);
        try {
            supplierDAO.addSupplier(supplier);
            System.out.println("Supplier added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding supplier: " + e.getMessage());
        }
    }

    private static void viewSuppliers() {
        try {
            supplierDAO.getSuppliers().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error fetching suppliers: " + e.getMessage());
        }
    }

    private static void addInventory(Scanner scanner) {
        System.out.println("Enter medication ID: ");
        int medicationId = scanner.nextInt();
        System.out.println("Enter supplier ID: ");
        int supplierId = scanner.nextInt();
        System.out.println("Enter quantity received: ");
        int quantityReceived = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Inventory inventory = new Inventory(medicationId, supplierId, quantityReceived, new java.sql.Date(System.currentTimeMillis()));
        try {
            inventoryDAO.addInventory(inventory);
            System.out.println("Inventory added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding inventory: " + e.getMessage());
        }
    }

    private static void viewInventory() {
        try {
            inventoryDAO.getInventory().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error fetching inventory: " + e.getMessage());
        }
    }
    
}
