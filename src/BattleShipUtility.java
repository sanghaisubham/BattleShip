import kotlin.Pair;

import java.util.*;

public class BattleShipUtility {

    public  List<GridCell> parseInputPositions(String inputText){
        List<GridCell> gridCells = new ArrayList<>();
        List<String> gridValues= List.of(inputText.split(BattleShipConstants.gridValueDelimiter));

        for(String gridValue:gridValues){
            List<String> gridPos = List.of(gridValue.split(BattleShipConstants.gridPosDelimiter));
            GridCell gridCell = new GridCell(convertToInt(gridPos.get(0)),convertToInt(gridPos.get(1)));
            gridCells.add(gridCell);
        }
        return gridCells;
    }

    public Pair<Set<GridCell>,Set<GridCell>> getBattleResult(PlayerBattleShips defenderShips,PlayerMissiles attackerMissiles){
        Set<GridCell> deadBattleShips=new HashSet<GridCell>();
        Set<GridCell> missedMissiles=new HashSet<GridCell>();
        HashMap<GridCell,Boolean> player1Ships = defenderShips.getBattleShips();
        List<GridCell> playerMissiles = attackerMissiles.getMissiles();
        for(GridCell playerMissile:playerMissiles){
            //System.out.println("Player Missile :"+playerMissile.toString());
           if(player1Ships.containsKey(playerMissile)){
               deadBattleShips.add(playerMissile);
           }
           else{
               missedMissiles.add(playerMissile);
           }
        }
        return new Pair(deadBattleShips,missedMissiles);
    }

    private int convertToInt(String value){
        return Integer.parseInt(value);
    }
}
