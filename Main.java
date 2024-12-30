public class Main {
    public static void main(String[] args) {
        ActionsBDD actionsBDD = new ActionsBDDImpl();
        Terminal terminal = new Terminal(); 
        Caller caller = new Caller(terminal,actionsBDD);
        caller.start();
    }
}
