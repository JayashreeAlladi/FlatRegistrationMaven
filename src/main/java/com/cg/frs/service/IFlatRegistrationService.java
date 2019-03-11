package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

public interface IFlatRegistrationService {
     FlatRegistrationDTO registerFlat(FlatRegistrationDTO flatRegistrationDTO);
     ArrayList<Integer> getAllOwnerIds();
}
