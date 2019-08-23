package action;

public class CharInserter {


    private final static int[][] selectionPosition = {{19,23,27},{49,53,57},{79,83,87}};

    private String insertElement(int x, int y, String ch, String board){
        StringBuilder boardWithNewElement = new StringBuilder(board);
        boardWithNewElement.replace(selectionPosition[x][y], selectionPosition[x][y] + 1, ch);
        return  boardWithNewElement.toString();
    }

    public String insertX(int x, int y, String board){
        return insertElement(x,y, "X", board);
    }

    public String insertO(int x, int y, String board){
        return insertElement(x,y, "O", board);
    }
}
