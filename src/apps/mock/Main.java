package apps.mock;

import apps.mock.implementations.MockActiveAuctionLoader;
import control.BidCommand;
import control.Command;
import control.ExitCommand;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Auction;
import model.Bid;

public class Main {

    public Main() {
    }

    
    private final Map<String, Command> commands = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private final static Command NullCommand = new Command.Null();

    static ExitCommand exitCommand = new ExitCommand();
    static MockActiveAuctionLoader mockActiveAuctionLoad = new MockActiveAuctionLoader();
    static Auction auction = mockActiveAuctionLoad.load();
    static BidCommand bidCommand;

    
    public static void main(String[] args) {
        
        System.out.println("Pujando " + auction.toString());
        
        while(true){
            System.out.println("Pujas actuales: " + auction.actualBids());
            System.out.println("Seleccione una opción: \n"
                + "Q - Salir\n"
                + "P - Pujar\n"
                + "-------------------");
        
            String selection = input();
            switch(selection){
                case "P":
                    System.out.println("Introduce el producto por el que quieres pujar: ");
                    String product = input();
                    System.out.println("Introduce la cantidad por la que quieres pujar: ");
                    String amount = input();
                    bidCommand = new BidCommand(mockActiveAuctionLoad, new Bid(Double.parseDouble(amount), product));
                    bidCommand.execute();
                    break;
                case "Q":
                    exitCommand.execute();
            }
        }
        
    }
    
    private void execute(){
        while(true) commands.getOrDefault(input(), NullCommand).execute();
    }
    
    private static String input() {
        return scanner.next();
    }   
    
   
}
