package com.cg.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.ui.DataConnection;

public class FlatRegistrationDaoImpl implements IFlatRegistrationDao {

	static Scanner sc = new Scanner(System.in);
	DataConnection dataConnection=new DataConnection() ;
	FlatRegistrationDTO flatRegistrationDTO=null;
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flatRegistrationDTO) {
		// TODO Auto-generated method stub
		int owner = flatRegistrationDTO.getOwnerid();
		double rentAmount = flatRegistrationDTO.getRentAmount();
		double depositAmount = flatRegistrationDTO.getDepositAmount();
		if (rentAmount > depositAmount) {
			System.err.println("deposit amount should be more than rent amount");
		}
		
		Connection con = dataConnection.connect();
		try {
			PreparedStatement preparedStatement=con.prepareStatement("insert into flat_registration values(?,?,?,?,?,?)");
		    preparedStatement.setLong(1,flatRegistrationDTO.getFlatRegNo());
		    preparedStatement.setInt(2, flatRegistrationDTO.getOwnerid());
		    preparedStatement.setInt(3, flatRegistrationDTO.getFlatType());
		    preparedStatement.setInt(4, flatRegistrationDTO.getFlatArea());
		    preparedStatement.setDouble(5, flatRegistrationDTO.getRentAmount());
		    preparedStatement.setDouble(6, flatRegistrationDTO.getDepositAmount());
		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement preparedStatement1=con.prepareStatement("Select flat_reg_no from flat_registration where owner_id = ?");
			preparedStatement1.setInt(1, flatRegistrationDTO.getOwnerid());

			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while(resultSet1.next()) {
				flatRegistrationDTO.setFlatRegNo(resultSet1.getLong(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return flatRegistrationDTO;
	}


	public ArrayList<Integer> getAllOwnerIds() {
		// TODO Auto-generated method stub
		//ArrayList<Integer> arrayList = null;
		
		
		Connection con=dataConnection.connect();
		try {
			Statement statement = con.createStatement();
			ResultSet resultset = statement.executeQuery("select * from flat_owners");
			while (resultset.next()) {

				arrayList.add(resultset.getInt(1));
				System.out.println(resultset.getInt(1));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

}
