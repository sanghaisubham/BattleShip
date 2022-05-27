import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class PlayerBattleShips {

    private int shipSize;
    private HashMap<GridCell,Boolean> battleShips;

    PlayerBattleShips(int shipSize,List<GridCell> battleShips){
        this.shipSize = shipSize;
        this.battleShips = new HashMap<GridCell,Boolean>();
        for(GridCell battleShip:battleShips){
            this.battleShips.put(battleShip,true);
        }
    }

    public HashMap<GridCell, Boolean> getBattleShips() {
        return battleShips;
    }

    public void getBattleGround(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                GridCell c = new GridCell(i,j);
                //System.out.println("The Grid is "+c.toString());
                if(this.battleShips.containsKey(new GridCell(i,j))){
                    System.out.print("B");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
