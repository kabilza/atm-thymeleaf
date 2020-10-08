package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.model.Money;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAccumulator;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("allBankAccount", bankAccountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.openAccount(bankAccount);
        model.addAttribute("allBankAccount",bankAccountService.getBankAccounts());
        return "redirect:bankaccount";
    }


    @GetMapping("/deposit/{id}")
    public String getDepositPage(@PathVariable int id, Model model) {
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-deposit";
    }

    @GetMapping("/withdraw/{id}")
    public String getWithdrawPage(@PathVariable int id, Model model) {
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-withdraw";
    }

    @PostMapping("/deposit/{id}")
    public String deposit(@PathVariable int id,
                          @RequestBody MultiValueMap<String, String> formData,
                          Model model) {

        Money money = new Money(Double.parseDouble(formData.get("amount").get(0)));

        bankAccountService.depositBankAccount(id, money);
        model.addAttribute("bankAccount",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/withdraw/{id}")
    public String withdraw(@PathVariable int id,
                           @RequestBody MultiValueMap<String, String> formData,
                           Model model) {

        Money money = new Money(Double.parseDouble(formData.get("amount").get(0)));

        bankAccountService.withdrawBankAccount(id, money);
        model.addAttribute("bankAccount",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        bankAccountService.deleteBankAccount(bankAccount);
        model.addAttribute("bankAccount",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }
}
