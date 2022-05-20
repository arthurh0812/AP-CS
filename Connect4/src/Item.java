public class Item {
    char display;
    Player player;

    int row;
    int col;

    public Item(Player p, int row, int col) {
        if (p == null) {
            display = ' ';
        } else {
            display = p.symbol;
        }
        player = p;
        this.row = row;
        this.col = col;
    }
}
