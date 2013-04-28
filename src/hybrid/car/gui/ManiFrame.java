package hybrid.car.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;

public class ManiFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManiFrame frame = new ManiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartSimulation = new JButton("Start Simulation");
		btnStartSimulation.setBounds(34, 389, 139, 23);
		contentPane.add(btnStartSimulation);
		
		JButton btnStopSimulation = new JButton("Stop Simulation");
		btnStopSimulation.setBounds(193, 389, 145, 23);
		contentPane.add(btnStopSimulation);
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false); 
		textArea.setBounds(379, 35, 297, 193);
		textArea.setText("Drag Co : 0.28 Front Area : 1.89\n\nCdA : 0.5292\n\nFUEL_TANK: 14.5 gal\n\nWeight : 1820.27 kg");
		contentPane.add(textArea);
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("2013-Jetta.jpg"));
		
		lblNewLabel.setBounds(10, 18, 359, 255);
		contentPane.add(lblNewLabel);
		@SuppressWarnings("rawtypes")
		final
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = (String)comboBox.getSelectedItem();
				System.out.println(str);
				lblNewLabel.setIcon(new ImageIcon(str+".jpg"));
				if (str == "2013-Jetta")
				{
					System.out.println("yes");
					textArea.setText("Drag Co : 0.28 Front Area : 1.89\n\nCdA : 0.5292\n\nFUEL_TANK: 14.5 gal\n\nWeight : 1820.27 kg");
				}
				else if (str == "2013-Lexus")
				{
					
				}
			}
		});
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2013-Jetta", "2013-Lexus", "2013-Toyota"}));
		comboBox.setBounds(20, 284, 161, 21);
		contentPane.add(comboBox);
		
		
		
		

	}
}
