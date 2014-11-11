package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListAllTable extends JFrame {
	
	private JTable table;
	private JScrollPane scrollPane;
	public ListAllTable(String tableName) {
		super("Listing all members of " + tableName +" table");
		setVisible(true);
		setPreferredSize(new Dimension(400, 400));
		
//		scrollPane = new JScrollPane();
//		scrollPane.add(table);
//		add(scrollPane, BorderLayout.CENTER);
		JLabel label = new JLabel("TU JTABLE Z PRACOWNIKAMI");
		add(label, BorderLayout.CENTER);
		pack();
	}

}
