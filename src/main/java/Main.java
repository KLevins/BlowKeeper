import java.util.Scanner;

public class Main {

    public static void main (String args[])   {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your word: ");
        String s = scan.nextLine();
        System.out.println("Last word: "+s);
        if (s.trim().equals("1")) {
            System.out.println("mission complit");
            System.out.println("fdvbiu");
        }
    }
}
