package dealership;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.GridLayout;

public class DisplayCars extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane pane;
	private JTable table;
	
	public DisplayCars(ArrayList<Car> usedList) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		String[] colHead = {"Make", "Model","Price","Color", "Mileage",
				"Year", "Type", "Body Style", "Terrain Type" ,"VIN"};
		
		String[][] carList = new String[usedList.size()][];
		for(int i = 0; i < usedList.size(); i++)
			carList[i] = usedList.get(i).getInfo();
		this.table = new JTable(carList, colHead);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.table.setBounds(75, 34, 1, 1);
		
		DefaultTableModel tableModel = new DefaultTableModel(carList, colHead) {
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		table.setModel(tableModel);
		
		this.pane = new JScrollPane(table);
		contentPane.add(pane);
	}
}
