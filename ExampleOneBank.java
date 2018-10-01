import java.io.BufferedReader;
import java.io.InputStreamReader;

//Colin's easy initial refactoring principle:
//1: think of any potential requirements your code might require in the future.
//  - for this class, more bank accounts than four?
//  - also, more than two types of accounts?
//2: if you were to implement any of these features, would your lines of code grow linearly?
//  - require (number of types of accounts)*(number of people) fields, for example.
//3: change your code so that this is no longer the case
class ExampleOneBank {
  private static int personOneSavings;
  private static int personTwoSavings;
  private static int personTwoChequing;
  private static int personThreeChequing;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );
    //input is of the form person (1, 2, ...), accountType(1 = savings, 2 = chequing), amount(in cents)
    //e.g., 1 1 200 would add 200 cents (2$) to person 1's savings account
    while(br.ready()) {
      String line = br.readLine();
      String[] split = line.split(" ");
      if(Integer.valueOf(split[0]) == 1) {
        //person 1
        if(Integer.valueOf(split[1]) == 1) {
          //savings
          personOneSavings += Integer.valueOf(split[2]);
        }
        else  {
          System.out.println("Person one does not have that type of account!");
        }
      }
      else if(Integer.valueOf(split[0]) == 2) {
        //person 2
        if(Integer.valueOf(split[1]) == 1) {
          //savings
          personTwoSavings += Integer.valueOf(split[2]);
        } else if(Integer.valueOf(split[1]) == 2) {
          //chequing
          personTwoChequing += Integer.valueOf(split[2]);
        } else {
          System.out.println("Person two does not have that type of account!");
        }
      } else if(Integer.valueOf(split[0]) == 3) {
        //person 3
        if(Integer.valueOf(split[1]) == 2) {
          //chequing
          personThreeChequing += Integer.valueOf(split[2]);
        }
        else  {
          System.out.println("Person one does not have that type of account!");
        }
      }
    }
  }
}
