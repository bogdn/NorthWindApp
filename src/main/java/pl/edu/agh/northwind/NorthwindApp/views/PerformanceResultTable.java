package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import pl.edu.agh.northwind.NorthwindApp.models.CustomerTableModel;
import pl.edu.agh.northwind.NorthwindApp.models.EmployeeTableModel;
import pl.edu.agh.northwind.NorthwindApp.performance.PerformanceManager;
import pl.edu.agh.northwind.NorthwindApp.performance.PerformanceTest;

public class PerformanceResultTable extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;
	
	public PerformanceResultTable()
	{
		super("Performance result table");
		setVisible(true);
		setPreferredSize(new Dimension(900, 600));

		table = new JTable();

		table.setModel(new PerformanceResultTableModer());
		// adding table with scroolPane
		scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		add(scrollPane, BorderLayout.CENTER);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		pack();
	}
	
	private class PerformanceResultTableModer extends AbstractTableModel
	{
		
		ArrayList<PerformanceTest> tests;
		
		public PerformanceResultTableModer() {
			tests = PerformanceManager.shared().getAllTests();
		}
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return tests.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			PerformanceTest test = tests.get(rowIndex);
			
			switch(columnIndex)
			{
			case 0: return test.getName();
			case 1: return test.getCount();
			case 2: return test.getFastest()+"[ms]";
			case 3: return test.getSlowest()+"[ms]";
			default: return "";
			}
		}
		
		@Override
		public String getColumnName(int column) {
			switch(column)
			{
			case 0: return "Name";
			case 1: return "Tests count";
			case 2: return "Fastest test";
			case 3: return "Slowest test";
			default: return "";
			}
		}
	}
}
