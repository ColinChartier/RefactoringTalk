import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Colin's easy initial refactoring principle:
//1: think of any potential requirements your code might require in the future.
//  - for this class, more bank accounts than four?
//  - also, more than two types of accounts?
//2: if you were to implement any of these features, would your lines of code grow linearly?
//  - require (number of types of accounts)*(number of people) fields, for example.
//3: change your code so that this is no longer the case
class ExampleOneBankRevised {
  public static class Account {
    //put this in separate file
    //for illustrative purposes only.
    public static final int ACCOUNT_TYPE_CHEQUING = 2;
    public static final int ACCOUNT_TYPE_SAVINGS = 1;

    private final int type;
    private int balance; //in cents!

    public Account(int type, int balance) {
      this.type = type;
      this.balance = balance;
    }

    public int getType() {
      return type;
    }

    public int getBalance() {
      return balance;
    }

    public void setBalance(int balance) {
      this.balance = balance;
    }
  }

  private static Map<Integer, Set<Account>> accounts;

  public static int getMoney(int person, int accountType) {
    if(accounts.containsKey(person)) {
      Set<Account> personsAccounts = accounts.get(person);
      for(Account a : personsAccounts) {
        if(a.getType() == accountType) {
          return a.getBalance();
        }
      }
    }
    return 0;
  }

  public static void addMoney(int person, int accountType, int amount) {
    if(!accounts.containsKey(person)) {
      accounts.put(person, new HashSet<>());
    }
    for(Account a : accounts.get(person)) {
      if(a.getType() == accountType) {
        a.setBalance(a.getBalance() + amount);
        return;
      }
    }
    accounts.get(person).add(new Account(accountType, amount));
  }

  public static void main(String[] args) throws Exception {
    addMoney(1, 1, 0);
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );
    while(br.ready()) {
      String line = br.readLine();
      String[] split = line.split(" ");
      addMoney(Integer.valueOf(split[0]),
               Integer.valueOf(split[1]),
               Integer.valueOf(split[2]));
    }
  }
}
