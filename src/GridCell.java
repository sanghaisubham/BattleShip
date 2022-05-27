import java.util.Objects;

public class GridCell {

    int posX;
    int posY;

    public GridCell(int posX, int posY){
        this.posX=posX;
        this.posY=posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCell gridCell = (GridCell) o;
        return posX == gridCell.posX && posY == gridCell.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

    @Override
    public String toString() {
        return "GridCell{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
