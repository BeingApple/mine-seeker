import java.util.Optional;

public class MineSeeker {
    private final MineField mineField;

    public MineSeeker() {
        this.mineField = new MineField();
    }

    public void seekMines() {
        for(int i = 0 ; i < MineField.WIDTH; i++){
            for(int j = 0 ; j < MineField.HEIGHT; j++) {
                mineField.seekMine(i, j);
            }
        }
    }

    public void printCell(Cell cell) {
        if(cell.isLoadedMine()) {
            System.out.print(ColorCode.ANSI_RED+" X "+ColorCode.ANSI_RESET);
        } else {
            int count = cell.getCount();

            if(count > 0) {
                System.out.print(ColorCode.ANSI_BLUE+" " + cell.getCount() + " "+ColorCode.ANSI_RESET);
            } else {
                System.out.print(" " + cell.getCount() + " ");
            }
        }
    }

    public void printField() {
        for(int i = 0 ; i < MineField.WIDTH; i++){
            for(int j = 0 ; j < MineField.HEIGHT; j++) {
                Optional<Cell> optionalCell = mineField.tryGetCell(i, j);
                optionalCell.ifPresent(this::printCell);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MineSeeker mineSeeker = new MineSeeker();
        mineSeeker.seekMines();
        mineSeeker.printField();
    }
}
