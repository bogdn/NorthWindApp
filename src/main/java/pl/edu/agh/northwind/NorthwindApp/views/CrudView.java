package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CrudView extends JFrame {

	private JButton listAllButton;
	private JButton addRecordButton;

	public CrudView(String tableName) {
		super("Operations for " + tableName + " table");
		setVisible(true);
		setLayout(null);
		setPreferredSize(new Dimension(400, 500));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		listAllButton = new JButton("List all " + tableName);
		listAllButton.setBounds(120, 20, 170, 50);
		add(listAllButton);

		addRecordButton = new JButton("Add to " + tableName);
		addRecordButton.setBounds(120, 90, 170, 50);
		add(addRecordButton);
		pack();
	}

	public void addListAllButtonListener(ActionListener al) {
		listAllButton.addActionListener(al);
	}

	public void addAddRecordButtonListener(ActionListener al) {
		addRecordButton.addActionListener(al);
	}
}
