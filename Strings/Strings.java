import java.util.*;
public class Strings {
    
    // Print Letters
    public static void printLetters(String str){
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i) + " ");
        }
    }
    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd'};
        String str = "abcd";
        String str2 = new String("xyz");

        // Strings are IMMUTABLE

        Scanner scn = new Scanner(System.in);
       /*  String name = scn.next(); //word capture
        String name2 = scn.nextLine(); // capture complete line
        System.out.println(name);
        System.out.println(name2); */

        /* String fullName = "Jaykant Kumar";
        System.out.println(fullName.length()); */

        // concatenation
        /* String firstName = "Jaykant";
        String lastName = "Yadav";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName + " is this"); */

        /* String name = "Jaykant";
        printLetters(name); */

        String s1 = "Jaykant";
        String s2 = "Jaykant";
        String s3 = new String("Jaykant");

        // == is object level on compare
        if (s1 == s2) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }

        if (s1 == s3) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }

        // (str).equal(str) is value level on compare
        if(s1.equals(s3)){
            System.out.println("Strings are equal");
        }else{
            System.out.println("Strings are not equal");
        }
    }
}
