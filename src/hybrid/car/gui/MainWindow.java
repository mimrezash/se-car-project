/*
 * Created by JFormDesigner on Wed Apr 10 15:54:28 CDT 2013
 */

package hybrid.car.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author name
 */
public class MainWindow {
	public MainWindow() {
		initComponents();
	}

	private void menuExitMouseClicked(MouseEvent e) {
		// TODO add your code here
		System.exit(0);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		windowsFrame = new JPanel();
		mainMenuBar = new JMenuBar();
		fileMenu = new JMenu();
		menuLoad = new JMenuItem();
		menuExit = new JMenuItem();
		helpMenu = new JMenu();
		menuAbout = new JMenuItem();

		//======== windowsFrame ========
		{
			windowsFrame.setMaximumSize(new Dimension(800, 800));
			windowsFrame.setPreferredSize(new Dimension(300, 100));
			windowsFrame.setMinimumSize(new Dimension(300, 100));
			windowsFrame.setName("Car Simulator");
			windowsFrame.setInheritsPopupMenu(true);
			windowsFrame.setLayout(new FormLayout(
				"default",
				"2*(default, $lgap), default"));

			//======== mainMenuBar ========
			{

				//======== fileMenu ========
				{
					fileMenu.setText("File");

					//---- menuLoad ----
					menuLoad.setText("Load Map...");
					fileMenu.add(menuLoad);

					//---- menuExit ----
					menuExit.setText("Exit");
					menuExit.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							menuExitMouseClicked(e);
						}
					});
					fileMenu.add(menuExit);
				}
				mainMenuBar.add(fileMenu);

				//======== helpMenu ========
				{
					helpMenu.setText("Help");

					//---- menuAbout ----
					menuAbout.setText("About...");
					helpMenu.add(menuAbout);
				}
				mainMenuBar.add(helpMenu);
			}
			windowsFrame.add(mainMenuBar, CC.xy(1, 1));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel windowsFrame;
	private JMenuBar mainMenuBar;
	private JMenu fileMenu;
	private JMenuItem menuLoad;
	private JMenuItem menuExit;
	private JMenu helpMenu;
	private JMenuItem menuAbout;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
