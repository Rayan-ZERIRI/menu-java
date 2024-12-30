public class Main {
    public static void main(String[] args) {
        ActionsBDD actionsBDD = new ActionsBDDImpl();
        Menu menu = new Menu(actionsBDD);
        Terminal terminal = new Terminal(); 
        Caller caller = new Caller(terminal);
        caller.start();
        menu.afficherMenu();
    }
}
