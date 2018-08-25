//package lv.javaguru.java2.views;
//
//import lv.javaguru.java2.services.RemoveProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Scanner;
//@Component
//public class RemoveProductView implements ConsoleView {
//    @Autowired
//    private RemoveProductService removeProductService;
//
//    public void execute(){
//        System.out.println();
//        System.out.println("---");
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter product title:");
//        final String title = sc.nextLine();
//
//        boolean isRemoved = removeProductService.removeProductByTitle(title);
//        if (isRemoved) {
//            System.out.println("Product with title " + title + " was found and will be removed from list!");
//        } else {
//            System.out.println("Product with title " + title + " not found and not removed from list!");
//        }
//
//        System.out.println("---");
//        System.out.println();
//    }
//}
