import java.util.ArrayList;
import java.util.List;

public class PlayerMissileTest {

    public static void main(String []args){
        GridCell gridCell = new GridCell(0,0);
        List<GridCell> gridCells =new ArrayList<>();
        gridCells.add(gridCell);
        PlayerMissiles playerMissiles = new PlayerMissiles(1,gridCells);
        assert (playerMissiles.getMissiles().get(0).equals(gridCell));
    }
}
