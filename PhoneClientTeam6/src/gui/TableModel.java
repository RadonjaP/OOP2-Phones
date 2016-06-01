package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Phone;

public class TableModel extends AbstractTableModel {
	String[] columns = { "Producer", "Model", "Operating System", "Cpu Speed", "Memory", "Current Offer" };
	List<Phone> phonesList;

	TableModel(List<Phone> phonesList) {
		this.phonesList = phonesList;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return phonesList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Phone> phones = new ArrayList(phonesList);
		Phone onePhone = phones.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return onePhone.getProducer();
		case 1:
			return onePhone.getModel();
		case 2:
			return onePhone.getOperatingSystem();
		case 3:
			return onePhone.getCpuSpeed();
		case 4:
			return onePhone.getMemory();
		case 5:
			return onePhone.getPrice();
		}
		return null;

	}

	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

	public void setPhonesList(List<Phone> phonesList) {
		this.phonesList = phonesList;
		fireTableDataChanged();
	}
	
	

}
