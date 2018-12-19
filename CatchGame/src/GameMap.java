import java.util.Arrays;

public class GameMap {
	
	private char[][] CoordinateValue;

	GameMap(int Size) {		
		this.CoordinateValue = new char[Size][Size];
		
		for(int i = 0; i < CoordinateValue.length; i++) {
			Arrays.fill(this.CoordinateValue[i], '·');
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
	
}
