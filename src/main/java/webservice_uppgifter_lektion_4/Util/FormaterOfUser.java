package webservice_uppgifter_lektion_4.Util;

import webservice_uppgifter_lektion_4.Model.User;

public class FormaterOfUser {
    //! La till en hjälp metod för att göra om namnet lite annorlunda
    //! Mest för skojs skull, kanske inte är rätt praxis dock..

    //! Färger
    //! En färg för röd och en färg som återställer
    //! Kanske inte det snyggaste men är väl det enklaste när det är en ForLoop
    public static final String REDCOLOUR = "\u001B[31m";
    public static final String WHITE = "\u001B[39m";



    public static String format(User user){
        return    "ID: " + REDCOLOUR + user.id() + WHITE + ", " +
                "och namnet i listan är: " + REDCOLOUR + user.username() + WHITE;

    }


}
