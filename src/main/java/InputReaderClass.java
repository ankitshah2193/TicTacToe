import java.util.Scanner;

public class InputReaderClass {
    Scanner scanner;

    public InputReaderClass() {
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return scanner.nextLine();
    }

    public String getInput() {
        return scanner.nextLine();
    }

}
