import java.util.Optional;
import java.util.Random;

public class MineField {
    public final static int MINE_COUNT = 10;
    public final static int WIDTH = 10;
    public final static int HEIGHT = 10;

    private final Cell[][] cells = new Cell[WIDTH][HEIGHT];

    public MineField() {
        initCells();
        layMines();
    }

    private void initCell(int width, int height){
        cells[width][height] = new Cell();
    }

    public void initCells(){
        for(int i = 0 ; i < WIDTH; i++){
            for(int j = 0 ; j < HEIGHT; j++) {
                initCell(i, j);
            }
        }
    }

    private Cell getCell(int width, int height) throws IndexOutOfBoundsException {
        return cells[width][height];
    }

    public boolean tryCheckIsMineCell(int width, int height) {
        try {
            return getCell(width, height).isLoadedMine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("지뢰판 범위 밖입니다.");
        }

        return false;
    }

    public void layMines() {
        int mineCount = MINE_COUNT;

        Random random = new Random();
        while(mineCount -- > 0){
            int width = random.nextInt(WIDTH);
            int height = random.nextInt(HEIGHT);

            if(tryCheckIsMineCell(width, height)) {
                mineCount++;
            } else {
                cells[width][height].setLoadedMine(true);
            }
        }
    }

    public Optional<Cell> tryGetCell(int width, int height) {
        Optional<Cell> optionalCell = Optional.empty();
        try {
            optionalCell = Optional.ofNullable(getCell(width, height));
        } catch(IndexOutOfBoundsException e) {
            //System.out.println("지뢰판 범위 밖입니다.");
        }

        return optionalCell;
    }

    public void countNeighborCells(int width, int height) {
        for(NeighborCellInfo neighborCellInfo : NeighborCellInfo.values()) {
            int nowWidth = neighborCellInfo.getNowWidth(width);
            int nowHeight = neighborCellInfo.getNowHeight(height);

            Optional<Cell> optionalNeighborCell = tryGetCell(nowWidth, nowHeight);
            optionalNeighborCell.ifPresent(Cell::addCount);
        }
    }

    public void seekMine(int width, int height) {
        Optional<Cell> optionalCell = tryGetCell(width, height);
        optionalCell.filter(Cell::isLoadedMine).ifPresent(cell -> countNeighborCells(width, height));
    }
}
