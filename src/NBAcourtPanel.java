import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NBAcourtPanel extends JPanel{
	
	private NBATeam team;
	
	public NBAcourtPanel(NBATeam team) {
		setBackground(Color.ORANGE);
		setPreferredSize(new Dimension(300,200));
		this.team=team;
		
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x=0, y=0, width=300, height=200;
		g.setColor(Color.red);
		g.fillOval(250, 75, 150, 150);
		g.setColor(Color.white);
		g.drawLine(325, 0, 325, 400);
		g.drawOval(-150, 40, 300, 250);
		g.drawOval(520, 40, 305, 250);
		g.setColor(Color.BLACK);
		Font stringFont = new Font("SansSerif",Font.BOLD, 18);
		g.setFont(stringFont);
		
		int px = 550;
		int py = 125;
		for(int i=0;i<team.getNumOfPlayer();i++) {
			g.drawString(team.getPlayerName(i), px, py);
			py+=25;
		}
	}
}
