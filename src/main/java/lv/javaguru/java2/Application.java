package lv.javaguru.java2;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.views.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

// Use cases:


public class Application {

    public static void main(String[] args) {


        ApplicationContext context
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, ConsoleView> menuMap = new HashMap<>();
        //menuMap.put(2, con5text.getBean(RemoveProductView.class));
        menuMap.put(3, context.getBean(PrintTripView.class));
        menuMap.put(4, context.getBean(AddTripView.class));
        menuMap.put(5, context.getBean(RegisterUserView.class));
        menuMap.put(6, new ExitView());


        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            ConsoleView consoleView = menuMap.get(menuItem);
            consoleView.execute();

        }

    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        //System.out.println("2. Remove product from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Add trip");
        System.out.println("5. Register user");
        System.out.println("6. Exit");
    }

    private static int getFromUserMenuItemToExecute() {

        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("1");
        menuList.add("3");
        menuList.add("4");
        menuList.add("5");
        menuList.add("6");

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
