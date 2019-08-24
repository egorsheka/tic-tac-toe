package action;

public class GameLogic {
    private int[] values;

    public GameLogic() {
        this.values = new int[9];
    }

    public void setGameBoardValue(int position, int value) {
        if (value == 1 || value == 2 && position >= 0 && position < 9) {
            values[position] = value;
        }
    }

    public boolean isEndOfGame() {
        return searchByDiagonal() || searchByHorizontally() ||
                searchByReverseDiagonal() || searchByVertically();
    }


    private boolean searchByDiagonal() {
        for (int i = 0; i < values.length - 4; i += 4) {
            if (!(values[i] == values[i + 4] && values[i] != 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean searchByReverseDiagonal() {
        for (int i = 2; i < values.length - 4; i += 2) {
            if (!(values[i] == values[i + 2] && values[i] != 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean searchByHorizontally() {
        boolean isWin;
        for (int i = 0; i < values.length - 2; i += 3) {
            isWin = true;
            for (int j = i; j < i + 2; ++j) {
                if (!(values[j] == values[j + 1] && values[i] != 0)) {
                    isWin = false;
                }
            }
            if(isWin){
                return true;
            }
        }
        return false;
    }

    private boolean searchByVertically() {
        boolean isWin;
        for (int i = 0; i < 3; ++i) {
            isWin = true;
            for (int j = i; j < values.length - 3 ; j += 3) {
                if (!(values[j] == values[j + 3] && values[i] != 0)) {
                    isWin = false;
                }
            }
            if(isWin){
                return true;
            }
        }
        return false;
    }
}
