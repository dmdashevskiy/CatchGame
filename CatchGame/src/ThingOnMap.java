
class ThingOnMap {
	
	protected int CoordX, CoordY;
	protected GameMap CatchMap;
	protected char Simbol;
	
	
	
	ThingOnMap(int coordX, int coordY) {		
		this.CoordX = coordX;
		this.CoordY = coordY;		
	};

	void Move(int DirectionX, int DirectionY) {
		CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY + DirectionY);		
	}

	public int getCoordX() {
		return CoordX;
	}

	public int getCoordY() {
		return CoordY;
	}
		
	public char getSimbol() {
		return Simbol;
	}

	public void setCatchMap(GameMap catchMap) {
		CatchMap = catchMap;
	}

	public void setCoordX(int coordX) {
		CoordX = coordX;
	}

	public void setCoordY(int coordY) {
		CoordY = coordY;
	}
	
	
}

class Catсher extends ThingOnMap{
	
	protected int Speed, PrevDirectionX, PrevDirectionY = 0;	
	
	Catсher(int coordX, int coordY) {
		super(coordX, coordY);
		this.Simbol = '©';
		
	}	
	
	void Move(int DirectionX, int DirectionY) {
		
		if((DirectionX != 0 && DirectionX == PrevDirectionX) || (DirectionY != 0 && DirectionY == PrevDirectionY)) Speed++;
		else Speed = 0;
		
		PrevDirectionX = DirectionX;
		PrevDirectionY = DirectionY;		
		
		if(DirectionX > 0 && DirectionX == PrevDirectionX)	CatchMap.RelocateThing(this, CoordX + DirectionX + Speed, CoordY + DirectionY);
		else if(DirectionY > 0 && DirectionY == PrevDirectionY)	CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY + DirectionY + Speed);
		else if(DirectionX < 0 && DirectionX == PrevDirectionX)	CatchMap.RelocateThing(this, CoordX + DirectionX - Speed, CoordY + DirectionY);
		else if(DirectionY < 0 && DirectionY == PrevDirectionY)	CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY + DirectionY - Speed);
		else CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY + DirectionY);
		
	}
	
}