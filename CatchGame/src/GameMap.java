import java.util.Arrays;

final public class GameMap {
		
	private ThingOnMap[][] CoordinateValue;
	
	ThingOnMap Empty = new EmptyField(0, 0);
	
	GameMap(int Size) {		
		this.CoordinateValue = new ThingOnMap[Size][Size];
		
		for(int i = 0; i < CoordinateValue.length; i++) {
			Arrays.fill(this.CoordinateValue[i], Empty);
		}
	}
	
	void ShowOnConsole() {
		
		for(int i = 0; i < CoordinateValue.length; i++) {
			for(int j = 0; j < CoordinateValue[i].length; j++) {
				System.out.print(CoordinateValue[i][j].getSimbol() + "  ");
			};
			System.out.println("");
		};
	};
	
	void EmbarkThing(ThingOnMap Thing) {
		CoordinateValue[Thing.getCoordX()][Thing.getCoordY()] = Thing;
		Thing.setCatchMap(this);
	}
	
	boolean RelocateThing(ThingOnMap Thing, int TargetCoordX, int TargetCoordY) {
				
		if(TargetCoordX < 0 
			|| TargetCoordX >= CoordinateValue.length
			|| TargetCoordY < 0
			|| TargetCoordY >= CoordinateValue[0].length
			|| !(CoordinateValue[TargetCoordX][TargetCoordY] instanceof EmptyField)) return false;			
		
		
		CoordinateValue[Thing.getCoordX()][Thing.getCoordY()] = new EmptyField(0, 0);
		CoordinateValue[TargetCoordX][TargetCoordY] = Thing;
		Thing.setCoordX(TargetCoordX);
		Thing.setCoordY(TargetCoordY);
		
		return true;
		
	}
	
	ThingOnMap[] GetArrayOfSurroundThings(int CoordX, int CoordY) {
		
		ThingOnMap[] ThingsArray = new ThingOnMap[8];
		Arrays.fill(ThingsArray, new EmptyField(0, 0));
		int i = 0;
		
		for(int x = -1; x < 2; x++) {
			for(int y = -1; y < 2; y++) {
				if((CoordX + x) <= (CoordinateValue.length - 1)
					&& (CoordX + x) >= 0
					&& (CoordY + y) <= (CoordinateValue[0].length - 1)
					&& (CoordY + y) >= 0
					&& (x != 0 | y != 0)) ThingsArray[i++] = CoordinateValue[CoordX + x][CoordY + y];
			}
		}
		
		return ThingsArray;		
	}	
	
	void EraseThing(ThingOnMap Thing) {
		CoordinateValue[Thing.getCoordX()][Thing.getCoordY()] = new EmptyField(0, 0);
	}
	
}
