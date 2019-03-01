package dndutility;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

public class DiceRoller extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4345502121911874803L;
	
	public DiceRoller(int sides) {
		
		this.setText("D"+sides);
		this.setFont(new Font("Arial", Font.BOLD, 60));
		this.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e){
//				Date dateobj = new Date();
//				String date1 = df.format(dateobj);
//				datel.setText(date1);
//				String rollmodstr = mod.getText();
//				int rollmod = Integer.parseInt(rollmodstr);
				int roll = (int)(Math.random()*sides) + 1;
				String diceroll = Integer.toString(roll);
//				l.setText(diceroll);
//				l.setForeground(Color.black);
//				l.setFont(new Font("Arial", Font.BOLD, 60));
				} 
			} );
		
	}

}
