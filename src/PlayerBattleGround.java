import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PlayerBattleGround {

    private int gridSize;
    private HashMap<GridCell,String> battleGround;
    private int deadShipCount;

    PlayerBattleGround(int gridSize){
        this.gridSize = gridSize;
        this.battleGround = new HashMap<GridCell,String>();
        this.deadShipCount=0;
    }

    public void addActiveBattleShips(List<GridCell> activeBattleShips){
        for(GridCell activeShip:activeBattleShips) {
            //System.out.println("Active Ship:"+activeShip.toString());
            this.battleGround.put(activeShip,BattleShipConstants.activeBattleShip);
        }
    }

    public void addDeadBattleShips(Set<GridCell> deadBattleShips){
        this.deadShipCount=deadBattleShips.size();
        for(GridCell deadShip:deadBattleShips) {
            //System.out.println("Dead Ship:"+deadShip.toString());
            this.battleGround.put(deadShip,BattleShipConstants.deadBattlesShip);
        }
    }

    public void addMissedMissiles(Set<GridCell> missedMissiles){
        for(GridCell missedMissile:missedMissiles) {
            //System.out.println("Missed Missile:"+missedMissile.toString());
            this.battleGround.put(missedMissile,BattleShipConstants.missedMissileShip);
        }
    }

    public void getBattleGround(){
        for(int i=0;i<gridSize;i++){
            for(int j=0;j<gridSize;j++){
              GridCell c = new GridCell(i,j);
              //System.out.println("The Grid is "+c.toString());
                if(this.battleGround.containsKey(new GridCell(i,j))){
                    //System.out.println("CONTAINS");
                    System.out.print(battleGround.get(new GridCell(i,j)));
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }

    public int getDeadShipCount() {
        return deadShipCount;
    }
}
