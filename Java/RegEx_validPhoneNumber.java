package Regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {
    



   public static boolean validateUsername(String userName) {
      if (userName.trim().equals("")) {
         return false;
      }

      // TODO 1: Initialize the value of String regex with the required regular
      // expression for userName validation.
      String regex = "^[a-zA-Z]*$";
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(userName);
      return m.matches();
   }

   public static void main(String[] args) {
      if (args != null && args.length != 0) {
         System.out.print(validateUsername(args[0]));
      } else {
         //String userName = "Manoj_Madal";
         // uncomment below line and comment above line for testing sample test case 2
          String userName = "";
         System.out.print(validateUsername(userName));
      }
   }
}
