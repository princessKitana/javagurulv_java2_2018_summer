package lv.javaguru.java2;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.views.*;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.JDBCDatabaseImpl;
import lv.javaguru.java2.services.AddProductService;
import lv.javaguru.java2.services.PrintProductService;
import lv.javaguru.java2.services.RemoveProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

// Use cases:
// 1. Add product to list
// 2. Remove product from list
// 3. Print shopping list to console
// 4. Exit

public class ShoppingListApplication {

    public static void main(String[] args) {


        ApplicationContext context
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, ConsoleView> menuMap = new HashMap<>();
        menuMap.put(1, context.getBean(AddProductView.class));
        menuMap.put(2, context.getBean(RemoveProductView.class));
        menuMap.put(3, context.getBean(PrintProductView.class));
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
