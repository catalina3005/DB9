import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Account {

    static String accountNo;
    static double Amount;
    static long nationalId;

    public static void deposit(double amount) {
        Amount += amount;
    }

        public static void linkToNationalId ( long nationalId) throws InvalidNationalIdException {
        int digitsNumber = 0;
        while (nationalId > 0) {
            nationalId = nationalId / 10;
            digitsNumber++;
        }
//        System.out.println(digitsNumber);
        if (digitsNumber != 13)
        {throw new InvalidNationalIdException();}
    }
    public static void withdrow(int amount) throws NotEnoughMoneyException {
        Scanner scanner = new Scanner(System.in);
        double Amount = scanner.nextDouble();
        if (amount < Amount) {
            Amount -= amount;
            System.out.println("Fond actualizat: "+Amount);
        }
        else throw new NotEnoughMoneyException();
    }

    public static void main(String[] args) throws Exception, NotEnoughMoneyException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul contului accountNo=");
        String accountNo =scanner.next();
        System.out.println(accountNo);
        System.out.println("Introduceti CNP");
        long nationalId= scanner.nextLong();
        System.out.println(nationalId);
        linkToNationalId((long)nationalId);
        System.out.println("Introduceti suma pe care o aveti in cont=");
        withdrow(23);
    }

    ;
}


