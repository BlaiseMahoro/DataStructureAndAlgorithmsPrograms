package UI;

import javax.swing.JPanel;

import mazePD.Cell;
import mazePD.Droid;
import mazePD.Maze.Content;

import java.awt.Color;
import java.awt.GridLayout;

public class GridPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GridPanel(Droid droid, int displayLevel) {
		this.setBounds(213, 0, 400, 400);
		setLayout(new GridLayout(droid.getMazeDim(), droid.getMazeDim(), 10, 10));
		
		Cell[][] floor = droid.getCells()[displayLevel];
		
		for(int y=0;y<droid.getMazeDim();y++) {
			for(int x=0; x<droid.getMazeDim();x++) {
				Cell cell=floor[x][y];
				JPanel panel = new JPanel();
				panel.setBackground(Color.RED);
				if(cell!=null&&cell.getCellContent()!=null)
				{
					if(cell.getCellContent()==Content.END)
						panel.setBackground(Color.GREEN);
					else if(cell.isGenVisit()&&droid.isOnPath(cell))
							panel.setBackground(Color.ORANGE);
					 else if(cell.getCellContent()==Content.BLOCK)
						panel.setBackground(Color.BLACK);
					else if(cell.getCellContent()==Content.EMPTY)
						panel.setBackground(Color.WHITE);
					
					
				}
				
				this.add(panel);
			}
		}
		
	}
}
