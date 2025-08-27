package webservice_uppgifter_lektion_4.Controller;


import org.springframework.web.bind.annotation.*;
import webservice_uppgifter_lektion_4.Model.User;
import webservice_uppgifter_lektion_4.Util.FormaterOfUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    List<User> userList = new ArrayList<>(
            (Arrays.asList(
                    new User(0, "Benny"),
                    new User(1, "Fredrik"),
                    new User(2, "Leif"),
                    new User(3, "Anton"),
                    new User(4, "Frida")
            ))
    );

    @GetMapping(value="/users")
    public void getUsers() {
        System.out.println();
        System.out.println("Users in the list: ");
        System.out.println();
        for (User user : userList){

            System.out.println(FormaterOfUser.format(user));
        }
    }

    @PostMapping(value= "/users")
    public void CreateUser(){
        userList.add(new User(userList.size(), "DeBugging"));
    }

    //! Hämta baserat på ett värde
    @GetMapping(value = "/users/{id}")
    public void getUser(@PathVariable("id") String id ){
        for (User user : userList){
            if (user.id() == Integer.parseInt(id)){

                System.out.println(user);
            }
        }
    }

    //! Ta bort baserat på ID
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable("id") int id) {


        for (User user : userList) {

            if (user.id() == id) {
                return userList.remove(id);
            }
        }
        return null;
    }






}
