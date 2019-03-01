package dndutility;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

//import dndutility.DnDUtility.JTextFieldLimit1;

public class InitPage extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5670431313643209498L;

    
    private UnitInput unitInput;
    private InitTable initTable;
    
    public InitPage() {
    	
    	unitInput = new UnitInput();
    	initTable = new InitTable();
    	
    	this.add(unitInput);
    	this.add(initTable);
    	
        GroupLayout grouplayout = new GroupLayout(this);
        this.setLayout(grouplayout);
        
    grouplayout.setAutoCreateGaps(true);
    grouplayout.setAutoCreateContainerGaps(true);
    
    grouplayout.setHorizontalGroup(
        grouplayout.createSequentialGroup()
            .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(unitInput)
                .addComponent(initTable))                
    );
    grouplayout.setVerticalGroup(
        grouplayout.createSequentialGroup()
            .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(unitInput))
            .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(initTable))
    );
	
	}
    
    public UnitTemplate getUnit() {
    	return this.unitInput.makeUnit();
    }
    
    public void sendUnit(UnitTemplate unit) {
    	this.initTable.addUnit(unit);
    }
	        
          
	        

	
//		@Override
//		public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
//			if (str == null) return;
//	
//			if ((getLength() + str.length()) <= limit) {
//				super.insertString(offset, str, attr);
//			}
//		}
}



