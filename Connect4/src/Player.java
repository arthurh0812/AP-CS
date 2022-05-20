public class Player {
    String firstName;
    String email;
    String password;

    char symbol;
    // if player is computer
    boolean isBot;
    PlayerLevel level;

    // only for bots
    Item lastItem = null;

    public Item playBot(Board b, Item[] lastItems) {
        int col = calcCol(b, lastItems);
        if (col == -1) {
            return null;
        }
        Item inserted = b.insert(this, col);
        lastItem = inserted;
        return inserted;
    }

    // for bots only
    public int calcCol(Board b, Item[] lastItems) {
        if (level == PlayerLevel.EASY) {
            return random(b);
        } else if (level == PlayerLevel.NORMAL) {
            // 1. win prevention
            for (Item i : lastItems) {
                if (i == null)
                    continue;
                int col = preventWin(b, i);
                if (col == -1)
                    continue;
                return col;
            }
            // 2. offensive column respecting most recently set item by bot itself
            if (lastItem == null)
                return random(b);
            return offend(b, lastItem);
        } else { // level = DIFFICULT
            // 1. win prevention
            for (Item i : lastItems) {
                if (i == null) {
                    continue;
                }
                int col = offend(b, i);
                if (col == -1) {
                    continue;
                }
                return col;
            }
            // 2. offensive column respecting most recenly set item by bot itself
            int col = offend(b, lastItem);
            if (col == -1)
                return strategy(b, lastItem);
            return col;
        }
    }

    private int random(Board b) {
        return (int)(Math.random() * b.cols);
    }

    private int preventWin(Board b, Item lastItem) {
        int winCount = b.getWinCount(), range = winCount-1;
        Item toInsert = b.getMissingTopLeftToBottomRight(lastItem, range);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        toInsert = b.getMissingBottomLeftToTopRight(lastItem, range);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        toInsert = b.getMissingHorizontal(lastItem, range);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        toInsert = b.getMissingVertical(lastItem, range);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        return -1;
    }

    private int offend(Board b, Item lastItem) {
        Item toInsert = b.getMissingTopLeftToBottomRight(lastItem, 1);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        toInsert = b.getMissingBottomLeftToTopRight(lastItem, 1);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        toInsert = b.getMissingHorizontal(lastItem, 1);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        toInsert = b.getMissingVertical(lastItem, 1);
        if (toInsert != null && b.hasUnderlying(toInsert))
            return toInsert.col;
        return -1;
    }

    private int strategy(Board b, Item lastItem) {
        // to do
        return random(b);
    }
}
