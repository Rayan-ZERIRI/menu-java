public class Main {
    public static void main(String[] args) {
        ActionsBDD actionsBDD = new ActionsBDDImpl();
        Menu menu = new Menu(actionsBDD);
        menu.afficherMenu();
    }
}
