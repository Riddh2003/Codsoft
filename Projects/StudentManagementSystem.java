package Projects;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.*;

public class StudentManagementSystem {
	private String[] colName = new String[] {"Delete","RollNo","Name","Grade","Standerd"};
	static Object[][] studentList = new Object[][] {{false,1,"Riddh Modi","A","12"}};
	private DefaultTableModel studentModel;
	private JTable studentTable;
	
	StudentManagementSystem() {
		JFrame jframe = new JFrame("Student Management Application");
		jframe.setBounds(100,100,500,300);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		CreateUpdateStudentPanel createUpadateStudentPanel = new CreateUpdateStudentPanel();
		ReadDeleteStudentPanel readDeleteStudentPanel = new ReadDeleteStudentPanel();
		
		tabbedPane.addTab("Create Student", createUpadateStudentPanel);
		tabbedPane.setMnemonicAt(0,KeyEvent.VK_1);
		
		tabbedPane.addTab("Read/Delete Student", readDeleteStudentPanel);
		tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);
		
		jframe.setContentPane(tabbedPane);
		jframe.setVisible(true);
		
	}
	public static void main(String[] args) {
		new StudentManagementSystem();
	}
	
	public static JTextField addLabelAndTextField(String labelText,int yPos,Container containingPanel) {
		JLabel label = new JLabel(labelText);
		GridBagConstraints gridBagConstraintForLabel = new GridBagConstraints();
		gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
		gridBagConstraintForLabel.insets = new Insets(0,0,5,5);
		gridBagConstraintForLabel.gridx = 0;
		gridBagConstraintForLabel.gridy = yPos;
		containingPanel.add(label,gridBagConstraintForLabel);
		
		JTextField textField = new JTextField();
		GridBagConstraints gridBagConstraintForTextField = new GridBagConstraints();
		gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
		gridBagConstraintForTextField.insets = new Insets(0,0,5,0);
		gridBagConstraintForTextField.gridx = 1;
		gridBagConstraintForTextField.gridy = yPos;
		containingPanel.add(textField,gridBagConstraintForTextField);
		
		textField.setColumns(10);
		return textField;
	}
	public static JButton addButton(String btnText,int yPos,Container containingPanel) {
		JButton button = new JButton(btnText);
		GridBagConstraints gridBagConstraintForButton = new GridBagConstraints();
		gridBagConstraintForButton.fill = GridBagConstraints.BOTH;
		gridBagConstraintForButton.insets = new Insets(0,0,5,5);
		gridBagConstraintForButton.gridx = 0;
		gridBagConstraintForButton.gridy = yPos;
		containingPanel.add(button,gridBagConstraintForButton);

		return button;
	}
	static void append(Object[][] array,Object[] value) {
		Object[][] result = Arrays.copyOf(array, array.length + 1);
		result[result.length-1] = value;
		StudentManagementSystem.studentList = result;
	}
}
class CreateUpdateStudentPanel extends JPanel{
	private JTextField rollnoTextField;
	private JTextField nameTextField;
	private JTextField gradeTextField;
	private JTextField stdTextField;
	private DefaultTableModel studentModel;
	CreateUpdateStudentPanel(){
		Border border = getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		setBorder(new CompoundBorder(border,margin));
		
		GridBagLayout panelGridBagLayout = new GridBagLayout();
		panelGridBagLayout.columnWidths = new int[] {86,86,0};
		panelGridBagLayout.rowHeights = new int[] {20,20,20,20,20,0};
		panelGridBagLayout.columnWeights = new double[] {0.0,1.0,Double.MIN_VALUE};
		panelGridBagLayout.rowWeights = new double[] {0.0,0.0,0.0,0.0,0.0,Double.MIN_VALUE};
		setLayout(panelGridBagLayout);
		
		rollnoTextField = StudentManagementSystem.addLabelAndTextField("RollNo : ",0,this);
		nameTextField = StudentManagementSystem.addLabelAndTextField("Name : ",1,this);
		gradeTextField = StudentManagementSystem.addLabelAndTextField("Grade : ",2,this);
		stdTextField = StudentManagementSystem.addLabelAndTextField("Standard : ",3,this);
		JButton createStudentbtn = StudentManagementSystem.addButton("Create",4,this);
		
		createStudentbtn.addActionListener(e -> createStudent());
	}
	private void createStudent() {
		String studentRollno = rollnoTextField.getText();
		String studentName = nameTextField.getText();
		String studentGrade = gradeTextField.getText();
		String studentStd = stdTextField.getText();
		
		Object[] studentData = new Object[] {false,studentRollno,studentName,studentGrade,studentStd};
		StudentManagementSystem.append(StudentManagementSystem.studentList,studentData);
		
		DefaultTableModel studentModel = null;
		studentModel.addRow(studentData);
		rollnoTextField.setText("");
		nameTextField.setText("");
		gradeTextField.setText("");
		stdTextField.setText("");
	}
}
class ReadDeleteStudentPanel extends JPanel{
	private DefaultTableModel studentModel;
	private JTable studentTable;

	ReadDeleteStudentPanel(){
		setPreferredSize(new Dimension(400,200));
		
		JButton deleteButton = StudentManagementSystem.addButton("Delete", 0, this);
		deleteButton.addActionListener(e -> deleteStudent());
		Object[] colName = {"","","","",""};
		DefaultTableModel studentModel = new DefaultTableModel(StudentManagementSystem.studentList,colName);
		studentTable = new JTable(studentModel) {
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0 :
					return Boolean.class;
				case 1 :
					return String.class;
				case 2 :
					return String.class;
				case 3 :
					return String.class;
				case 4 :
					return String.class;
				default :
					return Boolean.class;
				}
			}
		};
		studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(studentTable);
		add(pane,BorderLayout.CENTER);
	}

	private void deleteStudent() {
		DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
		for(int i = 0;i<model.getRowCount();i++) {
			Boolean checked = (Boolean)model.getValueAt(i,0);
			if(checked != null && checked) {
				model.removeRow(i);
				i--;
			}
		}
	}
}