
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

class EmptyField extends ThingOnMap{
	
	EmptyField(int coordX, int coordY) {
		super(coordX, coordY);
		this.Simbol = '·';
		
	}	
}

class Catсher extends ThingOnMap{
	
	protected int PrevDirectionX, PrevDirectionY = 0;	
	protected int Speed = 1;
	
	Catсher(int coordX, int coordY) {
		super(coordX, coordY);
		this.Simbol = '¤';
		
	}	
	
	void Move(int DirectionX, int DirectionY) {
		
		boolean MovementContinuesX = (DirectionX != 0 && DirectionX == PrevDirectionX);
		boolean MovementContinuesY = (DirectionY != 0 && DirectionY == PrevDirectionY);
		
		if(MovementContinuesX || MovementContinuesY) Speed++;
		else Speed = 1;
		
		PrevDirectionX = DirectionX;
		PrevDirectionY = DirectionY;		
		
		for(int i = Speed; i > 0 ; i--) {
			if(DirectionX != 0) CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY);
			if(DirectionY != 0) CatchMap.RelocateThing(this, CoordX, CoordY + DirectionY);
		}
		
		
	}
	
}

class Runaway extends ThingOnMap{
	
	protected int PrevDirectionX, PrevDirectionY = 0;	
	protected int Speed = 1;
	
	Runaway(int coordX, int coordY) {
		super(coordX, coordY);
		this.Simbol = '®';
		
	}	
	
	void Move(int DirectionX, int DirectionY) {
		
		boolean MovementContinuesX = (DirectionX != 0 && DirectionX == PrevDirectionX);
		boolean MovementContinuesY = (DirectionY != 0 && DirectionY == PrevDirectionY);
		
		if(MovementContinuesX || MovementContinuesY) Speed++;
		else Speed = 1;
		
		PrevDirectionX = DirectionX;
		PrevDirectionY = DirectionY;		
		
		for(int i = Speed; i > 0 ; i--) {
			if(DirectionX != 0) CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY);
			if(DirectionY != 0) CatchMap.RelocateThing(this, CoordX, CoordY + DirectionY);
		}
		
		
	}
	
}