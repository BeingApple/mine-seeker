public enum NeighborCellInfo {
    TOP_LEFT(-1, -1),
    TOP_CENTER(0, -1),
    TOP_RIGHT(1, -1),
    MIDDLE_LEFT(-1, 0),
    MIDDLE_RIGHT(1, 0),
    BOTTOM_LEFT(-1, 1),
    BOTTOM_CENTER(0, 1),
    BOTTOM_RIGHT(1, 1);

    private final int width;
    private final int height;

    NeighborCellInfo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public int getNowWidth(int mineCellWidth) {
        return mineCellWidth + width;
    }
    public int getNowHeight(int mineCellHeight) {
        return mineCellHeight + height;
    }
}
