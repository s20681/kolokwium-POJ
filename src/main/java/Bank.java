import javax.validation.Constraint;
import javax.validation.Validation;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Random;

public class Bank implements Annotation {
    String name;
    String fourDigitId;
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Bank(String name, String fourDigitId) {
        this.name = name;
        this.fourDigitId = fourDigitId;
    }

    Account newCustomer(String name, String surname, Double balance) {
        User user = new User(name, surname);
        users.add(user);

        Account account = new Account(user, balance);
        accounts.add(account);

        return account;
    }

    void changeBalance(int userId, double amount){
        for(Account account : accounts){
            if(account.owner.userId == userId){
                account.balance = account.balance + amount;
            }
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + "/" +
                "fourDigitId='" + fourDigitId + "\n"+
                "users=" + users + "\n"+
                "accounts=" + accounts +
                '}'+ "\n";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    private static class User {
        private static int userCount = 0;
        int userId;
        String name, surname;

        User(String name, String surname) {
            this.userId =  userCount++;
            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {
            return ("User{" +
                    "userId=" + userId +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}');
        }
    }

    private class Account {
        @AccountNo(key = "Test me")
        String accNo = generateAccNo();
        User owner;
        Double balance;

        public Account(User owner, Double balance) {
            this.owner = owner;
            this.balance = balance;
        }

        public String generateAccNo(){
            char[] dgs = "1234567890".toCharArray();
            StringBuilder sb = new StringBuilder(26);
            Random random = new Random();
            String accNo = "";
            for (int i = 0; i < 20; i++) {
                char c = dgs[random.nextInt(dgs.length)];
                accNo+=(c);
            }

            return accNo;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "owner=" + owner +
                    ", balance=" + balance +
                    '}';
        }
    }
}