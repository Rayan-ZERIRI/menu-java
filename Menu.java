import java.util.Scanner;
import java.util.List;

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
            System.out.println("2. Afficher un programmeur");
            System.out.println("3. Supprimer un programmeur");
            System.out.println("4. Ajouter un programmeur");
            System.out.println("5. Modifier le salaire");
            System.out.println("6. Quitter");
            System.out.print("Quel est votre choix ? : ");

            int choix = scanner.nextInt();
            switch (choix) {
                case 1 -> {
                    List<Programmeur> pList = actionsBDD.afficherProgrammeurs();
                    for (Programmeur p : pList) {
                        System.out.println(p.toString());
                    }
                }


                case 2 -> {
                    System.out.print("Id du programmeur à afficher : ");
                    int id = scanner.nextInt();
                    Programmeur p = actionsBDD.getProgrammeurInput(id);
                    while(p == null) {
                        System.out.println("Recherche KO. Saissisez à nouveau l'id :");
                        id = scanner.nextInt();
                        p = actionsBDD.getProgrammeurInput(id);
                    }
                    System.out.println(p.toString());
                    
                }


                case 3 -> {
                    System.out.print("Id du programmeur à supprimer : ");
                    int id = scanner.nextInt();
                    boolean res = actionsBDD.supprimerProgrammeurInput(id);
                    while(!res) {
                        System.out.println("Suppression KO. Saissisez à nouveau l'id :");
                        id = scanner.nextInt();
                        res = actionsBDD.supprimerProgrammeurInput(id);
                    }
                    System.out.println("SUPPRESSION REUSSIE !");
                }

                case 4 -> {

                    try {
                        System.out.print("Id : ");
                        int id = scanner.nextInt();
                        System.out.print("Nom : ");
                        String nom = scanner.next();
                        System.out.print("Prenom : ");
                        String prenom = scanner.next();
                        System.out.print("Adresse : ");
                        String adresse = scanner.next();
                        System.out.print("Pseudo : ");
                        String pseudo = scanner.next();
                        System.out.print("Hobby : ");
                        String hobby = scanner.next();
                        System.out.print("Responsable : ");
                        String responsable = scanner.next();
                        System.out.print("Annee de naissance : ");
                        int anNaissance = scanner.nextInt();
                        System.out.print("Salaire : ");
                        double salaire = scanner.nextDouble();
                        System.out.print("Prime : ");
                        double prime = scanner.nextDouble();
                        Programmeur p = new Programmeur(id, nom, prenom, adresse, pseudo, hobby, responsable, anNaissance, salaire, prime);
                        actionsBDD.ajouterProgrammeur(p);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de la saisie des données.");
                    }
                }

                case 5 -> {
                    System.out.print("Id du programmeur à modifier : ");
                    int id = scanner.nextInt();
                    boolean res = actionsBDD.modifierSalaireInput(id, actionsBDD.getProgrammeurInput(id).salaire);
                    while(!res) {
                        System.out.println("Modification KO. Saissisez à nouveau l'id :");
                        id = scanner.nextInt();
                        res = actionsBDD.modifierSalaireInput(id, actionsBDD.getProgrammeurInput(id).salaire);
                    }
                    
                    System.out.print("Nouveau salaire de ce programmeur : ");
                    double salaire = scanner.nextDouble();
                    res = actionsBDD.modifierSalaireInput(id, actionsBDD.getProgrammeurInput(id).salaire);
                    System.out.println("MODIFICATION REUSSIE !");
                }
                
                case 6 -> actionsBDD.terminerProgramme();
                default -> System.out.println("Choix invalide.");
            }
        }
    }
}
