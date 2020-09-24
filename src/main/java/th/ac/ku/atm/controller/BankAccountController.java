package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.BankAccount;
import th.ac.ku.atm.BankAccountService;

import java.util.ArrayList;

@Controller
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService){ this.bankAccountService = bankAccountService;}

    ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    @GetMapping("/bankaccount")
    public String getBankAccountPage(Model model) {
        model.addAttribute("allBankAccount", bankAccountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping("/bankaccount")
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model){
        bankAccountService.createBankAccount(bankAccount);
        model.addAttribute("allBankAccount", bankAccountService.getBankAccounts());
        return "redirect:bankaccount";
    }
}
