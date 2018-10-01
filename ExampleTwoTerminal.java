import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExampleTwoTerminal {
  abstract static class Command {
    void printUsage() {
      System.out.println("No usage information.");
    }

    abstract void run(String[] args);
  }

  public static class ListCommand extends Command {
    void printUsage() {
      System.out.println("Usage: ls (-a)");
    }
    
    void run(String[] args) {
      System.out.println("file1 file2 file3");
    }
  }

  public static class EchoCommand {
    void printUsage() {
      System.out.println("Usage: echo (strings...)");
    }
    void run(String[] args) {
      for(int i = 1; i < args.length; i++) {
        System.out.print(args[i]);
        if(i != args.length-1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      System.out.print("[207Term] ~ > ");
      String line = br.readLine();
      if(line == null) {
        return;
      }
      String[] command = line.split(" ");
      if(command[0].equals("ls")) {
        if(command.length > 1 && command[1].equals("-h")) {
          (new ListCommand()).printUsage();
        } else {
          (new ListCommand()).run(command);
        }
      } else if(command[0].equals("echo")) {
        if(command.length > 1 && command[1].equals("-h")) {
          (new EchoCommand()).printUsage();
        } else {
          (new EchoCommand()).run(command);
        }
      }
    }
  }
}
