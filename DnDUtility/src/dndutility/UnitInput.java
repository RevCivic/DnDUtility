package dndutility;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnitInput extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 366397309340533430L;
	private UnitValues initmod, health, ac, ref, fort, will, atk, dmgW, dmgM, exp;
	private JTextField unit;
	private JComboBox<String> dmgD;
	private JCheckBox monster;
	private String[] dice = {"d4","d6","d8","d10","d12","d20"};
	
	public UnitInput() {
	    JLabel initmodlb, unitlb, healthlb, aclb, reflb, fortlb, willlb, atklb, dmglb, monsterlb, explb;
	    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
	    DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
	    decimalFormat.setGroupingUsed(false);
	    initmodlb = new JLabel("Init Mod");
	    initmod = new UnitValues(decimalFormat);
	    unitlb = new JLabel("Unit");
	    unit = new JTextField(15);
	    healthlb = new JLabel("HP");
	    health = new UnitValues(decimalFormat);
	    aclb = new JLabel("Armor Class");
	    ac = new UnitValues(decimalFormat);
	    reflb = new JLabel("Reflex");
	    ref = new UnitValues(decimalFormat);
	    fortlb = new JLabel("Fortification");
	    fort = new UnitValues(decimalFormat);
	    willlb = new JLabel("Will");
	    will = new UnitValues(decimalFormat);
	    atklb = new JLabel("Attack");
	    atk = new UnitValues(decimalFormat);
	    atk.setText("0");
	    dmglb = new JLabel("Damage");
	    dmgW = new UnitValues(decimalFormat);
	    dmgW.setText("1");
	    dmgD = new JComboBox<String>(dice);
	    dmgM = new UnitValues(decimalFormat);
	    dmgM.setText("0");
	    monsterlb = new JLabel("Monster/Enemy?");
	    monster = new JCheckBox();
	    explb = new JLabel("Exp Worth/Total");
	    exp = new UnitValues(decimalFormat);
	    exp.setText("0");
	    
	    
	    
	    this.add(initmodlb);
	    this.add(initmod);
	    this.add(unitlb);
	    this.add(unit);
	    this.add(healthlb);
	    this.add(health);
	    this.add(aclb);
	    this.add(ac);
	    this.add(reflb);
	    this.add(ref);
	    this.add(fortlb);
	    this.add(fort);
	    this.add(willlb);
	    this.add(will);
	    this.add(atklb);
	    this.add(atk);
	    this.add(dmglb);
	    this.add(dmgW);
	    this.add(dmgD);
	    this.add(dmgM);
	    this.add(monsterlb);
	    this.add(monster);
	    this.add(explb);
	    this.add(exp);
	    
	    GroupLayout grouplayout = new GroupLayout(this);
        this.setLayout(grouplayout);
        
      grouplayout.setAutoCreateGaps(true);
      grouplayout.setAutoCreateContainerGaps(true);
    
      grouplayout.setHorizontalGroup(
    		  grouplayout.createSequentialGroup()
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.CENTER)
    				  .addComponent(initmodlb)
    				  .addComponent(unitlb)                                    
    				  .addComponent(healthlb)
    				  .addComponent(aclb)
    				  .addComponent(reflb)
    				  .addComponent(fortlb)
    				  .addComponent(willlb)
    				  .addComponent(atklb)
    				  .addComponent(dmglb)
    				  .addGroup(grouplayout.createSequentialGroup()
    						  .addComponent(monsterlb)
    						  .addComponent(monster)))
			  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					  .addComponent(initmod)
					  .addComponent(unit)                                    
					  .addComponent(health)                                   
					  .addComponent(ac)                                    
					  .addComponent(ref)                                  
					  .addComponent(fort)                                    
					  .addComponent(will)                                    
					  .addComponent(atk)  
					  .addGroup(grouplayout.createSequentialGroup()
							  .addComponent(dmgW)                  
							  .addComponent(dmgD)
							  .addComponent(dmgM))
					  .addGroup(grouplayout.createSequentialGroup()
							  .addComponent(explb)
							  .addComponent(exp)))
    		  );
      grouplayout.setVerticalGroup(
    		  grouplayout.createSequentialGroup()
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(initmodlb)
    				  .addComponent(initmod))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(unitlb)
    				  .addComponent(unit))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(healthlb)
    				  .addComponent(health))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(aclb)
    				  .addComponent(ac))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(reflb)
    				  .addComponent(ref))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(fortlb)
    				  .addComponent(fort))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(willlb)
    				  .addComponent(will))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(atklb)
    				  .addComponent(atk))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(dmglb)
    				  .addComponent(dmgW)
    				  .addComponent(dmgD)
    				  .addComponent(dmgM))
    		  .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				  .addComponent(monsterlb)
    				  .addComponent(monster)
    				  .addComponent(explb)
    				  .addComponent(exp))
    		  );         
		}
	public UnitTemplate makeUnit() {
		if(initmod.getText().trim().isEmpty() || dmgW.getText().trim().isEmpty() || dmgM.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Required Parameters are Missing");
		}else {
			if(monster.isSelected()) {
				return new Enemy(initmod.getStatValue(), unit.getText(), health.getStatValue(), ac.getStatValue(), ref.getStatValue(), fort.getStatValue(), will.getStatValue(), atk.getStatValue(), (int) dmgW.getStatValue(), (String) dmgD.getSelectedItem(), (int) dmgM.getStatValue(), (int) exp.getStatValue());
			} else {
				return new Character(initmod.getStatValue(), unit.getText(), health.getStatValue(), ac.getStatValue(), ref.getStatValue(), fort.getStatValue(), will.getStatValue(), atk.getStatValue(), (int) dmgW.getStatValue(), (String) dmgD.getSelectedItem(), (int) dmgM.getStatValue(), (int) exp.getStatValue());
			}
		}
		return null;
	}
	
	
	
	private class UnitValues extends JFormattedTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8901147863152228187L;
		public UnitValues(DecimalFormat decimalFormat) {
			super(decimalFormat);
		}
		public int getStatValue() {
			return Integer.parseInt(this.getText());
		}
	}

}

