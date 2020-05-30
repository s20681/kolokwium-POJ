import java.util.ArrayList;

public class Bank {
    String fourDigitId;
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Bank(String fourDigitId) {
        this.fourDigitId = fourDigitId;
    }

    void newCustomer(String name, String surname, Double balance) {
        User user = new User(name, surname);
        users.add(user);

        Account account = new Account(user, balance);
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "fourDigitId='" + fourDigitId + '\'' +
                ", users=" + users +
                ", accounts=" + accounts +
                '}';
    }

    private static class User {
        private static int userCount = 0;
        int userId;
        String name, surname;
        Double initialBalance;

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
                    ", initialBalance=" + initialBalance +
                    '}');
        }
    }

    private class Account {
        User owner;
        Double balance;

        public Account(User owner, Double balance) {
            this.owner = owner;
            this.balance = balance;
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