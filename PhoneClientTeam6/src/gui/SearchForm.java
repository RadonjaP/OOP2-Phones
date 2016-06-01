package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import beans.BeansManagerTeam6;
import beans.StatelessBeanTeam6Remote;
import entity.Phone;

public class SearchForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TableModel tm;
	private JTable table;
	private List<Phone> phones;
	private JTextField txtPrice;
	private JTextField textModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeansManagerTeam6 beanManager = new BeansManagerTeam6();
					StatelessBeanTeam6Remote sbr = beanManager.getStatelessBean();

					SearchForm frame = new SearchForm(sbr);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param sbr
	 */
	public SearchForm(StatelessBeanTeam6Remote sbr) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSearchMobilePhone = new JLabel("Search mobile phone");
		lblSearchMobilePhone.setBounds(181, 11, 180, 21);
		lblSearchMobilePhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMobilePhone.setFont(new Font("Tahoma", Font.BOLD, 17));

		JComboBox<String> comboBoxOS = new JComboBox<String>();
		comboBoxOS.setBounds(243, 55, 266, 20);
		String[] osArray = { "Android", "iOS", "Windows", "Symbian" };
		for (String os : osArray) {
			comboBoxOS.addItem(os);
		}

		JLabel lblOperatingSystem = new JLabel("Operating system");
		lblOperatingSystem.setBounds(23, 56, 160, 16);
		lblOperatingSystem.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblOperator = new JLabel("Model");
		lblOperator.setBounds(23, 87, 151, 16);
		lblOperator.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 311, 585, 178);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call a method that returns a list that meets the criteria
				// phones.add(new Phone()); //for test
				// tm.setPhonesList(phones);
				Phone p = new Phone();
				p.setBatteryCapacity(0);
				p.setPrice(99);
				p.setOperatingSystem("Android");
				p.setResolutionX(4);

				List<Phone> phones = sbr.searchPhones(p);
				if (phones == null) {
					JOptionPane.showMessageDialog(SearchForm.this, "List of phones is null",
							"Table not working error", JOptionPane.ERROR_MESSAGE);
				} else {
					tm.setPhonesList(phones);
				}
			}
		});
		btnSearch.setBounds(416, 243, 114, 23);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(23, 121, 160, 16);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JTextField txtTitle = new JTextField();
		txtTitle.setBounds(243, 120, 266, 20);
		txtTitle.setColumns(10);

		JLabel lblPrice = new JLabel("Price to");
		lblPrice.setBounds(23, 152, 160, 16);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtPrice = new JTextField();
		txtPrice.setBounds(243, 151, 151, 20);
		txtPrice.setColumns(10);

		phones = new ArrayList<>();
		tm = new TableModel(phones);
		table = new JTable(tm);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		ListSelectionModel select = table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		contentPane.setLayout(null);
		contentPane.add(lblSearchMobilePhone);
		contentPane.add(scrollPane);
		contentPane.add(btnSearch);
		contentPane.add(lblTitle);
		contentPane.add(lblPrice);
		contentPane.add(lblOperator);
		contentPane.add(lblOperatingSystem);
		contentPane.add(comboBoxOS);
		contentPane.add(txtPrice);
		contentPane.add(txtTitle);

		textModel = new JTextField();
		textModel.setBounds(243, 86, 266, 20);
		contentPane.add(textModel);
		textModel.setColumns(10);

		JLabel lblNewLabel = new JLabel("Memory");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(23, 185, 160, 14);
		contentPane.add(lblNewLabel);

		JSpinner spinnerMemory = new JSpinner();
		spinnerMemory.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerMemory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinnerMemory.setBounds(243, 182, 151, 20);
		contentPane.add(spinnerMemory);

		JLabel lblGb = new JLabel("GB");
		lblGb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGb.setBounds(399, 185, 15, 14);
		contentPane.add(lblGb);

		JLabel lblCpuSpeed = new JLabel("Cpu speed");
		lblCpuSpeed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpuSpeed.setBounds(23, 216, 160, 14);
		contentPane.add(lblCpuSpeed);

		JLabel lblMhz = new JLabel("MHz");
		lblMhz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMhz.setBounds(399, 216, 24, 14);
		contentPane.add(lblMhz);

		JSpinner spinnerCpuSpeed = new JSpinner();
		spinnerCpuSpeed.setModel(new SpinnerNumberModel(new Double(1000), new Double(400), null, new Double(100)));
		spinnerCpuSpeed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinnerCpuSpeed.setBounds(243, 213, 151, 20);
		contentPane.add(spinnerCpuSpeed);

		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(399, 153, 7, 14);
		contentPane.add(label);

		JButton btnShowDetail = new JButton("Show details");
		btnShowDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(SearchForm.this, "Click on the row you want to display details.",
							"You did not select a row", JOptionPane.ERROR_MESSAGE);
				else {
					// int index=table.getSelectedRow();
					// Phone p = phones.get(index);
					// PhoneForm pf = new PhoneForm(p);
					// pf.setVisible(true);
				}
			}
		});
		btnShowDetail.setBounds(416, 277, 114, 23);
		contentPane.add(btnShowDetail);
	}
}
