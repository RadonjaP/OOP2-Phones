package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.xml.internal.bind.v2.TODO;

import beans.BeansManagerTeam6;
import beans.StatelessBeanTeam6;
import beans.StatelessBeanTeam6Remote;
import db.DBManagerTeam6;
import entity.Phone;

@SuppressWarnings("serial")
public class InsertPhone extends JFrame {
	public static final Image image = Toolkit.getDefaultToolkit().createImage(Login.class.getResource("res/logo.jpg"));
	private Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);
	
	private StatelessBeanTeam6Remote sbr;
	
	public InsertPhone(StatelessBeanTeam6Remote sbr) {
		this.sbr = sbr;
		JLabel bect = new JLabel(new ImageIcon(Login.class.getResource("res/unoss.jpg")));
		setContentPane(bect);
		bect.setLayout(new BoxLayout(bect, BoxLayout.Y_AXIS));
		bect.add(Box.createVerticalStrut(33));
		bect.add(insertProduce());
		bect.add(insertName());
		bect.add(insertOperatingSystem());
		bect.add(insertWidth());
		bect.add(insertHeight());
		bect.add(insertWeight());
		bect.add(insertResolutionDisplay());
		bect.add(insertResolutionCamera());
		bect.add(insertCPUSpeed());
		bect.add(insertMemory());
		bect.add(insertBatteryCapacity());
		bect.add(insertPrice());
		bect.add(insertPicture());
		bect.add(savePhone());
	}

	private JPanel insertProduce() {
		JLabel lblProducer = new JLabel("Producer");
		lblProducer.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblProducer.setForeground(Color.black);
		lblProducer.setMinimumSize(new Dimension(130, 30));
		lblProducer.setMaximumSize(new Dimension(130, 30));
		lblProducer.setPreferredSize(new Dimension(130, 30));

		JComboBox<String> txtProducer = new JComboBox<>();
		txtProducer.setMaximumSize(new Dimension(200, 30));
		txtProducer.setMinimumSize(new Dimension(200, 30));
		txtProducer.setPreferredSize(new Dimension(200, 30));
		txtProducer.setBorder(border);
		txtProducer.setForeground(Color.gray);
		txtProducer.addItem("Alcatel");
		txtProducer.addItem("Apple");
		txtProducer.addItem("Coolpad");
		txtProducer.addItem("HTC");
		txtProducer.addItem("Huawei");
		txtProducer.addItem("Lenovo");
		txtProducer.addItem("LG");
		txtProducer.addItem("Microsoft");
		txtProducer.addItem("Nokia");
		txtProducer.addItem("Samsung");
		txtProducer.addItem("Sony");

		JPanel pnlProduce = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		;
		pnlProduce.setOpaque(false);
		pnlProduce.setMaximumSize(new Dimension(350, 40));
		pnlProduce.add(lblProducer);
		pnlProduce.add(txtProducer);
		return pnlProduce;
	}

	private JPanel insertName() {
		JLabel lblName = new JLabel("Model");
		lblName.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblName.setForeground(Color.black);
		lblName.setMinimumSize(new Dimension(130, 30));
		lblName.setMaximumSize(new Dimension(130, 30));
		lblName.setPreferredSize(new Dimension(130, 30));

		JTextField txtName = new JTextField();
		txtName.setMaximumSize(new Dimension(200, 30));
		txtName.setMinimumSize(new Dimension(200, 30));
		txtName.setPreferredSize(new Dimension(200, 30));
		txtName.setBorder(border);
		txtName.setForeground(Color.gray);

		JPanel pnlName = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlName.setOpaque(false);
		pnlName.setMaximumSize(new Dimension(350, 40));
		pnlName.add(lblName);
		pnlName.add(txtName);
		return pnlName;
	}

	private JPanel insertOperatingSystem() {
		JLabel lblOperatingSystem = new JLabel("OS");
		lblOperatingSystem.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblOperatingSystem.setForeground(Color.black);
		lblOperatingSystem.setMinimumSize(new Dimension(130, 30));
		lblOperatingSystem.setMaximumSize(new Dimension(130, 30));
		lblOperatingSystem.setPreferredSize(new Dimension(130, 30));

		JComboBox<String> txtOperatingSystem = new JComboBox<>();
		txtOperatingSystem.setMaximumSize(new Dimension(200, 30));
		txtOperatingSystem.setMinimumSize(new Dimension(200, 30));
		txtOperatingSystem.setPreferredSize(new Dimension(200, 30));
		txtOperatingSystem.setBorder(border);
		txtOperatingSystem.setForeground(Color.gray);
		txtOperatingSystem.addItem("Android");
		txtOperatingSystem.addItem("IOS");
		txtOperatingSystem.addItem("Windows");
		txtOperatingSystem.addItem("Simbian");

		JPanel pnlOperatingSystem = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlOperatingSystem.setOpaque(false);
		pnlOperatingSystem.setMaximumSize(new Dimension(350, 40));
		pnlOperatingSystem.add(lblOperatingSystem);
		pnlOperatingSystem.add(txtOperatingSystem);
		return pnlOperatingSystem;
	}

	private JPanel insertWidth() {
		JLabel lblWidth = new JLabel("Width");
		lblWidth.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblWidth.setForeground(Color.black);
		lblWidth.setMinimumSize(new Dimension(130, 30));
		lblWidth.setMaximumSize(new Dimension(130, 30));
		lblWidth.setPreferredSize(new Dimension(130, 30));

		JTextField txtWidth = new JTextField();
		txtWidth.setMaximumSize(new Dimension(200, 30));
		txtWidth.setMinimumSize(new Dimension(200, 30));
		txtWidth.setPreferredSize(new Dimension(200, 30));
		txtWidth.setBorder(border);
		txtWidth.setForeground(Color.gray);

		JPanel pnlWidth = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlWidth.setOpaque(false);
		pnlWidth.setMaximumSize(new Dimension(350, 40));
		pnlWidth.add(lblWidth);
		pnlWidth.add(txtWidth);
		return pnlWidth;
	}

	private JPanel insertHeight() {
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblHeight.setForeground(Color.black);
		lblHeight.setMinimumSize(new Dimension(130, 30));
		lblHeight.setMaximumSize(new Dimension(130, 30));
		lblHeight.setPreferredSize(new Dimension(130, 30));

		JTextField txtHeight = new JTextField();
		txtHeight.setMaximumSize(new Dimension(200, 30));
		txtHeight.setMinimumSize(new Dimension(200, 30));
		txtHeight.setPreferredSize(new Dimension(200, 30));
		txtHeight.setBorder(border);
		txtHeight.setForeground(Color.gray);

		JPanel pnlHeight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlHeight.setOpaque(false);
		pnlHeight.setMaximumSize(new Dimension(350, 40));
		pnlHeight.add(lblHeight);
		pnlHeight.add(txtHeight);
		return pnlHeight;
	}

	private JPanel insertWeight() {
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblWeight.setForeground(Color.black);
		lblWeight.setMinimumSize(new Dimension(130, 30));
		lblWeight.setMaximumSize(new Dimension(130, 30));
		lblWeight.setPreferredSize(new Dimension(130, 30));

		JTextField txtWeight = new JTextField();
		txtWeight.setMaximumSize(new Dimension(200, 30));
		txtWeight.setMinimumSize(new Dimension(200, 30));
		txtWeight.setPreferredSize(new Dimension(200, 30));
		txtWeight.setBorder(border);
		txtWeight.setForeground(Color.gray);

		JPanel pnlWeight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlWeight.setOpaque(false);
		pnlWeight.setMaximumSize(new Dimension(350, 40));
		pnlWeight.add(lblWeight);
		pnlWeight.add(txtWeight);
		return pnlWeight;
	}

	private JPanel insertResolutionDisplay() {
		JLabel lblResolutionDisplay = new JLabel("Display");
		lblResolutionDisplay.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblResolutionDisplay.setForeground(Color.black);
		lblResolutionDisplay.setMinimumSize(new Dimension(130, 30));
		lblResolutionDisplay.setMaximumSize(new Dimension(130, 30));
		lblResolutionDisplay.setPreferredSize(new Dimension(130, 30));

		JTextField txtResolutionDisplay = new JTextField();
		txtResolutionDisplay.setMaximumSize(new Dimension(200, 30));
		txtResolutionDisplay.setMinimumSize(new Dimension(200, 30));
		txtResolutionDisplay.setPreferredSize(new Dimension(200, 30));
		txtResolutionDisplay.setBorder(border);
		txtResolutionDisplay.setForeground(Color.gray);

		JPanel pnlResolutionDisplay = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlResolutionDisplay.setOpaque(false);
		pnlResolutionDisplay.setMaximumSize(new Dimension(350, 40));
		pnlResolutionDisplay.add(lblResolutionDisplay);
		pnlResolutionDisplay.add(txtResolutionDisplay);
		return pnlResolutionDisplay;
	}

	private JPanel insertResolutionCamera() {
		JLabel lblResolutionCamera = new JLabel("Camera");
		lblResolutionCamera.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblResolutionCamera.setForeground(Color.black);
		lblResolutionCamera.setMinimumSize(new Dimension(130, 30));
		lblResolutionCamera.setMaximumSize(new Dimension(130, 30));
		lblResolutionCamera.setPreferredSize(new Dimension(130, 30));

		JTextField txtResolutionCamera = new JTextField();
		txtResolutionCamera.setMaximumSize(new Dimension(200, 30));
		txtResolutionCamera.setMinimumSize(new Dimension(200, 30));
		txtResolutionCamera.setPreferredSize(new Dimension(200, 30));
		txtResolutionCamera.setBorder(border);
		txtResolutionCamera.setForeground(Color.gray);

		JPanel pnlResolutionCamera = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlResolutionCamera.setOpaque(false);
		pnlResolutionCamera.setMaximumSize(new Dimension(350, 40));
		pnlResolutionCamera.add(lblResolutionCamera);
		pnlResolutionCamera.add(txtResolutionCamera);
		return pnlResolutionCamera;
	}

	private JPanel insertMemory() {
		JLabel lblMemory = new JLabel("Memory");
		lblMemory.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblMemory.setForeground(Color.black);
		lblMemory.setMinimumSize(new Dimension(130, 30));
		lblMemory.setMaximumSize(new Dimension(130, 30));
		lblMemory.setPreferredSize(new Dimension(130, 30));

		JTextField txtMemory = new JTextField();
		txtMemory.setMaximumSize(new Dimension(200, 30));
		txtMemory.setMinimumSize(new Dimension(200, 30));
		txtMemory.setPreferredSize(new Dimension(200, 30));
		txtMemory.setBorder(border);
		txtMemory.setForeground(Color.gray);

		JPanel pnlMemory = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlMemory.setOpaque(false);
		pnlMemory.setMaximumSize(new Dimension(350, 40));
		pnlMemory.add(lblMemory);
		pnlMemory.add(txtMemory);
		return pnlMemory;
	}

	private JPanel insertCPUSpeed() {
		JLabel lblCPUSpeed = new JLabel("CPU speed");
		lblCPUSpeed.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblCPUSpeed.setForeground(Color.black);
		lblCPUSpeed.setMinimumSize(new Dimension(130, 30));
		lblCPUSpeed.setMaximumSize(new Dimension(130, 30));
		lblCPUSpeed.setPreferredSize(new Dimension(130, 30));

		JTextField txtCPUSpeed = new JTextField();
		txtCPUSpeed.setMaximumSize(new Dimension(200, 30));
		txtCPUSpeed.setMinimumSize(new Dimension(200, 30));
		txtCPUSpeed.setPreferredSize(new Dimension(200, 30));
		txtCPUSpeed.setBorder(border);
		txtCPUSpeed.setForeground(Color.gray);

		JPanel pnlCPUSpeed = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlCPUSpeed.setOpaque(false);
		pnlCPUSpeed.setMaximumSize(new Dimension(350, 40));
		pnlCPUSpeed.add(lblCPUSpeed);
		pnlCPUSpeed.add(txtCPUSpeed);
		return pnlCPUSpeed;
	}

	private JPanel insertBatteryCapacity() {
		JLabel lblBatteryCapacity = new JLabel("Battery Capacity");
		lblBatteryCapacity.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblBatteryCapacity.setForeground(Color.black);
		lblBatteryCapacity.setMinimumSize(new Dimension(130, 30));
		lblBatteryCapacity.setMaximumSize(new Dimension(130, 30));
		lblBatteryCapacity.setPreferredSize(new Dimension(130, 30));

		JTextField txtBatteryCapacity = new JTextField();
		txtBatteryCapacity.setMaximumSize(new Dimension(200, 30));
		txtBatteryCapacity.setMinimumSize(new Dimension(200, 30));
		txtBatteryCapacity.setPreferredSize(new Dimension(200, 30));
		txtBatteryCapacity.setBorder(border);
		txtBatteryCapacity.setForeground(Color.gray);

		JPanel pnlBatteryCapacity = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlBatteryCapacity.setOpaque(false);
		pnlBatteryCapacity.setMaximumSize(new Dimension(350, 40));
		pnlBatteryCapacity.add(lblBatteryCapacity);
		pnlBatteryCapacity.add(txtBatteryCapacity);
		return pnlBatteryCapacity;
	}

	private JPanel insertPrice() {
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblPrice.setForeground(Color.black);
		lblPrice.setMinimumSize(new Dimension(130, 30));
		lblPrice.setMaximumSize(new Dimension(130, 30));
		lblPrice.setPreferredSize(new Dimension(130, 30));

		JTextField txtPrice = new JTextField();
		txtPrice.setMaximumSize(new Dimension(200, 30));
		txtPrice.setMinimumSize(new Dimension(200, 30));
		txtPrice.setPreferredSize(new Dimension(200, 30));
		txtPrice.setBorder(border);
		txtPrice.setForeground(Color.gray);

		JPanel pnlPrice = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlPrice.setOpaque(false);
		pnlPrice.setMaximumSize(new Dimension(350, 40));
		pnlPrice.add(lblPrice);
		pnlPrice.add(txtPrice);
		return pnlPrice;
	}

	private JPanel insertPicture() {
		JButton btnPicture = new JButton("Insert picture");
		btnPicture.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		btnPicture.setForeground(Color.black);
		btnPicture.setMinimumSize(new Dimension(130, 30));
		btnPicture.setMaximumSize(new Dimension(130, 30));
		btnPicture.setPreferredSize(new Dimension(130, 30));

		JLabel lbl = new JLabel("");
		lbl.setMinimumSize(new Dimension(200, 190));
		lbl.setMaximumSize(new Dimension(200, 190));
		lbl.setPreferredSize(new Dimension(200, 190));

		btnPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selecredFile = file.getSelectedFile();
					String path = selecredFile.getAbsolutePath();
					ImageIcon myImage = new ImageIcon(path);
					Image img = myImage.getImage();
					Image newImage = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon image = new ImageIcon(newImage);
					lbl.setIcon(image);
				} else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("No file select");
				}
			}
		});

		JPanel pnlPicture = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlPicture.setOpaque(false);
		pnlPicture.setMaximumSize(new Dimension(350, 300));
		pnlPicture.add(btnPicture);
		pnlPicture.add(lbl);
		return pnlPicture;
	}
	
	public JPanel savePhone(){
		JButton btnSave = new JButton("Save phone");
		btnSave.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		btnSave.setForeground(Color.black);
		btnSave.setMinimumSize(new Dimension(130, 30));
		btnSave.setMaximumSize(new Dimension(130, 30));
		btnSave.setPreferredSize(new Dimension(130, 30));
        
		btnSave.addActionListener(new ActionListener() {

			// TODO Data input fields must be public/private fields declared in class in order to access them from this method
			@Override
			public void actionPerformed(ActionEvent e) {
				Phone p = new Phone();
				p.setPrice(99);
				p.setOperatingSystem("Android");
				p.setResolutionX(4);
				
				// TODO Works but needs to be filled with real data
				try {
					sbr.addPhone(p);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JPanel pnlSave = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnlSave.setOpaque(false);
		pnlSave.setMaximumSize(new Dimension(350, 300));
		pnlSave.add(btnSave);
		return pnlSave;
	}

	public static void main(String[] args) throws NamingException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		BeansManagerTeam6 beanManager = new BeansManagerTeam6();
		StatelessBeanTeam6Remote sbr = beanManager.getStatelessBean();
		
		InsertPhone phone = new InsertPhone(sbr);
		phone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		phone.setSize(940, 750);
		phone.setLocationRelativeTo(null);
		phone.setResizable(false);
		JLabel lblTxt = new JLabel("Insert Phone");
		phone.setTitle(lblTxt.getText());
		phone.setIconImage(image);
		phone.setVisible(true);
	}
}