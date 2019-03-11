package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.FlatRegistrationDaoImpl;
import com.cg.frs.dao.IFlatRegistrationDao;
import com.cg.frs.dto.FlatRegistrationDTO;


public class FlatRegistrationServiceImpl implements IFlatRegistrationService{
  
	IFlatRegistrationDao iFlatRegistrationDao=new FlatRegistrationDaoImpl();
	
    FlatRegistrationDTO flatRegistrationDTO=new FlatRegistrationDTO();
    
	public ArrayList<Integer> getAllOwnerIds() {
		ArrayList<Integer> arrayList=iFlatRegistrationDao.getAllOwnerIds();
		return arrayList;
	}

	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flatRegistrationDTO) {
		// TODO Auto-generated method stub
		flatRegistrationDTO=iFlatRegistrationDao.registerFlat(flatRegistrationDTO);
		return flatRegistrationDTO;
	}
  
}
