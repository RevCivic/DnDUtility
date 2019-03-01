package dndutility;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
final class DnDUtility extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7327829591435127227L;
	private final JTabbedPane tabbedPane;
	private	InitPage initPage;
	private	DicePage dicePage;
	private	JPanel panel3;
    private NotesPage notesPage;


	public DnDUtility() throws FileNotFoundException {

		// NOTE: to reduce the amount of code in this example, it uses
		// panels with a NULL layout.  This is NOT suitable for
		// production code since it may not display correctly for
		// a look-and-feel.
		
		setTitle( "D&D Utilites" );
		setSize( 575, 675 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
		setDefaultCloseOperation(EXIT_ON_CLOSE);                
		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();
        createPage4();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Init", initPage );
		tabbedPane.addTab( "Rolls", dicePage );
        tabbedPane.addTab("Stats", panel3);
		tabbedPane.addTab( "Notes", notesPage );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
                
	}
	
	public void createPage1() {
		
		initPage = new InitPage();

    }
        
	public void createPage2() {
		dicePage = new DicePage();
        }
        

	public void createPage3() {
                
		panel3 = new JPanel();
		//Stats JPanel will go here
	}
    public void createPage4() throws FileNotFoundException {
    	notesPage = new NotesPage();
    	}
    
    public void storeUnit() {
    	UnitTemplate newUnit = this.initPage.getUnit();
    	this.initPage.sendUnit(newUnit);
    }

    // Main method to get things started
	public static void main( String args[] ) {
		// Create an instance of the test application
		DnDUtility mainFrame = null;
		try {
			mainFrame = new DnDUtility();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DnDUtility.class.getName()).log(Level.SEVERE, null, ex);
		}
		mainFrame.setVisible(true);
		try {
			new DnDUtility().createPage2();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DnDUtility.class.getName()).log(Level.SEVERE, null, ex);
		}         
	}
}