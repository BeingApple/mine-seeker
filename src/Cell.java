public class Cell {
    private boolean isLoadedMine;
    private int count;

    public Cell() {
        this.isLoadedMine = false;
        this.count = 0;
    }

    public boolean isLoadedMine() {
        return isLoadedMine;
    }

    public void setLoadedMine(boolean loadedMine) {
        isLoadedMine = loadedMine;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count += 1;
    }

    public void subCount() {
        this.count -= 1;
    }
}
