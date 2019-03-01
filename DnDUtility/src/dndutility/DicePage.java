package dndutility;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DicePage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7132092453462877243L;
	private JLabel result = new JLabel();
	private JLabel datel = new JLabel("");
	private JTextField mod;


	public DicePage(){
		this.setLayout( new GridLayout(0,2,5,5) );
		result.setText("\nDo Stuff");
        result.setFont(new Font("Arial", Font.ITALIC, 40));
        mod = new JTextField("0");
        Integer[] diceNumbers = new Integer[] {4, 6, 8, 10, 12, 20, 100, 1000};
        for (int sides : diceNumbers) {
        	this.add(new DiceRoller(sides));
		
        }
        
		this.add(result);
        this.add(mod);
        this.add(datel);
        

	}

	
    public void setResult(String diceroll) {
    	result.setText(diceroll);
    	if (diceroll.contains("CRIT")) {
    		result.setForeground(Color.red);
    	}else if(diceroll.contains("FAIL")) {
    		result.setForeground(Color.blue);
    	}else {
    		result.setForeground(Color.black);
    	}
		result.setFont(new Font("Arial", Font.BOLD, 60));
    	DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date dateobj = new Date();
		String date1 = df.format(dateobj);
		datel.setText(date1);
    }
	
	class DiceRoller extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4345502121911874803L;
		
		public DiceRoller(int sides) {
			
			this.setText("D"+sides);
			this.setFont(new Font("Arial", Font.BOLD, 60));
			this.addActionListener( new ActionListener(){
				@SuppressWarnings("unused")
				public void actionPerformed( ActionEvent e){
					if (mod.getText().equals("") ) {
						mod.setText("0");
					} else {
						try {
							Integer.parseInt(mod.getText());
						} catch (Exception n){
							mod.setText("0");
						}
					}
					String rollmodstr = mod.getText();
					int rollmod = Integer.parseInt(rollmodstr);
					int roll = (int)(Math.random()*sides) + 1;
					String diceroll = Integer.toString(roll + rollmod);
					if (sides == 20) {
						if (roll == 20) {
							diceroll = diceroll+" CRIT!";
						}
						if (roll == 1) {
							diceroll = diceroll+" FAIL!";
						}
					}
					setResult(diceroll);
					
					} 
				} );
			
		}

	}
}
