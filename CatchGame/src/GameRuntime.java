import java.util.Scanner;

public class GameRuntime {

	public static void main(String[] args){
		
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("������� ������ ���� - �� 4 �� 20");
		String Input = in.nextLine();		
		Integer InputInt;		
		try {
			InputInt = Integer.valueOf(Input);	            
	    }catch (NumberFormatException e) {  
	        System.err.println("�������� ������ �����!");
	        return;
	    }
		
		int MapSize;
		if(InputInt < 4) MapSize = 4;
		else if(InputInt > 20) MapSize = 20;
		else MapSize = InputInt;	
		
		GameMap CatchMap = new GameMap(MapSize);
		ThingOnMap EntityCatcherP1 = new Cat�her(0, 0);
//		ThingOnMap EntityCatcherP2 = new Cat�her(MapSize - 1, MapSize - 1);
		
		CatchMap.EmbarkThing(EntityCatcherP1);
//		CatchMap.EmbarkThing(EntityCatcherP2);
		CatchMap.ShowOnConsole();
		
		
		
		while (true) {
			
			Input = in.nextLine();
			Command.Execute(Input, EntityCatcherP1);						
			CatchMap.ShowOnConsole();
			
//			Input = in.nextLine();
//			Command.Execute(Input, EntityCatcherP2);						
//			CatchMap.ShowOnConsole();
			
			if(Input.equals("0")) break;
			
		}		

	}

}
