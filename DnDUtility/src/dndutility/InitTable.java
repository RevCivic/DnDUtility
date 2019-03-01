package dndutility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class InitTable extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9093385614671771045L;
	
	private int rndcnt;
	private JTable init;
	private DefaultTableModel model;

	public InitTable() {
		
	    JLabel round;
	    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
	    DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
	    decimalFormat.setGroupingUsed(false);
	    round = new JLabel("Round: "+String.valueOf(rndcnt));
	    round.setForeground(Color.GREEN);
	    round.setFont(new Font("Arial", Font.BOLD, 30));
	    model = new DefaultTableModel(0,0);
	    String columns[] = new String []{"Init","Unit", "Health", "AC", "REF", "FORT", "WILL", "ATK", "DMG"};
	    model.setColumnIdentifiers(columns);
	    init = new JTable(model);
	    JScrollPane tracker = new JScrollPane(init);
	    init.setAutoCreateRowSorter(true);
	    TableCellRenderer intrend = new TableCellRenderer() {
	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row1, int column) {
	            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	        }
	    };
	    init.setDefaultRenderer(Number.class, intrend);
	    JButton addrow = new JButton("Add");
	    JButton startinit = new JButton("Start");
	    JButton rmunit = new JButton("Remove Unit");
	    JButton rstcounter = new JButton("Reset Counter");
	    
	    this.add(round);
	    this.add(rstcounter);
	    this.add(tracker);
	    this.add(addrow);
	    this.add(startinit);
	    this.add(rmunit);
	    
        GroupLayout grouplayout = new GroupLayout(this);
        this.setLayout(grouplayout);
        
    grouplayout.setAutoCreateGaps(true);
    grouplayout.setAutoCreateContainerGaps(true);
    
    grouplayout.setHorizontalGroup(
        grouplayout.createSequentialGroup()
            .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(round)
                .addComponent(rstcounter))                
            .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(tracker)
            .addGroup(grouplayout.createSequentialGroup()
                .addComponent(addrow)
            .addGroup(grouplayout.createSequentialGroup()
                .addComponent(startinit)
            .addGroup(grouplayout.createSequentialGroup()
                .addComponent(rmunit)))))
    );
    grouplayout.setVerticalGroup(
        grouplayout.createSequentialGroup()
            .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tracker)
                .addGroup(grouplayout.createSequentialGroup()
                    .addComponent(round)
                    .addComponent(rstcounter)))
            .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(addrow)
                .addComponent(startinit)
                .addComponent(rmunit))
    );
	            
	//                    initroll.setText("");
    
	addrow.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Component component = (Component) e.getSource();
			DnDUtility frame = (DnDUtility) SwingUtilities.getRoot(component);
			frame.storeUnit();
		}
	});
	    
	startinit.addActionListener(new ActionListener(){
		private int row;                    
		public void actionPerformed(ActionEvent e){
			int rowcount = init.getRowCount();
			init.changeSelection(row, row, false, false);
			startinit.setText("Next");
	            
			if(row >= rowcount){
				row = 0;
				rndcnt++;
				round.setText("Round: "+String.valueOf(rndcnt));
			} else {
				row++;
			}
			if(rowcount == 0){
				startinit.setText("Start");
				row = 0;
			}
			
		}
	});
	    
	
	    
	rstcounter.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			rndcnt = 0;
			round.setText("Round: "+String.valueOf(rndcnt));
		}
	});
	    
	rmunit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
			int[] lines = init.getSelectedRows();
			if(lines.length==0) {
				for(int i=0; i<lines.length; i++) {
					lines[i]=init.convertRowIndexToModel(lines[i]);
				}
			}
			Arrays.sort(lines);
			for(int i=lines.length-1; i>=0; i--) {
				model.removeRow(lines[i]);    //NEED TRY-CATCH for i = nothing!
			}
	
		}
	});
	
	init.addMouseListener(new java.awt.event.MouseAdapter(){
		public void mouseClicked(MouseEvent e) {
			int row = init.getSelectedRow();
			int col = init.getSelectedColumn();
			String atkstr;
			String[] atkarr;
			int weapon, roll, mod, dmg, diceroll, ii, atk, hp;
			ii = 1;
			dmg = 0;
			if(col == 8){
				atkstr = (String) init.getModel().getValueAt(row,col);
				atkarr = atkstr.split("d|\\+");
				weapon = Integer.parseInt((String)Array.get(atkarr,0));
				roll = Integer.parseInt((String)Array.get(atkarr,1));
				mod = Integer.parseInt((String)Array.get(atkarr,2));
				if(weapon > 1){
					do{
						diceroll = (int) (Math.random()*roll)+1;
						dmg = diceroll+dmg;
						ii++;
					}while(ii <= weapon);
				}else{
					dmg = (int) (Math.random()*roll)+1;
				}
				dmg = dmg+mod;
				JOptionPane.showMessageDialog(null, "Damage: "+dmg);                            
			}else if(col == 7){
				mod = (int) init.getModel().getValueAt(row, col);
				atk = (int)(Math.random()*20)+1+mod;
				JOptionPane.showMessageDialog(null, atk);
			}else if(col == 2){
				hp = Integer.parseInt((String)init.getModel().getValueAt(row, col));
				String hpmessage = "Use a negative(-) to subtract health, Otherwise it will heal.";
				mod = Integer.parseInt((String)getStringInput(hpmessage));
				hp = hp+mod;
				String strhp = "" + hp;
				init.getModel().setValueAt(strhp, row, col);
			}
	            
		}
	});
	
}
	
	private static String getStringInput(String prompt){
    	
    	int count = 0;
    	String input;
    	input = JOptionPane.showInputDialog( prompt);
    	while ((input != null && input.length() == 0 ) && (count <2)){
    		input = JOptionPane.showInputDialog("Empty Feild. Please enter the required information. \n" + prompt);
    		count++;
    	}	
    	if (count==2){
    		JOptionPane.showMessageDialog(null,  "Incomplete entry. Please try again.");
    		System.exit(0);
    	}
    	return input;
    }  
	public void addUnit(UnitTemplate unit) {
		model.addRow(unit.addRow());
	}

}
