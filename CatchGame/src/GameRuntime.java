import java.util.Scanner;

public class GameRuntime {

	public static void main(String[] args){
		
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Введите размер поля - от 4 до 20");
		String Input = in.nextLine();		
		Integer InputInt;		
		try {
			InputInt = Integer.valueOf(Input);	            
	    }catch (NumberFormatException e) {  
	        System.err.println("Неверный формат ввода!");
	        return;
	    }
		
		int MapSize;
		if(InputInt < 4) MapSize = 4;
		else if(InputInt > 20) MapSize = 20;
		else MapSize = InputInt;	
		
		GameMap CatchMap = new GameMap(MapSize);
		ThingOnMap EntityCatcher = new Catсher(0, 0);
		ThingOnMap EntityRunaway = new Runaway(MapSize - 1, MapSize - 1);
		
		CatchMap.EmbarkThing(EntityCatcher);
		CatchMap.EmbarkThing(EntityRunaway);
		CatchMap.ShowOnConsole();
				
		while (true) {
			
			System.out.println("Ходит ловец");
			Input = in.nextLine();
			Command.Execute(Input, EntityCatcher);						
			CatchMap.ShowOnConsole();
			
			System.out.println("Ходит беглец");
			Input = in.nextLine();
			Command.Execute(Input, EntityRunaway);						
			CatchMap.ShowOnConsole();
			
			if(Input.equals("0")) break;
			
		}		

	}

}
