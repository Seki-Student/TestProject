import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IT452_Unit2_Ian_Seki extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DB database;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IT452_Unit2_Ian_Seki frame = new IT452_Unit2_Ian_Seki();
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
	public IT452_Unit2_Ian_Seki() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnect = new JLabel("Connect");
		lblConnect.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConnect.setBounds(110, 150, 115, 30);
		contentPane.add(lblConnect);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCount.setBounds(110, 190, 115, 30);
		contentPane.add(lblCount);
		
		JLabel lblCompanyNames = new JLabel("Company Names");
		lblCompanyNames.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanyNames.setBounds(110, 230, 115, 30);
		contentPane.add(lblCompanyNames);
		
		JButton btnConnectDB = new JButton("Connect to DB");
		btnConnectDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String dbURL = "jdbc:sqlserver://ISEKI-LAPTOP\\\\SEKIDB;"
							+ "database=Northwind;"
							+ "user=sa;"
							+ "password=password1;"
							+ "encrypt=false;"
							+ "trustServerCertificate=true;"
							+ "loginTimeout=30;";
					
					database = new DB(dbURL);
					
					System.out.print("Connected");
				}
				catch (Exception exp)
				{
					JOptionPane.showMessageDialog(null, exp.getMessage());
				}
			}
		});
		btnConnectDB.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConnectDB.setBounds(362, 150, 200, 30);
		contentPane.add(btnConnectDB);
		
		JButton btnCustomerCount = new JButton("Customer Count");
		btnCustomerCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String returnedValue = database.getCustomerCount();
					JOptionPane.showMessageDialog(null, "The customer count is:"+ returnedValue);
				}
				catch (Exception ex)
				{
					JOptionPane.showConfirmDialog(null, ex.getMessage());
				}
				
			}
		});
		btnCustomerCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCustomerCount.setBounds(362, 196, 200, 30);
		contentPane.add(btnCustomerCount);
		
		JButton btnCustomerNames = new JButton("Get Company Names");
		btnCustomerNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String returnedValue = database.getCompanyNames();
					
					JOptionPane.showMessageDialog(null, "Customer Names: " + returnedValue);
				}
				catch (Exception ex)
				{
					JOptionPane.showConfirmDialog(null, ex.getMessage());
				}
			}
		});
		btnCustomerNames.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCustomerNames.setBounds(362, 236, 200, 30);
		contentPane.add(btnCustomerNames);
	}
}
