package dndutility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotesPage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7321559781263057122L;
	private FileWriter fileWriter;
	private File file;
	private JTextArea textarea;
	private JTextArea olddata;
	
	public NotesPage() {

		JLabel notelb = new JLabel("Notes: ");
		JButton save = new JButton("Save");
		save.setText("Save");
		textarea = new JTextArea(10,40);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		olddata = new JTextArea(25,45);
		olddata.setEditable(false);
		olddata.setLineWrap(true);
		olddata.setWrapStyleWord(true);
		JScrollPane scrollV = new JScrollPane(olddata, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		try {
			setFile();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File notes = new File("C://CharacterNotes/Notes.txt");

		this.add(notelb);
		this.add(textarea);
		this.add(scrollV);
		this.add(save);
    
		if(notes.length() == 0){
			FileWriter fileWriter = null;
			try { 
				fileWriter = new FileWriter(notes, true);
				fileWriter.append(" ");
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException ex) {
				Logger.getLogger(DnDUtility.class.getName()).log(Level.SEVERE, null, ex);
			}
		};
		
		save.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e){
				updateNotes();
			}
		});
    
		GroupLayout grouplayout = new GroupLayout(this);
		this.setLayout(grouplayout);
            
		grouplayout.setAutoCreateGaps(true);
		grouplayout.setAutoCreateContainerGaps(true);
        
		grouplayout.setHorizontalGroup(
    		grouplayout.createSequentialGroup()
    		.addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.CENTER)
    				.addComponent(notelb) 
    				.addComponent(scrollV) 
    				.addComponent(save)
    				.addComponent(textarea))
    	);
		grouplayout.setVerticalGroup(
    		grouplayout.createSequentialGroup()
    		.addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				.addComponent(notelb))
    		.addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				.addComponent(textarea))
    		.addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				.addComponent(scrollV))
    		.addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				.addComponent(save))
    	);
    
	}
	public void setFile() throws FileNotFoundException {
        File dir = new File("C://CharacterNotes");
        if (dir.exists() == false){

        	dir.mkdir();
        }
        else {
        	
        }
        file = new File("C://CharacterNotes/Notes.txt");
        if (file.exists() == false){
            try {
 
            	file.createNewFile();
            	fileWriter = new FileWriter(file, true);
            	fileWriter.append("CharacterNotes:");
            	olddata.append("CharacterNotes:");
            	fileWriter.append(System.lineSeparator());
            	fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(DnDUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        	Scanner scanner = new Scanner(file);
        	if (scanner.hasNext()) {
        		String oldcontent = scanner.useDelimiter("\\Z").next();
        		olddata.append(oldcontent);
        	}
        	scanner.close();
        }
        
	}
	public void updateNotes() {
		try {
			fileWriter = new FileWriter(file, true);
			String text = textarea.getText();
			if (text != "") {
				String[] lines = text.split("\n");
				for (String line: lines) {
					fileWriter.append(System.lineSeparator());
					fileWriter.append(line);
					fileWriter.flush();

				}
				fileWriter.close();
				olddata.append("\n"+text);
			}
		} catch (IOException ex) {
			Logger.getLogger(DnDUtility.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				fileWriter.close();
			} catch (IOException ex) {
				Logger.getLogger(DnDUtility.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}

