import System.Operation.MyException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MyException {
        LibrarySystem lib = new LibrarySystem();
        lib.start();
    }
}