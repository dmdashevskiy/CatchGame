import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.Query;

public class GameRuntime {

	public static void main(String[] args){
		
		final int MAP_SIZE = 8;
						
		GameMap CatchMap = new GameMap(MAP_SIZE);
		ThingOnMap EntityCatcher = new Catñher(0, 0);
		ThingOnMap EntityRunaway = new Runaway(MAP_SIZE - 1, MAP_SIZE - 1);
		
		CatchMap.EmbarkThing(EntityCatcher);
		CatchMap.EmbarkThing(EntityRunaway);
		CatchMap.ShowOnConsole();
		
		Queue<ThingOnMap> TurnQueue = new ArrayBlockingQueue<>(20);
		
		while (TurnQueue.offer(EntityCatcher) & TurnQueue.offer(EntityRunaway));		
		
		Scanner in = new Scanner(System.in);
		String Input;
		
		ThingOnMap Walker = TurnQueue.poll();
				
		while (Walker != null) {
			
			if(Walker.isAlive()) {
			Input = in.nextLine();
			Command.Execute(Input, Walker);						
			CatchMap.ShowOnConsole();			
			if(Input.equals("0")) break;
			}
			
			Walker = TurnQueue.poll();		
			
		}		

	}

}
