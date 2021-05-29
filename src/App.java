import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        
        store test = new store();
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to create a password or retrieve an existing one?");
        System.out.println("A: create");
        System.out.println("B: retrieve");
        System.out.println("E: exit");
        System.out.println("=============================================================");
        System.out.print("Enter an option: ");
        char option = sc.next().charAt(0);

        if (option == 'A'){
            System.out.print("Type your username: ");
            Scanner ask = new Scanner(System.in);
            String uname = ask.nextLine();
        
            generator me = new generator();
            String pword = me.passGen();

            test.write(uname, pword);
            System.out.println("-------------------------------------------------------------");
            System.out.println("Password created.");
            ask.close();
        }
        else if (option == 'B'){
            System.out.print("Type your username: ");
            Scanner ask = new Scanner(System.in);
            String uname = ask.nextLine();

            System.out.println("-------------------------------------------------------------");
            System.out.print("The password for the user (" + uname + ") is: ");
            test.retrieve(uname);
            ask.close();
        }
        else if (option == 'E'){
            System.out.println("Goodbye");
            System.out.println("-------------------------------------------------------------");
        }
        else{
            System.out.println("Invalid input");
        }
        sc.close();
    }
}

class generator{

    String uname;
    String pword = "";

        String passGen(){
        Scanner sc = new Scanner(System.in);
        System.out.print("How long do you want your password to be: ");
        int len = sc.nextInt();

        String set = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for(int i = 0; i < len; i++){
            Random r = new Random();
            int x = r.nextInt(set.length());
            char add = set.charAt(x);
            pword += add;
        }
        sc.close();
        return pword;
    }
}
