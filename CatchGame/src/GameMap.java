import java.util.Arrays;

public class GameMap {
	
	final char EMPTY_FIELD = '·';
	
	private char[][] CoordinateValue;

	GameMap(int Size) {		
		this.CoordinateValue = new char[Size][Size];
		
		for(int i = 0; i < CoordinateValue.length; i++) {
			Arrays.fill(this.CoordinateValue[i], EMPTY_FIELD);
		}
	}
	
	void ShowOnConsole() {
		
		for(int i = 0; i < CoordinateValue.length; i++) {
			for(int j = 0; j < CoordinateValue[i].length; j++) {
				System.out.print(CoordinateValue[i][j] + "  ");
			};
			System.out.println("");
		};
	};
	
	void EmbarkThing(ThingOnMap Thing) {
		CoordinateValue[Thing.getCoordX()][Thing.getCoordY()] = Thing.getSimbol();
		Thing.setCatchMap(this);
	}
	
	void RelocateThing(ThingOnMap Thing, int TargetCoordX, int TargetCoordY) {
		CoordinateValue[Thing.getCoordX()][Thing.getCoordY()] = EMPTY_FIELD;
		
		if(TargetCoordX < 0) TargetCoordX = 0;
		if(TargetCoordX >= CoordinateValue.length) TargetCoordX = CoordinateValue.length - 1;
		
		if(TargetCoordY < 0) TargetCoordY = 0;
		if(TargetCoordY >= CoordinateValue[0].length) TargetCoordY = CoordinateValue[0].length - 1;		
		
		CoordinateValue[TargetCoordX][TargetCoordY] = Thing.getSimbol();
		Thing.setCoordX(TargetCoordX);
		Thing.setCoordY(TargetCoordY);
		
	}
	
}
