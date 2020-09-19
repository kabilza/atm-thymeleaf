package th.ac.ku.atm;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customerList;

    @PostConstruct
    public void postConstruct() {
        this.customerList = new ArrayList<>();
    }

    public void createCustomer(Customer customer) {
        String hashPin = hash(customer.getPin());
        customer.setPin(hashPin);
        customerList.add(customer);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(this.customerList);

        //return new list to prevent the re-order of the data.
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }

}
