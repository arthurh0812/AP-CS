public class Board {
    private final Item[][] board;
    public final int rows;
    public final int cols;


    public Item get(int row, int col) {
        return board[row][col];
    }

    public char getSymbol(int row, int col) {
        return board[row][col].display;
    }

    // rows from top to bottom
    // cols from left to right

    private final int winCount;
    public int getWinCount() {
        return winCount;
    }
    private Player winner;
    public Player getWinner() {
        return winner;
    }

    public Board(int rows, int cols, int winCount) {
        board = new Item[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.winCount = winCount;
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Item(null, i, j);
            }
        }
    }

    public Item insert(Player p, int col) {
        Item set = null;
        for (int row = board.length-1; row >= 0; row--) {
            if (board[row][col].player == null) {
                set = new Item(p, row, col);
                board[row][col] = set;
                break;
            }
        }
        return set;
    }

    boolean isGameOver(Item item) {
        if (checkItem(item)) {
            winner = item.player;
            return true;
        }
        return false;
    }

    boolean isFull() {
        for (int col = 0; col < cols; col++) {
            if (board[0][col].player == null) {
                return false;
            }
        }
        return true;
    }

    public int getHighestRow(int col) {
        for (int row = 0; row < rows; row++) {
            if (board[row][col].player != null) {
                return row;
            }
        }
        return -1;
    }

    boolean checkItem(Item i) {
        return checkTopLeftToBottomRight(i) || checkBottomLeftToTopRight(i) || checkColumns(i) || checkRows(i);
    }

    public boolean checkTopLeftToBottomRight(Item i) {
        return (checkTopLeft(i) + checkBottomRight(i)) >= winCount-1;
    }

    public int checkTopLeft(Item i) {
        int matches = 0;
        for (int row = i.row-1, col = i.col-1; isInBounds(row, col) && row > i.row-winCount && col > i.col-winCount; row--) {
            if (board[row][col].player != i.player) {
                break;
            }
            matches++;
            col--;
        }
        return matches;
    }

    public int checkBottomRight(Item i) {
        int matches = 0;
        for (int row = i.row+1, col = i.col+1; isInBounds(row, col) && row < i.row+winCount && col < i.col+winCount; row++) {
            if (board[row][col].player != i.player) {
                break;
            }
            matches++;
            col++;
        }
        return matches;
    }

    public boolean checkBottomLeftToTopRight(Item i) {
       return (checkBottomLeft(i) + checkTopRight(i)) >= winCount-1;
    }

    public int checkBottomLeft(Item i) {
        int matches = 0;
        for (int row = i.row+1, col = i.col-1; isInBounds(row, col) && row < i.row+winCount && col > i.col-winCount; row++) {
            Item curr = board[row][col];
            if (curr.player != i.player) {
                break;
            }
            matches++;
            col--;
        }
        return matches;
    }

    public int checkTopRight(Item i) {
        int matches = 0;
        for (int row = i.row-1, col = i.col+1; isInBounds(row, col) && row > i.row-winCount && col < i.col+winCount; row--) {
            if (board[row][col].player != i.player) {
                break;
            }
            matches++;
            col++;
        }
        return matches;
    }

    public boolean checkColumns(Item i) {
        return (checkColumnsLeft(i) + checkColumnsRight(i)) >= winCount-1;
    }

    public int checkColumnsLeft(Item i) {
        int matches = 0;
        for (int col = i.col-1; isColInBounds(col) && col > i.col-winCount; col--) {
            if (board[i.row][col].player != i.player) {
                break;
            }
            matches++;
        }
        return matches;
    }

    public int checkColumnsRight(Item i) {
        int matches = 0;
        for (int col = i.col+1; isColInBounds(col) && col < i.col+winCount; col++) {
            if (board[i.row][col].player != i.player) {
                break;
            }
            matches++;
        }
        return matches;
    }

    public boolean checkRows(Item i) {
        int matches = 0;
        for (int row = i.row+1; isRowInBounds(row) && row <= i.row+winCount; row++) {
            if (board[row][i.col].player != i.player) {
                break;
            }
            matches++;
        }
        return matches >= winCount-1;
    }

    public Item getMissingTopLeftToBottomRight(Item i, int amount) {
        for (int row = i.row-amount, col = i.col-amount; isInBounds(row, col) && row <= i.row+amount && col <= i.col+amount; row++) {
            int countSame = 0;
            Item missing = null;
            for (int idx = 0; idx <= amount; idx++) {
                if (isInBounds(row+idx, col+idx) && board[row+idx][col+idx].player == i.player)
                    countSame++;
                else if (isInBounds(row+idx, col+idx))
                    missing = board[row+idx][col+idx];
            }
            if (missing != null && countSame == amount) {
                return missing;
            }
        }
        return null;
    }

    public Item getMissingBottomLeftToTopRight(Item i, int amount) {
        for (int row = i.row+amount, col = i.col-amount; isInBounds(row, col) && row >= i.row-amount && col <= i.col+amount; row++) {
            int matches = 0;
            Item missing = null;
            for (int idx = 0; idx <= amount; idx++) {
                if (isInBounds(row-idx, col+idx) && board[row-idx][col+idx].player == i.player)
                    matches++;
                else if (isInBounds(row-idx, col+idx))
                    missing = board[row-idx][col+idx];
            }
            if (missing != null && matches == amount)
                return missing;
        }
        return null;
    }

    public Item getMissingHorizontal(Item i, int amount) {
        for (int col = i.col-amount; isInBounds(i.row, col); col++) {
            int matches = 0;
            Item missing = null;
            for (int idx = 0; idx <= amount; idx++) {
                if (isColInBounds(col+idx) && board[i.row][col+idx].player == i.player)
                    matches++;
                else if (isColInBounds(col+idx))
                    missing = board[i.row][col+idx];
            }
            if (missing != null && matches == amount)
                return missing;
        }
        return null;
    }

    public Item getMissingVertical(Item i, int amount) {
        int matches = 0;
        Item missing = null;
        for (int row = i.row-1; isInBounds(row, i.col) && row < i.row+amount; row++) {
            if (board[row][i.col].player == i.player)
                matches++;
            else
                missing = board[row][i.col];
        }
        if (missing != null && matches == amount)
            return missing;
        return null;
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean isColInBounds(int col) {
        return col >= 0 && col < cols;
    }

    public boolean isRowInBounds(int row) {
        return row >= 0 && row < rows;
    }

    public boolean hasUnderlying(Item i) {
        if (i.row == rows-1) { // last row
            return false;
        }
        return board[i.row+1][i.col].player != null;
    }
}
