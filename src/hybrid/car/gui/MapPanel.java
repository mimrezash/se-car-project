/*
 * Created by JFormDesigner on Sat Apr 13 17:13:09 CDT 2013
 */

package hybrid.car.gui;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author name
 */
public class MapPanel extends JPanel {
	public MapPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		panel2 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		panel1 = new JPanel();

		//======== this ========
		setMinimumSize(new Dimension(600, 600));
		setLayout(new FormLayout(
			"default, $lcgap, default",
			"default"));

		//======== panel2 ========
		{
			panel2.setLayout(new FormLayout(
				"default",
				"4*(default, $lgap), default"));

			//---- button1 ----
			button1.setText("Increase Car Speed");
			panel2.add(button1, CC.xy(1, 1));

			//---- button2 ----
			button2.setText("Decrease Car Speed");
			panel2.add(button2, CC.xy(1, 3));

			//---- label1 ----
			label1.setText("Information 1");
			panel2.add(label1, CC.xy(1, 5));

			//---- label2 ----
			label2.setText("Information 2");
			panel2.add(label2, CC.xy(1, 7));

			//---- label3 ----
			label3.setText("Information 3");
			panel2.add(label3, CC.xy(1, 9));
		}
		add(panel2, CC.xy(1, 1));

		//======== panel1 ========
		{
			panel1.setMinimumSize(new Dimension(400, 400));
			panel1.setLayout(new FormLayout(
				"default",
				"default"));
		}
		add(panel1, CC.xy(3, 1));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JPanel panel1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
