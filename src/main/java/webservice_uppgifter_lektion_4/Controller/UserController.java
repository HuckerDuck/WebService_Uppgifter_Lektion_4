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
                    new User(0, "lösenord123", "Benny", true),
                    new User(1,  "lösenord123", "Fredrik", true),
                    new User(2, "lösenord123", "Leif", false),
                    new User(3, "lösenord123", "Anton", true),
                    new User(4, "lösenord123", "Frida", true)
            ))
    );
    //! Uppgift 3
    //! Åkalla User
    //! Lägg in en return som också lägger in en ny user
    @GetMapping(value="/newuser")
    public User newUser(){
        return new User( 5, "Kalle Åberg", "Lösenord123", true);
    }

    //! Uppgift 4
    //! Definiera ett username
    //! Returtypen kan se ut se här:
    //! Return new User(0, username, “123”, true)

    //! public, vad du vill returnera, metodnamn, (@PathVariable String sen namnet)
    @GetMapping(value="/users/name/{username}")
    public User getByName(@PathVariable String username){
        return new User(0, username, "Lösenord123", true);
    }



    @GetMapping(value="/users")
    public List<User> getUsers() {
        System.out.println();
        System.out.println("Users in the list: ");
        System.out.println();
        for (User user : userList){

            System.out.println(FormaterOfUser.format(user));
        }

        //! La till så att jag även får ut i json.
        //! Från void till en med retur
        return userList;
    }

    @PostMapping(value= "/users")
    public void CreateUser(){
        userList.add(new User(userList.size(), "DeBugging", "debuggingPassword", true));
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
