import java.util.ArrayList;
import java.util.List;

public class PlayerMissiles {

    private int missileSize;
    private List<GridCell> missiles;

    PlayerMissiles(int missileSize,List<GridCell> missiles){
        this.missileSize = missileSize;
        this.missiles = new ArrayList<>(missileSize);
        this.missiles.addAll(missiles);
    }

    public List<GridCell> getMissiles() {
        return missiles;
    }

    @Override
    public String toString() {
        return "PlayerMissiles{" +
                "missileSize=" + missileSize +
                ", missiles=" + missiles +
                '}';
    }
}
