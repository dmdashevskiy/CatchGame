
class ThingOnMap {
	
	protected int CoordX, CoordY, Speed;
	protected GameMap CatchMap;
	protected char Simbol;
	
	
	
	ThingOnMap(int coordX, int coordY, GameMap catchMap) {		
		this.CoordX = coordX;
		this.CoordY = coordY;
		this.CatchMap = catchMap;
	};

	void move(int Direction) {
		
	};
	
}

class Catсher extends ThingOnMap{

	Catсher(int coordX, int coordY, GameMap catchMap) {
		super(coordX, coordY, catchMap);
		this.Simbol = '©';
		CatchMap.CoordinateValue[coordX][coordY] = this.Simbol;
	}

	
	
}