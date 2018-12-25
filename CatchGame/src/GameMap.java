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
	
}
