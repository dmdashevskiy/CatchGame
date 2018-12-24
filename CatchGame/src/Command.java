
abstract class Command {
	
	static void Execute(String Code, ThingOnMap Thing) {
		

		//up
		if(Code.equals("8")) {
			Thing.Move(-1, 0);			
		}
		
		//left
		if(Code.equals("4")) {
			Thing.Move(0, -1);			
		}
		
		//right
		if(Code.equals("6")) {
			Thing.Move(0, 1);			
		}
		
		//down
		if(Code.equals("2")) {
			Thing.Move(1, 0);			
		}
		
		//stop
		if(Code.equals("5")) {
			Thing.Move(0, 0);			
		}
		
	}	
}
