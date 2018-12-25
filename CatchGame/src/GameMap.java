import java.util.Arrays;

public class GameMap {
		
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
	
	void RelocateThing(ThingOnMap Thing, int TargetCoordX, int TargetCoordY) {
		CoordinateValue[Thing.getCoordX()][Thing.getCoordY()] = new EmptyField(0, 0);
		
		if(TargetCoordX < 0) TargetCoordX = 0;
		if(TargetCoordX >= CoordinateValue.length) TargetCoordX = CoordinateValue.length - 1;
		
		if(TargetCoordY < 0) TargetCoordY = 0;
		if(TargetCoordY >= CoordinateValue[0].length) TargetCoordY = CoordinateValue[0].length - 1;		
		
		CoordinateValue[TargetCoordX][TargetCoordY] = Thing;
		Thing.setCoordX(TargetCoordX);
		Thing.setCoordY(TargetCoordY);
		
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
	
	void KillThing(ThingOnMap Thing) {
		CoordinateValue[Thing.getCoordX()][Thing.getCoordY()] = new EmptyField(0, 0);
	}
	
}
