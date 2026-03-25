/**package main;
import  model.Book; 

public class Main {
    
    public static void main(String[] args) {
        Book book1 = new Book("1","Clean code","Robert C.Martin","insb1", true);
        book1.getDetails();
    }
}*/

package main;

import service.LibraryService;
import service.LibraryServiceImpl;
import ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryServiceImpl();
        ConsoleUI ui = new ConsoleUI(service);

        ui.showMenu();
    }
}
