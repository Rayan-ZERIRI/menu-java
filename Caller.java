public class Caller {

    //private DB db;
    public Terminal terminal;

    public Caller(Terminal terminal) {
        System.out.println("Caller init good!");
        this.terminal = terminal;
        //this.db = new DB();  // Initialize DB
    }

    public void start() {
        while (true) {
            this.terminal.displayMenu();  // Display menu to the user
            int option = this.terminal.getMenuChoice();  // Get user's choice
            handleUserInput(option);  // Handle user input
        }
    }

    private void handleUserInput(int option) {
        System.out.println(option);
        switch (option) {
            case 1:
                showAllProgrammers();
                break;
            case 2:
                showProgrammerInput();
                break;
            case 3:
                deleteProgrammer();
                break;
            case 4:
                addProgrammerInput();
                break;
            case 5:
                modifySalaryInput();
                break;
            case 6:
                this.terminal.printMessage("Exiting...");
                System.exit(0);  // Exit the program
                break;
            default:
                this.terminal.printMessage("Option invalide. Veuillez réessayer.");
        }
    }

    private void showAllProgrammers() {
        // Get all programmers from DB and display them
       // db.getAllProgrammers().forEach(programmer -> this.terminal.printMessage(programmer.toString()));
    }

    private void showProgrammerInput() {
        int id = this.terminal.getIntInput("Entrez l'ID du programmeur à afficher : ");
        
        // Get the programmer from DB
        //Programmer programmer = db.getProgrammerById(id);
        /*if (programmer != null) {
            this.terminal.printMessage(programmer.toString());
        } else {
            this.terminal.printMessage("Aucun programmeur trouvé avec l'ID : " + id);
        }*/
    }

    private void deleteProgrammer() {
        int id = this.terminal.getIntInput("Entrez l'ID du programmeur à supprimer : ");
        
        // Delete the programmer from DB
        //boolean success = db.deleteProgrammerById(id);
        boolean success = true;
        if (success) {
            this.terminal.printMessage("Le programmeur avec l'ID " + id + " a été supprimé.");
        } else {
            this.terminal.printMessage("Aucun programmeur trouvé avec l'ID : " + id);
        }
    }

    private void addProgrammerInput() {
        String name = this.terminal.getStringInput("Entrez le nom du programmeur : ");
        String skillSet = this.terminal.getStringInput("Entrez les compétences du programmeur : ");
        
        // Add the programmer to the DB
        //db.addProgrammer(new Programmer(name, skillSet));
        this.terminal.printMessage("Programmeur ajouté avec succès !");
    }

    private void modifySalaryInput() {
        int id = this.terminal.getIntInput("Entrez l'ID du programmeur dont vous souhaitez modifier le salaire : ");
        double newSalary = this.terminal.getIntInput("Entrez le nouveau salaire du programmeur : ");
        
        // Modify the salary of the programmer in the DB
        //boolean success = db.modifySalary(id, newSalary);
        boolean success = true;
        if (success) {
            this.terminal.printMessage("Le salaire du programmeur avec l'ID " + id + " a été mis à jour.");
        } else {
            this.terminal.printMessage("Aucun programmeur trouvé avec l'ID : " + id);
        }
    }
}
