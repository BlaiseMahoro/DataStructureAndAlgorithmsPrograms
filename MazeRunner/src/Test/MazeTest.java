package Test;


import mazePD.*;
import mazePD.Maze.MazeMode;

public class MazeTest{
	public static void test1(int mazeDim, int mazeDepth,MazeMode mode) {
		
		Maze maze=new Maze(mazeDim,mazeDepth,mode);
		System.out.println("Maze-"+maze.toString());
		for (int z=0;z<mazeDepth;z++)
		{
			System.out.println("Level - "+z );
			String[] mazeArray = maze.toStringLevel(z);
			for (int y=0;y<10;y++) 	
				//System.out.println("hi");
				System.out.println(mazeArray[y]);
		}
		Droid droid= new Droid("Blaise",maze);
		droid.run();
		
		

		
	}

}
