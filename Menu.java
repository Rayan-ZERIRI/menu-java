import java.util.Scanner;

public class Menu {
    private final ActionsBDD actionsBDD;

    public Menu(ActionsBDD actionsBDD) {
        this.actionsBDD = actionsBDD;
    }

    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Afficher tous les programmeurs");
            System.out.println("2. Supprimer un programmeur");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            switch (choix) {
                case 1 -> actionsBDD.afficherProgrammeurs();
                case 2 -> {
                    System.out.print("Entrez l'ID à supprimer : ");
                    int id = scanner.nextInt();
                    actionsBDD.supprimerProgrammeur(id);
                }
                case 6 -> actionsBDD.terminerProgramme();
                default -> System.out.println("Choix invalide.");
            }
        }
    }
}
