package com.cg.frs.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exceptionhandling.FlatAreaException;
import com.cg.frs.exceptionhandling.FlatTypeException;
import com.cg.frs.exceptionhandling.OwnerIdException;
import com.cg.frs.service.FlatRegistrationServiceImpl;
import com.cg.frs.service.IFlatRegistrationService;

public class Client {
    public static void main(String[] args) {
    	FlatRegistrationDTO flatRegistrationDTO=new  FlatRegistrationDTO();
    	IFlatRegistrationService flatRegistrationService=new FlatRegistrationServiceImpl();
    	
    	while(true) {
    	System.out.println("====Flat Registration====");
    	System.out.println("enter \n 1.Register flat\n 2.Exit");
    	Scanner scanner=new Scanner(System.in);
    	int choice=scanner.nextInt();
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	switch(choice) {
    	case 1:
    		System.out.print("Existing Owner Ids are:");
    		arrayList=flatRegistrationService.getAllOwnerIds();
    		System.out.print("Please enter your Owner id from above list:");
    		int ownerid=scanner.nextInt();
    		
    		if(arrayList.contains(ownerid))
    		{
    		  flatRegistrationDTO.setOwnerid(ownerid);
    		 System.out.print("select flat type [1-1 BHK,2-2 BHK]:");
    		 int flatType=scanner.nextInt();
    		 if(flatType==1 ||flatType==2) 
    		 {
               flatRegistrationDTO.setFlatType(flatType);
    		   System.out.print("Enter Flat area in sq.ft");
    		   int flatArea=scanner.nextInt();
    		   
    		    if(flatArea>0)
    		    {
    	        flatRegistrationDTO.setFlatArea(flatArea);
    		    System.out.print("Enter desired rent amount Rs:");
                flatRegistrationDTO.setRentAmount(scanner.nextDouble());
    		     System.out.print("Enter desired deposit amount Rs:");
    		    flatRegistrationDTO.setDepositAmount(scanner.nextDouble());
             
			    flatRegistrationDTO=flatRegistrationService.registerFlat(flatRegistrationDTO);
			     if (flatRegistrationDTO != null) {
					System.out.println("Flat Registration successfully done.\n Registration id:<"
							+ flatRegistrationDTO.getFlatRegNo() + ">");
				 } else
					System.out.println("Registration Failed");
    		      }
    		    else {
  			     try {
						throw new FlatAreaException();
					} catch (FlatAreaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
  		         }
    		 }
    		 else {
   			    try {
 						throw new FlatTypeException();
 					} catch (FlatTypeException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					} 
   		        }
    		}
    		
    	 else {
    		   try {
  				throw new OwnerIdException();
  				} catch (OwnerIdException e) {
					// TODO Auto-generated catch block
  				e.printStackTrace();
  	    		} 
    	   }  
    		  
          
    	case 2:
    		System.out.println("Thank you");
    		System.exit(0);
    	}
      }
    }
}
