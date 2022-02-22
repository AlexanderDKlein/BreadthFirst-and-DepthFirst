import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main (String args[]) {
        //Creates the tree
        Branch m = new Branch('m');
        Branch l = new Branch('l');
        Branch k = new Branch('k', l, m);
        Branch j = new Branch('j');
        Branch i = new Branch('i', j, k);
        Branch h = new Branch('h');
        Branch g = new Branch('g');
        Branch f = new Branch('f', h, i);
        Branch e = new Branch('e',  f, g);
        Branch d = new Branch('d');
        Branch c = new Branch('c');
        Branch b = new Branch('b', d, e);
        Branch a = new Branch('a', b, c);

        //Asks the user to enter a search method:
        String input;
        do {
            System.out.println("Enter a searching method (dfs or bfs) or quit:");
            Scanner scnr = new Scanner(System.in);
            input = scnr.next();

            System.out.print("Start: ");

            if (input.equalsIgnoreCase("dfs")) {
                //Runs Depth First Search
                //Initializes maze finder.
                Stack<Branch> goalFinder = new Stack<>();
                goalFinder.push(a);

                //Searches for the goal.
                while (!goalFinder.peek().equals(m)) {
                    //Prints current node
                    System.out.println(goalFinder.peek().getNode());

                    //Checks if current node has no children
                    if (goalFinder.peek().getLeft() == null && goalFinder.peek().getRight() == null) {
                        //If it doesn't, it backtracks until it finds the next unchecked node.
                        Stack<Branch> backtrace = new Stack<>();
                        backtrace.push(goalFinder.peek());
                        while (goalFinder.peek().getRight() == null || backtrace.contains(goalFinder.peek().getRight())) {
                            goalFinder.pop();
                            backtrace.push(goalFinder.peek());
                        }
                        goalFinder.push(goalFinder.peek().getRight());
                    //Checks if there is only a right path.
                    } else if (goalFinder.peek().getLeft() == null && !(goalFinder.peek().getRight() == null)) {
                        goalFinder.push(goalFinder.peek().getRight());
                    //Moves left
                    } else {
                        goalFinder.push(goalFinder.peek().getLeft());
                    }
                }
                //Outputs the goal node
                System.out.println(goalFinder.peek().getNode() + "\nGoal");
            } else if (input.equalsIgnoreCase("bfs")) {
                //Runs Breadth First Search
                //Initializes the goal finder
                Queue<Branch> goalFinder = new LinkedList<>();
                goalFinder.add(a);

                //Searches for the goal.
                while (!(goalFinder.peek().equals(m))) {
                    //Grabs the children of the node and gets rid of the old one.
                    System.out.println(goalFinder.peek().getNode());
                    if (goalFinder.peek().getLeft() != null) {
                        goalFinder.add(goalFinder.peek().getLeft());
                    }
                    if (goalFinder.peek().getRight() != null) {
                        goalFinder.add(goalFinder.peek().getRight());
                    }
                    goalFinder.remove();
                }

                //Outputs the goal node
                System.out.println(goalFinder.peek().getNode() + "\nGoal");
            } else if (!input.equalsIgnoreCase("quit")){
                //Check if user input is undefined.
                System.out.println("Invalid search method!\n");
            }
        //Checks if the user is quitting the program
        } while (!input.equalsIgnoreCase("quit"));
        System.out.println("Quitting Program");
    }
}
