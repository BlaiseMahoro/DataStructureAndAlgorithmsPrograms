package PD;
/**
 * displays moves to make to solve the Hanoi Tower game
 * @author Blaise Mahoro
 *
 */
public class Hanoi {
	/**
	 * 
	 * @param num: number of disks
	 * @param start: starting peg
	 * @param end: destination peg
	 * @param tempStor: temporary peg
	 */
	public static void move(int num, char start, char end, char tempStor) {
		if(num>0) {
			move(num-1,start,tempStor, end);//subproblem 1: move n-1 disks to a temporary storage peg
			
			System.out.println("Move " +num +" from "+start+" to " +end);
			//move nth disk to the destination peg 
			
			move(num-1,tempStor, end, start);//move the n-1 disks to the destination peg on top of nth disk
		}
		
	}
	

}
