import java.util.Scanner;

public class passwordValidator {

   public static boolean validatePass(String password) {
      if (password.length() < 8 || password.length() > 16) {
         return false;
      }
   

      boolean hasLowCase = false;
      boolean hasUpCase = false;
      boolean hasNum = false;
      boolean hasSymbol = false;

      //for loop to check for requirements
      for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);

         if(Character.isLowerCase(c)) {
         hasLowCase = true;
         }

         else if (Character.isUpperCase(c)) {
            hasUpCase = true;
          }
         else if (Character.isDigit(c)) {
            hasNum = true;
         }
         else if (isSpecialCharacter(c)) {
            hasSymbol = true;
         }
      }
      //counting how many req password meets, needs min of 3
   int categoryCount = 0;
   if (hasLowCase) categoryCount++;
   if (hasUpCase) categoryCount++;
   if (hasNum) categoryCount++;
   if (hasSymbol) categoryCount++;

   return categoryCount >=3;
   }

   //mothod to check requirement of a special symbol
   private static boolean isSpecialCharacter(char c) {
      String specialChars = "~@#$%^&*()-=+_";
      return specialChars.indexOf(c) >= 0;
   }


   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      //asking the user to input their password
      System.out.print("Enter a password: ");
      String password = scanner.nextLine();

      if (validatePass(password)) {
         System.out.println("Password is valid!");
      }
      else {
         System.out.println("Password is invalid!");
      }

      scanner.close();
   }
}