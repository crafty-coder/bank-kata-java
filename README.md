### Bank Kata - Description

Create a simple bank application with the following features:

- Deposit into Account
- Withdraw from an Account
- Print a bank statement to the console

## Acceptance criteria

- Given a client makes a deposit of 1000.00 on 01/04/2014
- And a withdrawal of 100.00 on 02/04/2014
- And a deposit of 500.00 on 10/04/2014
- When she prints her bank statement
- Then she would see

```
DATE       | AMOUNT  | BALANCE
10/04/2014 | 500.00  | 1400.00
02/04/2014 | -100.00 | 900.00
01/04/2014 | 1000.00 | 1000.00
```

## Constrains

1. Start with the following class:

```
public class Account {
    public void deposit(int amount);
    public void withdraw(int amount);
    public void printStatement();
}
```

2. You are not allowed to add any other public method to this class.
3. Use Strings for Dates and Integer for amounts (keep it simple)


