import java.util.Scanner;

public class AgeValidating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age");
        int a = sc.nextInt();
        try {
            checkAge(a);
        } catch (AgeInvalidException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    static void checkAge(int age)throws AgeInvalidException{
        if(age<18) throw new AgeInvalidException("ggdegd");
        System.out.println( "Eligible is vote");

    }
}
class AgeInvalidException extends Exception{
    AgeInvalidException(String msg){
        super(msg);
    }
}