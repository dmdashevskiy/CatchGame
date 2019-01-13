import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.Query;

public class GameRuntime {

	public static void main(String[] args){
		
		final int MAP_SIZE = 10;
		final int CACHER_QUANTITY = 2;
		final int RUNAWAY_QUANTITY = 3;
		final int TURNS_QUANTITY = 6;
		
		
		ArrayList<ThingOnMap> EntityList = new ArrayList<ThingOnMap>();
		GameMap CatchMap = new GameMap(MAP_SIZE);		
		
		for (int i = 0; i < CACHER_QUANTITY; i++) EntityList.add(new Catñher(MAP_SIZE));
		for (int i = 0; i < RUNAWAY_QUANTITY; i++) EntityList.add(new Runaway(MAP_SIZE));
		
		for(ThingOnMap  Embarker: EntityList) CatchMap.EmbarkThing(Embarker);		
		CatchMap.ShowOnConsole();
				
		Queue<ThingOnMap> TurnQueue = new ArrayBlockingQueue<>(TURNS_QUANTITY * EntityList.size());
		
		for (int i = 0; i < TURNS_QUANTITY; i++) {
			for(ThingOnMap  Embarker: EntityList) TurnQueue.offer(Embarker); 
		}	
		
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
