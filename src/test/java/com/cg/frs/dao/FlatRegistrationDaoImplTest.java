package com.cg.frs.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.frs.dto.FlatRegistrationDTO;


import org.junit.jupiter.api.Test;

class FlatRegistrationDaoImplTest {

	static FlatRegistrationDaoImpl flatRegistrationDaoImpl;
	@BeforeAll
	public static void init() {
		flatRegistrationDaoImpl = new FlatRegistrationDaoImpl();
	}

		@Test
		void testRegisterFlat() {
			FlatRegistrationDTO flatRegistrationDTO = new FlatRegistrationDTO();
			FlatRegistrationDTO flat= new FlatRegistrationDTO();
			flatRegistrationDTO.setOwnerid(2);
			flatRegistrationDTO.setFlatType(1);
			flatRegistrationDTO.setFlatArea(20);
			flatRegistrationDTO.setRentAmount(200);
			flatRegistrationDTO.setDepositAmount(2000);
			flat = flatRegistrationDaoImpl.registerFlat(flatRegistrationDTO);
			assertEquals(1003,flat.getFlatRegNo());
		}

		@Test
		void testGetAllOwnerIds() {
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(1);
			al.add(2);
			al.add(3);
			assertEquals(al, flatRegistrationDaoImpl.getAllOwnerIds());
		}

}


