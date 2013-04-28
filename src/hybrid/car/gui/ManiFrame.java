package hybrid.car.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
		btnStopSimulation.setBounds(193, 389, 118, 23);
		contentPane.add(btnStopSimulation);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("2013-Jetta.jpg"));
		
		lblNewLabel.setBounds(10, 11, 359, 255);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2013-Jetta", "2013-Lexus", "2013-Toyota"}));
		comboBox.setBounds(20, 284, 161, 21);
		contentPane.add(comboBox);
	}
}
