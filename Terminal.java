import java.util.Scanner;

public class Terminal {
    private Scanner scanner;

    public Terminal() {
        System.out.println("Terminal init good!");

        this.scanner = new Scanner(System.in);
    }

    // Display the updated menu to the user
    public void displayMenu() {
        System.out.println("\n<<<<<< MENU >>>>>>");
        System.out.println("1. Afficher tous les programmeurs");
        System.out.println("2. Afficher un programmeur");
        System.out.println("3. Supprimer un programmeur");
        System.out.println("4. Ajouter un programmeur");
        System.out.println("5. Modifier le salaire");
        System.out.println("6. Quitter le programme");
        System.out.print("Quel est votre choix ? : ");
    }

    // Print messages to the user
    public void printMessage(String message) {
        System.out.println(message);
    }

    // Get the user's menu choice
    public int getMenuChoice() {
        return Integer.parseInt(scanner.nextLine()); // Read input as string and convert to int
    }

    // Get string input for a programmer's name or skill set
    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine(); // Read input as a string
    }

    // Get an integer input (e.g., for programmer ID or salary)
    public int getIntInput(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine()); // Convert input to an integer
    }
}
