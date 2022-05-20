package projects;

public class ScrabbleTester {

    public static void main(String[] args) {
        char[][] board = {
            {' ',' ',' ',' ',' ','h','u','z','z','a','h','s',' ',' '},
            {' ',' ',' ',' ',' ','o',' ',' ',' ',' ',' ',' ',' ',' '},
            {'p','e','a','n','u','t',' ',' ',' ','c','h','e','w','y'},
            {'i',' ',' ',' ',' ','d',' ',' ',' ','a',' ',' ','h',' '},
            {'z',' ',' ',' ','c','o','t','t','o','n',' ',' ','a',' '},
            {'z',' ',' ',' ',' ','g',' ','a',' ','d',' ',' ','m',' '},
            {'a','u','t','o','p','s','i','c',' ','y','u','m','m','y'},
            {' ',' ',' ',' ',' ',' ',' ','o',' ',' ',' ',' ','e',' '},
            {' ',' ',' ',' ',' ',' ',' ','s','a','l','t','e','d',' '},
        };

        Scrabble s = new Scrabble(board);

        Word[] list = s.getWordListFromBoard();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if (i < list.length-1)
                System.out.print(", ");
        }
        System.out.println();

        Word w = s.getMostValuableWordFromBoard();
        System.out.println(w);

        double d = s.getAverageWordValueFromBoard();
        System.out.println("avg value: " + d);
    }
}
