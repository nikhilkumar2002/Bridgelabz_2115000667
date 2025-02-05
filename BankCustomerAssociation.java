import java.util.ArrayList;

// Class representing a bank account linked to a bank
class BankAccount {
    double balance;
    Bank bank; // The bank associated with this account

    BankAccount(Bank bank, double initialDeposit) {
        this.bank = bank;
        this.balance = initialDeposit;
    }
}

// Bank class with the openAccount() method
class Bank {
    String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }

    // Method to open an account for a customer
    BankAccount openAccount(Customer customer, double initialDeposit) {
        BankAccount account = new BankAccount(this, initialDeposit);
        customer.addAccount(account);
        return account;
    }
}

// Customer class with the viewBalance() method
class Customer {
    String name;
    ArrayList<BankAccount> accounts;

    Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    // Method to add a bank account to the customer
    void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to view balances for all accounts of the customer
    void viewBalance() {
        System.out.println("\nAccount balances for " + name + ":");
        for (BankAccount account : accounts) {
            System.out.println("Bank: " + account.bank.bankName + ", Balance: " + account.balance);
        }
    }
}

// Main class to demonstrate the association between Bank and Customer
public class BankCustomerAssociation {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank");
        Customer Ram = new Customer("Ram");
        Customer Raj = new Customer("Raj");

        // Open accounts for customers using the bank's openAccount() method
        bank.openAccount(Ram, 1000.0);
        bank.openAccount(Raj, 1500.0);

        // Customers view their account balances
        Ram.viewBalance();
        Raj.viewBalance();
    }
}
