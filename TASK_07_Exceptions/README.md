Specifications

- You will start from a copy of the Movement and BankAccount classes that appeared in the previous unit (7.2 Collections). In this same document, below, you have the code so you can copy it and then paste it into your project.

- You should consider making a movement that causes red numbers as an exception. If this is going to happen, the exception will be thrown and the move should not be performed. To do this you must create an exception class that will be called NumerosRojosException and will be of type “checked”.

- The following Main class creates a BankAccount object, adds an initial balance of 100 euros to it through an entry. Finally, it allows the user to withdraw money by requesting the amount via keyboard.

import java.util.Scanner;

public class Main {

              public static void main(String args[]) throws RedNumbersException {

                            Scanner reader = new Scanner(System.in);

                            System.out.println

                       ("We are going to create an account and make the first deposit of 100 euros");

                           BankAccount myAccount = new BankAccount

                           (38143, "Amelia González");

                           myAccount.addMovement("Initial income", 100);

                           System.out.println("How much money you want to withdraw: ");

                           int money;

                           money = Integer.parseInt(reader.nextLine());

                           myAccount.addMovement("Withdrawal", -money);

                           reader.close();

                           System.out.println(myAccount);

                           System.out.println(myAccount.listMovements());

               }

}



You must make the following changes to the Main class: use a try … catch block to handle the two possible exceptions that may occur: NumberFormatException if the user enters an incorrect value for the entry of the amount to be withdrawn and NumerosRojosException if red numbers occur.

 

Movement and Bank Account Classes

import java.time.LocalDate;

public class Movement {

              private LocalDate date;

              private String concept;

              private double quantity;

              private double balance;

              public Movement(String concept, double amount, double balance) {

                            this.concept = concept;

                            this.quantity = quantity;

                            this.balance = balance;

                            this.date = LocalDate.now();

             }

             @Override

             public String toString() {

                           return date + " Concept=" ​​+ concept + ", Quantity=" + amount + ", Balance=" + balance;

             }

}





import java.util.ArrayList;

public class BankAccount {

              private int accountNumber;

              private String client;

              private double balance;

              private ArrayList<Movement> moves;

              public BankAccount(int accountNumber, String customer) {

                            this.accountNumber = accountNumber;

                            this.client = client;

                            this.balance = 0;

                            this.movements = new ArrayList();

               }

               public void addMovement(String concept, double quantity) {

                             this.balance = this.balance + amount;

                             this.movements.add(new Movement(concept, quantity, balance));

             }

             @Override

             public String toString() {

                           return "Number=" + accountNumber + ", Customer=" + customer + ", Balance=" + balance;

             }



             public String listMoves() {

                           String listing = "";

                           for (Motion mov : this.movements) {

                                    listing = listing + mov.toString()+"\n";

                           }

                           return list;

               }

}
