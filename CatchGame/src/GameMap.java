import java.util.Arrays;

public class GameMap {
	
	protected char[][] CoordinateValue;

	GameMap(byte Size) {		
		this.CoordinateValue = new char[Size][Size];
		Arrays.fill(this.CoordinateValue, '·');
	}
	
	
	
	
}
