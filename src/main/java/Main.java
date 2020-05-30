public class Main {
    public static void main(String[] args) {
        Bank mbank = new Bank("MB66");
        mbank.newCustomer("Maciej", "Zakrzewski", 9000.0);
        mbank.newCustomer("Jan", "Kowalski", 100.0);

        Bank ing = new Bank("ING9");
        ing.newCustomer("Anna", "Kowalska", 1.50);
        ing.newCustomer("Joanna", "Baranowska", 500.0);


        System.out.println(mbank);
        System.out.println(ing);
    }
}
