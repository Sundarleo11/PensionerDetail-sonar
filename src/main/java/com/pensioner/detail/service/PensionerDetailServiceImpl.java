package com.pensioner.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensioner.detail.exception.AadharNumberNotFound;
import com.pensioner.detail.model.PensionerDetail;
import com.pensioner.detail.repository.PensionerDetailRepository;

@Service
public class PensionerDetailServiceImpl implements PensionerDetailService {

	@Autowired
	private PensionerDetailRepository pensionerDetailRepository;
	
	@Override
	public PensionerDetail getPensionerDetailByAadharCard(String token,long aadharNumber) throws AadharNumberNotFound
	{
		 return pensionerDetailRepository.findById(aadharNumber).orElseThrow(()-> new AadharNumberNotFound("Aadhar Card Number is not Valid. Please check it and try again"));		
	}
	
	public List<PensionerDetail> getAllPensioner(String token)
	{
		return pensionerDetailRepository.findAll();
	}
	
	
	
}
