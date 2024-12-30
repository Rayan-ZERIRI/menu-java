public class Caller {

    private ActionsBDD actionsBDD;
    public Terminal terminal;

    public Caller(Terminal terminal, ActionsBDD actionsBDD) {
        System.out.println("Caller init good!");
        this.terminal = terminal;
        this.actionsBDD = actionsBDD;
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
                this.actionsBDD.showAllProgrammers();
                break;
            case 2:
                this.actionsBDD.showProgrammerInput();
                break;
            case 3:
                this.actionsBDD.deleteProgrammer();
                break;
            case 4:
                this.actionsBDD.addProgrammerInput();
                break;
            case 5:
                this.actionsBDD.modifySalaryInput();
                break;
            case 6:
                this.terminal.printMessage("Exiting...");
                System.exit(0);  // Exit the program
                break;
            default:
                this.terminal.printMessage("Option invalide. Veuillez réessayer.");
        }
    }

}