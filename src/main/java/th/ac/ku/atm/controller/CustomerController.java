package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import th.ac.ku.atm.Customer;
import th.ac.ku.atm.service.CustomerService;

import java.util.ArrayList;

@Controller
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/customer")
    public String getCustomerPage(Model model) {
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "customer";
    }

    @PostMapping("/customer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }



}
