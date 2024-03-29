package hybrid.car.gui;

import hybrid.car.system.ControlUnit;
import hybrid.car.system.Environment;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private ControlUnit control;
	private Environment env;
	public JTextArea t;
	private JFrame simFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public void update_info(String s)
    {
    	t.setText(s);
    }
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		env = new Environment("textfile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		//JButton btnStopSimulation = new JButton("Stop Simulation");
		//btnStopSimulation.setBounds(193, 389, 145, 23);
		//contentPane.add(btnStopSimulation);
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false); 
		textArea.setBounds(379, 18, 297, 193);
		textArea.setText("Name : Jetta Hybrid \nMake : Volkswagen \nModle:2013\nDrag Co : 0.28\nFront Area : 1.89\nCdA : 0.5292\nFUEL_TANK: 14.5 gal\nWeight : 1820.27 kg");
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
					textArea.setText("Name : Jetta Hybrid \nMake : Volkswagen \nModle:2013\nDrag Co : 0.28\nFront Area : 1.89\nCdA : 0.5292\nFUEL_TANK: 14.5 gal\nWeight : 1820.27 kg");
				}
				else if (str == "2013-Lexus")
				{
					textArea.setText("Name : Rxh\nMake : Lexus\nModle:2013\nDrag Co : 0.33\nFront Area : 3.177\nCdA : 1.04\nFUEL_TANK: 17.2 gal\nWeight : 2110 kg");
				}
				else if (str == "2013-Toyota")
				{
					textArea.setText("Name : Pirus\nMake : Toyota\nModle:2013\nDrag Co : 0.29\nFront Area : 2.60\nCdA : 0.754\nFUEL_TANK: 11.9 gal\nWeight : 1804.84 kg");

				}
			}
		});
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2013-Jetta", "2013-Lexus", "2013-Toyota"}));
		comboBox.setBounds(10, 284, 161, 21);
		contentPane.add(comboBox);
		JButton btnStartSimulation = new JButton("Show Simulation");
		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStartSimulation.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0 ) {
				double [] specs = new double [3];
				if ((String)comboBox.getSelectedItem() == "2013-Jetta")
				{
					
					specs[0] = 0.5292;
					specs[1] = 14.5;
					specs[2] = 1820.27 ;
					control = new ControlUnit(specs , t );
					//control.startDriving(env);
					simFrame = new SimulationFrame(env , control);
					simFrame.show();
				}
				if ((String)comboBox.getSelectedItem() == "2013-Lexus")
				{
					
					specs[0] = 1.04;
					specs[1] = 17.2;
					specs[2] = 2110 ;
					
					control = new ControlUnit(specs , t);
					
				//	control.startDriving(env);
					simFrame = new SimulationFrame(env , control);
					simFrame.show();
					
				}
				if ((String)comboBox.getSelectedItem() == "2013-Toyota")
				{
					
					specs[0] = 0.754;
					specs[1] = 11.9;
					specs[2] = 1804.84 ;
					
					control = new ControlUnit(specs , t);
					//control.startDriving(env);
					simFrame = new SimulationFrame(env , control);
					simFrame.show();
				}
			}
		});
		btnStartSimulation.setBounds(34, 389, 139, 23);
		contentPane.add(btnStartSimulation);
		
		t = new JTextArea();
		t.setBounds(379, 248, 297, 151);
		contentPane.add(t);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setBounds(389, 223, 161, 14);
		contentPane.add(lblInformation);
		
		

	}
}
