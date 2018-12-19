
abstract class Command {
	
	static void Execute(String Code, ThingOnMap Thing) {
		
		// looks like digital keyboard
		//		   8			   up
		//		4  5  6	=	left  stand right
		//		   2			   down
		
		if(Code.equals("8")) {
			Thing.Move(-1, 0);			
		}
		
		if(Code.equals("4")) {
			Thing.Move(0, -1);			
		}
		
		if(Code.equals("6")) {
			Thing.Move(0, 1);			
		}
		
		if(Code.equals("2")) {
			Thing.Move(1, 0);			
		}
		
	}	
}
