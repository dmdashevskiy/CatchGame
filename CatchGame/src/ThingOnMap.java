import java.util.Random;

class ThingOnMap {
	
	protected int CoordX, CoordY;
	protected GameMap CatchMap;
	protected char Simbol;
	protected boolean CanBeCatch; 
	protected boolean Alive;
	
	
	ThingOnMap(int coordX, int coordY) {		
		this.CoordX = coordX;
		this.CoordY = coordY;		
	};
	
	ThingOnMap(int MapSize) {		
		
		Random RndX, RndY;		
		RndX = new Random();
		RndY = new Random();
		
		this.CoordX = RndX.nextInt(MapSize);
		this.CoordY = RndY.nextInt(MapSize);		
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

	public boolean isCanBeCatch() {
		return CanBeCatch;
	}

	public boolean isAlive() {
		return Alive;
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
		this.Alive = true;
		
	}	
	
	Catсher(int MapSize) {
		super(MapSize);
		this.Simbol = '¤';
		this.Alive = true;
	}

	void Move(int DirectionX, int DirectionY) {
		
		boolean MovementContinuesX = (DirectionX != 0 && DirectionX == PrevDirectionX);
		boolean MovementContinuesY = (DirectionY != 0 && DirectionY == PrevDirectionY);
		
		if(MovementContinuesX || MovementContinuesY) Speed++;
		else Speed = 1;
		
		PrevDirectionX = DirectionX;
		PrevDirectionY = DirectionY;		
		
		for(int i = Speed; i > 0 ; i--) {
			if(DirectionX != 0) if(CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY) == false) break;
			if(DirectionY != 0)  if(CatchMap.RelocateThing(this, CoordX, CoordY + DirectionY) == false) break;			
			
			//search Runaway nearby
			ThingOnMap[] SurroundThings = CatchMap.GetArrayOfSurroundThings(CoordX, CoordY);
			for (int j = 0; j < SurroundThings.length; j++) {
				if(SurroundThings[j].isCanBeCatch()) {
					System.out.println("Попался!");
					//kill Runaway
					CatchMap.EraseThing(SurroundThings[j]);
					SurroundThings[j].Alive = false;
				}
			}
			
		}
		
		
	}
	
}

class Runaway extends ThingOnMap{
	
	protected int PrevDirectionX, PrevDirectionY = 0;	
	protected int Speed = 1;
	
	Runaway(int coordX, int coordY) {
		super(coordX, coordY);
		this.CanBeCatch = true;
		this.Simbol = '®';
		this.Alive = true;
		
	}
	
	Runaway(int MapSize) {
		super(MapSize);
		this.CanBeCatch = true;
		this.Simbol = '®';
		this.Alive = true;
	}
	
	void Move(int DirectionX, int DirectionY) {
		
		boolean MovementContinuesX = (DirectionX != 0 && DirectionX == PrevDirectionX);
		boolean MovementContinuesY = (DirectionY != 0 && DirectionY == PrevDirectionY);
		
		if(MovementContinuesX || MovementContinuesY) Speed++;
		else Speed = 1;
		
		PrevDirectionX = DirectionX;
		PrevDirectionY = DirectionY;		
		
		for(int i = Speed; i > 0 ; i--) {
			if(DirectionX != 0) if(CatchMap.RelocateThing(this, CoordX + DirectionX, CoordY) == false) break;
			if(DirectionY != 0)  if(CatchMap.RelocateThing(this, CoordX, CoordY + DirectionY) == false) break;			
		}
		
		
	}
	
}