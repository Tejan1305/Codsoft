import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        // Create the user's bank account with an initial balance of 1000.0 and a PIN of "1234"
        BankAccount account = new BankAccount(1000.0, "1234");

        // Create the ATM machine and connect it to the user's bank account
        ATMMachine atm = new ATMMachine(account);

        // Start the ATM machine
        atm.start();
    }

    static class BankAccount {
        private double balance;
        private String pin;

        public BankAccount(double initialBalance, String pin) {
            this.balance = initialBalance;
            this.pin = pin;
        }

        public double getBalance() {
            return balance;
        }

        public boolean validatePin(String enteredPin) {
            return pin.equals(enteredPin);
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }
    }

    static class ATMMachine {
        private BankAccount account;
        private Scanner scanner;

        public ATMMachine(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void start() {
            int choice;
            do {
                displayMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                handleChoice(choice);
            } while (choice != 4);
        }

        private void displayMenu() {
            System.out.println("Welcome to the ATM Machine!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
        }

        private void handleChoice(int choice) {
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM Machine...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        private void withdraw() {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();
            if (account.validatePin(pin)) {
                System.out.print("Enter the withdrawal amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                if (account.withdraw(amount)) {
                    System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                } else {
                    System.out.println("Insufficient balance. Withdrawal failed.");
                }
            } else {
                System.out.println("Invalid PIN. Withdrawal cancelled.");
            }
        }

        private void deposit() {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();
            if (account.validatePin(pin)) {
                System.out.print("Enter the deposit amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Invalid PIN. Deposit cancelled.");
            }
        }

        private void checkBalance() {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();
            if (account.validatePin(pin)) {
                System.out.println("Your current balance is: " + account.getBalance());
            } else {
                System.out.println("Invalid PIN. Balance check cancelled.");
            }
        }
    }
}
