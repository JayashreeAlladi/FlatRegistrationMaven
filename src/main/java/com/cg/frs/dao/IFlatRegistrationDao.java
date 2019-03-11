package com.cg.frs.dao;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

public interface IFlatRegistrationDao {
	 FlatRegistrationDTO registerFlat(FlatRegistrationDTO flatRegistrationDTO);
	 ArrayList<Integer> getAllOwnerIds();
}
    