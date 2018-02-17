package com.mp.contactmanager.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mp.contactmanager.beans.ContactManagerBean;
import com.mp.contactmanager.db.ContactManagerDb;

public class Display implements ActionListener {


	private JTable table;
	private ContactManagerDb managerDb;
	JTextField fNameTextField;
    JTextField mNameTextField;
	JTextField lastNameTextField;
	JTextField contact_IdTextField;
	JTextField NumberTexField;
	JTextField bdateTextField;
	JTextField typeTextField;
	JTextField codeTextField;
	JTextField mail_idTextField;
        JTextField mtypeTextField;
        JTextField address_idTextField;
        JTextField countryTextField;
        JTextField stateTextField;
        JTextField cityTextField;
        JTextField streetTextField;
        JTextField add_typeTextField;
	DefaultTableModel tableModel; 
	public JTable getTable() {
		return table;
	}

	public void renderContactMangerScreen() {
		JFrame frame = new JFrame();
		Properties prop = new Properties();
		InputStream inputStream = null;
		try {	
			frame.setTitle("Contact Manager");
			GridLayout gLayout = new GridLayout(0, 6);
			JPanel fieldspanel = new JPanel(gLayout);
			JPanel buttonPanel = new JPanel();
			// creating first name text field
			JLabel fnameLabel = new JLabel("  First Name ");
			fNameTextField = new JTextField();
			fieldspanel.add(fnameLabel);
			fieldspanel.add(fNameTextField);
			// creating middle name text field            
            JLabel mnameLabel = new JLabel("  Middle Name ");
			mNameTextField = new JTextField();
			fieldspanel.add(mnameLabel);
			fieldspanel.add(mNameTextField);
			// creating last name text field 
			JLabel lastnameLabel = new JLabel("  Last Name ");
			lastNameTextField = new JTextField();
			fieldspanel.add(lastnameLabel);
			fieldspanel.add(lastNameTextField);
			// creating contact_id text field
			JLabel contact_IdLabel = new JLabel("Contact Id ");
			contact_IdTextField = new JTextField();
			fieldspanel.add(contact_IdLabel);
			fieldspanel.add(contact_IdTextField);
            //// creating dob text field            
            JLabel bdateLabel = new JLabel("DOB ");
			bdateTextField = new JTextField();
			fieldspanel.add(bdateLabel);
			fieldspanel.add(bdateTextField);
			// creating phne number text field
			JLabel NumberLabel = new JLabel("Phone Number");
			NumberTexField = new JTextField();
			fieldspanel.add(NumberLabel);
			fieldspanel.add(NumberTexField);
			// creating number type text field
			JLabel typeLabel = new JLabel("Type of number");
			typeTextField = new JTextField();
			fieldspanel.add(typeLabel);
			fieldspanel.add(typeTextField);
			// creating code text field
            JLabel codeLabel = new JLabel("code");
			codeTextField = new JTextField();
			fieldspanel.add(codeLabel);
			fieldspanel.add(codeTextField);
			// creating email text field
            JLabel mail_idLabel = new JLabel(" Email");
			mail_idTextField = new JTextField();
			fieldspanel.add(mail_idLabel);
			fieldspanel.add(mail_idTextField);
			// creating email type text field
			JLabel mtypeLabel = new JLabel("Email type");
			mtypeTextField = new JTextField();
			fieldspanel.add(mtypeLabel);
			fieldspanel.add(mtypeTextField);
			JLabel address_idLabel = new JLabel("Address id");
			address_idTextField = new JTextField();
			fieldspanel.add(address_idLabel);
			fieldspanel.add(address_idTextField);
			JLabel countryLabel = new JLabel("country");
			countryTextField = new JTextField();
			fieldspanel.add(countryLabel);
			fieldspanel.add(countryTextField);
			JLabel stateLabel = new JLabel("state");
			stateTextField = new JTextField();
			fieldspanel.add(stateLabel);
			fieldspanel.add(stateTextField);
			JLabel cityLabel = new JLabel(" city");
			 cityTextField = new JTextField();
			fieldspanel.add(cityLabel);
			fieldspanel.add(cityTextField);
			JLabel streetLabel = new JLabel("street");
			 streetTextField = new JTextField();
			fieldspanel.add(streetLabel);
			fieldspanel.add(streetTextField);
			JLabel add_typeLabel = new JLabel("add_type");
			add_typeTextField = new JTextField();
			fieldspanel.add(add_typeLabel);
			fieldspanel.add(add_typeTextField);
			// creating search button
			JButton searchButton = new JButton("Search");
			searchButton.addActionListener(this);
            //creating add button
			JButton addButton = new JButton("Add");
			addButton.addActionListener(this);
            //creating update button
			JButton updateButton = new JButton("Update");
			updateButton.addActionListener(this);
            //creating delete button
			JButton deleteButton = new JButton("Delete");
			deleteButton.addActionListener(this);
	
			buttonPanel.add(searchButton);
			buttonPanel.add(addButton);
			buttonPanel.add(updateButton);
			buttonPanel.add(deleteButton);

			table = new JTable();
			tableModel = new DefaultTableModel(
		    new Object[] { "First Name", "Middle Name","Last Name", "contact_id", "DOB", "Phone Number",
		    		"Type of Number","code","Email","Email type","Address id",
		    		"country","state","city","street","add_type"}, 0);
			table.setModel(tableModel);
			JScrollPane scrollPanel = new JScrollPane();
			scrollPanel.setViewportView(table);
			Container cn = frame.getContentPane();
			cn.setLayout(new BoxLayout(cn, BoxLayout.Y_AXIS));
            //adding panels to the main frame
			frame.add(fieldspanel);
			frame.add(buttonPanel);
			frame.add(scrollPanel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		 try {
				String action = evt.getActionCommand();
				managerDb = new ContactManagerDb();
				
				// getting user input and converting it to java bean
				ContactManagerBean bean = new ContactManagerBean();
				bean.setfName(fNameTextField.getText());
				bean.setmName(lastNameTextField.getText());
				bean.setlName(lastNameTextField.getText());
                bean.setbdate(bdateTextField.getText());
				bean.setContact_id(contact_IdTextField.getText());	
				bean.setNumber(NumberTexField.getText());
				bean.settype(typeTextField.getText());
				bean.setcode(codeTextField.getText());
				
				bean.setmail_id(mail_idTextField.getText());
				bean.setmtype(mtypeTextField.getText());
				bean.setaddress_id(address_idTextField.getText());
				bean.setcountry(countryTextField.getText());
				bean.setstate(stateTextField.getText());
				bean.setcity(cityTextField.getText());
				bean.setstreet(streetTextField.getText());
				bean.setadd_type(add_typeTextField.getText());
				if(action.equals("Add"))
				{
					// method for add click
					managerDb.addContact(bean);
				}else if(action.equals("Update"))
				{
					managerDb.updateContact(bean);
				}else if(action.equals("Delete"))
				{
					managerDb.deleteContact(bean);
				}else if(action.equals("Search"))
				{
					List<ContactManagerBean> retriveList = managerDb.retriveContacts(bean);
					for (ContactManagerBean eachBean : retriveList){
						// adding each bean from list to table in screen
					    tableModel.addRow(new Object[]{eachBean.getfName(),eachBean.getmName(),eachBean.getlName(),eachBean.getContact_id(),eachBean.getbdate()
					    ,eachBean.getNumber(),eachBean.gettype(),eachBean.getcode(),eachBean.getmail_id(),
					    eachBean.getmtype(),eachBean.getaddress_id() ,eachBean.getcountry(),
					    eachBean.getstate(),eachBean.getcity(),eachBean.getstreet(),eachBean.getadd_type()});
					}
				}
		}
		catch(	Exception e){
			e.printStackTrace();
		}
	}
}

