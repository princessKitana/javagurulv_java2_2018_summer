package lv.javaguru.java2;

import lv.javaguru.java2.Views.*;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.InMemoryDatabase;
import lv.javaguru.java2.database.JDBCDataBaseImpl;
import lv.javaguru.java2.services.AddProductService;
import lv.javaguru.java2.services.PrintProductService;
import lv.javaguru.java2.services.RemoveProductService;

import java.util.*;


public class ShoppingListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add product to list
        // 2. Remove product from list
        // 3. Print shopping list to console
        // 4. Exit

        Database database = new JDBCDataBaseImpl();
        AddProductService addProductService = new AddProductService(database);
        RemoveProductService removeProductService = new RemoveProductService(database);
        PrintProductService printProductService = new PrintProductService(database);

        AddProductView addProductView = new AddProductView(addProductService);
        RemoveProductView removeProductView = new RemoveProductView(removeProductService);
        PrintProductView printProductListView = new PrintProductView(printProductService);

        Map<Integer, ConsoleView> menuMap = new HashMap<>();
        menuMap.put(1, addProductView);
        menuMap.put(2, removeProductView);
        menuMap.put(3, printProductListView);
        menuMap.put(4, new ExitView());


        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            ConsoleView consoleView = menuMap.get(menuItem);
            consoleView.execute();

        }

    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add product to list");
        System.out.println("2. Remove product from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {

        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1");
        menuList.add("2");
        menuList.add("3");
        menuList.add("4");

        Scanner sc = new Scanner(System.in);
        String userInput;
        int selectedMenuItem=1;

            boolean b = false;
            while(!b) {
                System.out.print("Please enter menu item number to execute:");
                userInput = sc.nextLine();
                b = menuList.contains(userInput);
                if (b) selectedMenuItem = Integer.parseInt(userInput);
            }

        return selectedMenuItem;
    }

}
