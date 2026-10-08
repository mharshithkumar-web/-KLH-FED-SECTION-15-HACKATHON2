import java.util.Scanner;

class Account {
    private String number;
    private String holder;
    private double money;

    public Account(String number, String holder, double money) {
        this.number = number;
        this.holder = holder;
        if (money < 0) {
            this.money = 0;
        } else {
            this.money = money;
        }
    }

    public void addMoney(double amt) {
        if (amt <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            money = money + amt;
            System.out.println("Successfully deposited Rs." + amt);
        }
    }

    public void takeMoney(double amt) {
        if (amt <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amt > money) {
            System.out.println("Insufficient balance! Available: Rs." + money);
        } else {
            money = money - amt;
            System.out.println("Successfully withdrawn Rs." + amt);
        }
    }

    public double getMoney() {
        return money;
    }

    public void show() {
        System.out.println("=================================");
        System.out.println("         ACCOUNT DETAILS");
        System.out.println("=================================");
        System.out.println("Account Number  : " + number);
        System.out.println("Account Holder  : " + holder);
        System.out.println("Current Balance : Rs." + money);
        System.out.println("=================================");
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String num = input.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double start = input.nextDouble();

        Account acc1 = new Account(num, name, start);

        System.out.print("Enter amount to deposit: ");
        double dep = input.nextDouble();
        acc1.addMoney(dep);

        System.out.print("Enter amount to withdraw: ");
        double wd = input.nextDouble();
        acc1.takeMoney(wd);

        System.out.println("Final Account Status:");
        acc1.show();

        input.close();
    }
}