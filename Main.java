public class Main {
    public static void main(String[] args) {
        // Initialize Caller and Terminal classes
        Terminal terminal = new Terminal();
        Caller caller = new Caller(terminal);
        
        // Start the Caller, which uses the Terminal for interaction
        caller.start();
    }
}
