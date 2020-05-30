import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        Bank mbank = new Bank("mBank", "MB66");
        mbank.newCustomer("Maciej", "Zakrzewski", 9000.0);
        mbank.newCustomer("Jan", "Kowalski", 100.0);

        Bank ing = new Bank("Bank ING", "ING9");
        ing.newCustomer("Anna", "Kowalska", 1.50);
        ing.newCustomer("Joanna", "Baranowska", 500.0);
        ing.changeBalance(3, +9000.0);
        ing.changeBalance(4, -9000.0);

//        Validator validator = (Validator) Validation.buildDefaultValidatorFactory().getValidator();
//
//        Source data = mbank.newCustomer("Anna", "Kowalska", 1.50);
//        Set<ConstraintViolation<Bank>> validate = validator.validate(data);

        System.out.println(mbank);
        System.out.println(ing);
    }
}
