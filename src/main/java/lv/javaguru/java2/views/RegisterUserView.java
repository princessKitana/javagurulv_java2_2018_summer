package lv.javaguru.java2.views;

import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserService;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserResponse;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RegisterUserView implements ConsoleView{

    @Autowired
    private RegisterUserService service;

    public void execute() {

        System.out.println();
        System.out.println("---");
        User newUser = new User();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter First Name(optional):");
            newUser.setFirstName(sc.nextLine());

            System.out.print("Enter Last Name(optional):");
            newUser.setLastName(sc.nextLine());

            System.out.print("Enter login*:");
            newUser.setLogin(sc.nextLine());

            System.out.print("Enter password*:");
            newUser.setPassword(sc.nextLine());

            System.out.print("Enter phone*:");
            newUser.setPhone(sc.nextLine());

            System.out.print("Enter email(optional):");
            newUser.setEmail(sc.nextLine());

        newUser.setDriver(false);

        RegisterUserRequest req = new RegisterUserRequest(newUser);
        RegisterUserResponse resp = service.registerUser(req);

        System.out.println("Registartion:"+resp.isSuccess());

        System.out.println("---");
        System.out.println();
    }


}
