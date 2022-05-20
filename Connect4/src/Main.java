import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private static Scanner input;
    private static PrintStream output;

    private static Player[] players;

    private static Item[] lastItems;

    private static final char[] icons = {'O', '%', '@', '$', 'W', '!'};

    public static void main(String[] args) {
        output = System.out;
        input = new Scanner(System.in);

        int numPlayers = retrieveInt("Please enter the number of players:");
        if (numPlayers == 0) {
            return;
        }

        initPlayers(numPlayers);

        int rows = retrieveInt("Please enter the number of rows:");
        int cols = retrieveInt("Please enter the number of columns:");

        int winCount = retrieveInt("Please enter the number of consecutive items for a valid win:");

        Board b = new Board(rows, cols, winCount);

        for (int i = 0; i < players.length; i++) {
            if (playRound(b, i)) {
                printWinner(i);
                break;
            }
            if (i == players.length-1) {
                i = -1;
            }
        }
    }

    public static void initPlayers(int numPlayers) {
        players = new Player[numPlayers];
        lastItems = new Item[numPlayers];
        int numBots = 0;
        for (int num = 0; num < numPlayers; num++) {
            Player newPlayer = null;
            int option = retrieveInt("Player " + (num+1) + ". Please choose an option:\n[0] Login\n[1] Signup\n[2] Bot");
            if (option == 0) { // do log in process
                newPlayer = login();
            } else if (option == 1) { // do sign up process
                newPlayer = signup(num);
            } else { // create Bot
                newPlayer = newBot(numBots);
            }
            players[num] = newPlayer;
        }
    }

    private static Player login() {
        String email = retrieveString("Enter your email:");
        String password = retrieveString("Enter your password:");
        // database lookup
        return new Player();
    }

    private static Player signup(int playerNum) {
        String firstName = retrieveString("Enter your first name:");
        char symbol = retrieveChar("Enter your symbol:");
        while (symbol == 0) {
            symbol = retrieveChar("Please enter an actual symbol:");
        }
        boolean ok = isNotAssigned(playerNum, symbol);
        while (!ok) {
            output.println("This symbol is already taken. Enter a new one:");
            ok = isNotAssigned(playerNum, symbol);
        }
        String email = retrieveString("Enter your email address:");
        String password = retrieveString("Enter a password:");
        String confirmPassword = retrieveString("Enter the password again:");
        if (!password.equals(confirmPassword)) {
            return null;
        }
        Player p = new Player();
        p.firstName = firstName;
        p.symbol = symbol;
        p.email = email;
        p.password = password;
        p.isBot = false;
        // save p to database
        players[playerNum] = p;
        return p;
    }

    private static Player newBot(int numBots) {
        Player p = new Player();
        p.firstName = "Bot " + (++numBots);
        p.isBot = true;
        String difficulty = retrieveString("Enter the difficulty:");
        PlayerLevel level;
        try {
            level = PlayerLevel.valueOf(difficulty);
        } catch (IllegalArgumentException e) {
            output.println("Using difficulty 'EASY'");
            level = PlayerLevel.EASY;
        }
        p.level = level;
        p.symbol = icons[(int)(Math.random() * icons.length)];
        return p;
    }

    public static boolean playRound(Board b, int idx) {
        Player current = players[idx];
        Item inserted;
        if (current.isBot) {
            inserted = current.playBot(b, lastItems);
        } else {
            int col = retrieveInt("Place your item in a column, " + current.firstName + ":");
            inserted = b.insert(current, col-1);
        }
        while (inserted == null) {
            if (b.isFull()) {
                printTie();
                return false;
            }
            if (current.isBot) {
                inserted = current.playBot(b, lastItems);
            } else {
                int col = retrieveInt("Enter a column which has space:");
                inserted = b.insert(current, col);
            }
        };
        if (current.isBot)
            output.println(current.firstName + " is placing their item in column " + (inserted.col+1));
        lastItems[idx] = inserted;
        printBoard(b);
        return b.isGameOver(inserted);
    }

    public static int retrieveInt(String msg) {
        output.println(msg);
        String line = input.nextLine();
        while (true) {
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException err) {
                output.println("Please enter a valid integer");
                line = input.nextLine();
            }
        }
    }

    public static String retrieveString(String msg) {
        output.println(msg);
        return input.nextLine();
    }

    public static char retrieveChar(String msg) {
        output.println(msg);
        String line = input.nextLine();
        try {
            return line.charAt(0);
        } catch (Exception e){
            return 0;
        }
    }

    private static boolean isNotAssigned(int playerIdx, char c) {
        for (int i = 0; i < players.length; i++) {
            if (i < playerIdx && players[i] != null && players[i].symbol == c) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(Board b) {
        for (int row = 0; row < b.rows; row++) {
            for (int col = 0; col < b.cols; col++) {
                output.print("|" + b.getSymbol(row, col));
            }
            output.print("|\n");
        }
        for (int col = 1; col <= b.cols; col++) {
            output.print("--");
        }
        output.print("|\n");
        for (int col = 1; col <= b.cols; col++) {
            if (col < 10)
                output.print(" " + col);
        }
        output.println();
    }

    public static void printWinner(int playerId) {
        Item lastItem = lastItems[playerId];
        output.println("And the WINNER IS " + players[playerId].firstName.toUpperCase() + "!");
        output.println("The winning item is at row=" + (lastItem.row+1) + ", col=" + (lastItem.col+1) + ".");
    }

    public static void printTie() {
        output.println("TIE!");
    }

}
