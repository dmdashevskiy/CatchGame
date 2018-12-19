import java.util.Scanner;

public class GameRuntime {

	public static void main(String[] args){
		
		GameMap CatchMap = new GameMap(10);
		ThingOnMap EntityCatcher = new Catñher(0, 0);
		
		CatchMap.EmbarkThing(EntityCatcher);		
		CatchMap.ShowOnConsole();
		
		Scanner in = new Scanner(System.in);
		
		while (true) {
			
			String Input = in.nextLine();
			Command.Execute(Input, EntityCatcher);			
			
			CatchMap.ShowOnConsole();
			
			if(Input.equals("0")) break;
			
		}		

	}

}
