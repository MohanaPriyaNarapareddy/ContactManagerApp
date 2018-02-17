package com.mp.contactmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mp.contactmanager.beans.ContactManagerBean;

public class ContactManagerDb {
	private static Connection conn;
	private Statement stmt;

	public ContactManagerDb() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager
				.getConnection("jdbc:mysql://localhost/contactmngr?user=root&password=Mohana@1");
		stmt = conn.createStatement();
	}

	public void addContact(ContactManagerBean bean) throws Exception {

		String mname = "";
		String query = "INSERT INTO PERSON VALUES ('"; //insert query of person table

		query = query + bean.getfName() + "','" + bean.getmName() + "','"
				+ bean.getlName() + "','" + bean.getbdate() + "','"
				+ bean.getContact_id() + "')";
		stmt.execute(query);
		query = "INSERT INTO  PHONE VALUES ('" + bean.getNumber() + "','" //insert query of phone table
				+ bean.getContact_id() + "','" + bean.gettype() + "','"
				+ bean.getcode() + "')";
		stmt.execute(query);
		query = "INSERT INTO  E_MAILS VALUES ('" + bean.getmail_id() + "','" //insert query of e_mails
				+ bean.getContact_id() + "','" + bean.gettype() + "')";
		stmt.execute(query);
		query = "INSERT INTO  ADDRESS VALUES ('" + bean.getaddress_id() + "','" //insert query of e_mails
				+ bean.getContact_id() + "','" + bean.getcountry() + "','" +bean.getstate() + "','"+bean.getcity() + "','"+bean.getstreet() + "','"+bean.getadd_type()+"')";
		stmt.execute(query);
		JOptionPane.showMessageDialog(null, "Contact Added Succesfully.",
				"Success", JOptionPane.INFORMATION_MESSAGE);
	}
	public void updateContact(ContactManagerBean bean) throws Exception {
		String query = "UPDATE  PERSON SET fname = '"; //update query of table person
		query = query + bean.getfName() + "',mname = '" + bean.getmName()
				+ "',lName = '" + bean.getlName() + "',bdate= '"
				+ bean.getbdate() + "' where contact_id='"
				+ bean.getContact_id() + "'";
		System.out.println("query==>" + query);
		stmt.execute(query);
		String query1 = "UPDATE  PHONE SET Number= '"; //update query of table phone
		query1 = query1 + bean.getNumber() + "',type= '" + bean.gettype()
				+ "',code = '" + bean.getcode() + "' where contact_id='"
				+ bean.getContact_id() + "'";
		System.out.println("query1==>" + query1);
		stmt.execute(query1);
		String query2 = "UPDATE  E_MAILS SET mail_id= '"; //update query of table e_mails
		query2 = query2 + bean.getmail_id() + "',type= '" + bean.getmtype()
				+ "' where contact_id='" + bean.getContact_id() + "'";
		System.out.println("query2==>" + query2);
		stmt.execute(query2);
		String query5 = "UPDATE  ADDRESS SET add_id= '"; //update query of table e_mails
		query5 = query5+ bean.getaddress_id() + "',country= '" + bean.getcountry() + 
				"',state= '" + bean.getstate()+ "',city= '" + bean.getcity()+ "',street= '" + bean.getstreet()+
				"',type= '" + bean.getadd_type()
				+ "' where contact_id='" + bean.getContact_id() + "'";
		System.out.println("query5==>" + query5);
		stmt.execute(query5);
		JOptionPane.showMessageDialog(null, "Contact Updated Succesfully.",
				"Success", JOptionPane.INFORMATION_MESSAGE);
	}
	public void deleteContact(ContactManagerBean bean) throws Exception {
		
		String query3 = "DELETE FROM PHONE WHERE contact_id='" +bean.getContact_id()+"'"; //delete query of table phone
		stmt.execute(query3); 
		String query4 = "DELETE FROM E_MAILS WHERE contact_id='" +bean.getContact_id()+"'"; //delete query of table e_mails
		stmt.execute(query4); 
		String query6 = "DELETE FROM ADDRESS WHERE contact_id='" +bean.getContact_id()+"'"; 
		stmt.execute(query6); 
		String query = "DELETE FROM PERSON WHERE contact_id='" +bean.getContact_id()+"'"; //delete query of table person
		stmt.execute(query);
		JOptionPane.showMessageDialog(null, "Contact Deleted Succesfully.",
				"Success", JOptionPane.INFORMATION_MESSAGE);
	}
	public List<ContactManagerBean> retriveContacts(ContactManagerBean bean)
			throws Exception {
		List<ContactManagerBean> retriveList = new ArrayList<ContactManagerBean>();
		String query = "select * from person  pr left join PHONE phn on pr.contact_id = phn.contact_id " +
				" left join E_MAILS eml on eml.contact_id = pr.contact_id"+ " left join ADDRESS ad on ad.contact_id = pr.contact_id  where pr.contact_id is not null ";
		
		if (bean.getfName() != null && !bean.getfName().trim().equals(""))
			query = query + " and pr.fname= '" + bean.getfName() + "'";
		 if (bean.getmName() != null && !bean.getmName().trim().equals(""))
			query = query + " and pr.mname= '" + bean.getmName() + "'";
		if (bean.getlName() != null && !bean.getlName().trim().equals(""))
			query = query + " and pr.lname= '" + bean.getlName() + "'";
		 if (bean.getContact_id() != null
				&& !bean.getContact_id().trim().equals(""))
			query = query + " and pr.contact_id = '" + bean.getContact_id()
					+ "'";
		 if (bean.getbdate() != null && !bean.getbdate().trim().equals(""))
			query = query + " and pr.bdate  = '" + bean.getbdate() + "'";
		ResultSet rs = stmt.executeQuery(query);
		ContactManagerBean eachBean = new ContactManagerBean();
		while (rs.next()) {
			eachBean.setfName(rs.getString("fname"));
			eachBean.setmName(rs.getString("mname"));
			eachBean.setlName(rs.getString("lname"));
			eachBean.setContact_id(rs.getString("pr.contact_id"));
			eachBean.setbdate(rs.getString("bdate"));
			eachBean.setNumber(rs.getString("number"));
			eachBean.settype(rs.getString("phn.type"));
			eachBean.setcode(rs.getString("code"));
			eachBean.setmail_id(rs.getString("mail_id"));
			eachBean.setmtype(rs.getString("eml.type"));
			eachBean.setmtype(rs.getString("ad.add_id"));
			eachBean.setmtype(rs.getString("country"));
			eachBean.setmtype(rs.getString("state"));
			eachBean.setmtype(rs.getString("city"));
			eachBean.setmtype(rs.getString("ad.street"));
			eachBean.setmtype(rs.getString("ad.type"));
			retriveList.add(eachBean);
			eachBean = new ContactManagerBean();
		}
		return retriveList;
	}
}
