package in.gov.projectalteration.common.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import in.gov.projectalteration.common.model.DmsModel;
import in.gov.projectalteration.common.model.WithdrawalRestDto;
import in.gov.projectalteration.model.transaction.AllotteeResponceModel;
import in.gov.projectalteration.projectapp.dto.ProjectAppRegistrationModel;

public class UserRestTemplateServices {

	public static DmsModel saveDoc(DmsModel entity, String url) {
		System.out.println("saveDoc :" + url);
		RestTemplate restTemplate = new RestTemplate();
		DmsModel document = restTemplate.postForObject(url, entity, DmsModel.class);
		return document;
	}

	/*********************************************************************************************
	 * getProjectAppDetails
	 *********************************************************************************************/
	public static ProjectAppRegistrationModel getProjectAppDetails(ProjectAppRegistrationModel entity, String url) {
		System.out.println("getProjectAppDetails :" + url);
		ProjectAppRegistrationModel project = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			project = restTemplate.getForObject(url, ProjectAppRegistrationModel.class);
		} catch (Exception e) {
			throw new ResourceAccessException("project Details failed");
		}
		return project;
	}

	/*********************************************************************************************
	 * updateProjectAppDetailsRestApiCall
	 *********************************************************************************************/
	public static ProjectAppRegistrationModel updateProjectAppDetailsRestApiCall(ProjectAppRegistrationModel request,
			String url) {
		System.out.println("#######################################################################");
		System.out.println("updateProjectAppDetailsRestApiCall : start in alteration section 15");

		ProjectAppRegistrationModel responseType = null;
		try {
			System.out.println(" url:" + url);
			System.out.println(" request:" + request);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject(url, request, ProjectAppRegistrationModel.class);
			responseType = restTemplate.postForObject(url, request, ProjectAppRegistrationModel.class);
		} catch (Exception e) {
			throw new ResourceAccessException("Failed to find project Details in alteration section 15."+e);
		}
		return responseType;
	}

	public static Map<String,Object>  updateBankDtl(Map<String, Object> map,String url) {
		System.out.println("UPDATE Start : BANK DTL after stage 2 approval in section 15::::::::::::::");
		RestTemplate restTemplate = new RestTemplate();
		Map<String,Object> bankDtl = restTemplate.postForEntity(url, map,HashMap.class).getBody();
		System.out.println("UPDATE End : BANK DTL after stage 2 approval in section 15::::::::::::::");
		return bankDtl;
		   }
	
	public static Map<String,Object>  updatePromoterDtl(Map<String, Object> map,String url) {
		System.out.println("UPDATE Start : Promoter DTL after stage 2 approval in section 15::::::::::::::");
		RestTemplate restTemplate = new RestTemplate();
		Map<String,Object> promoter = restTemplate.postForEntity(url, map,HashMap.class).getBody();
		System.out.println("UPDATE End : Promoter DTL after stage 2 approval in section 15::::::::::::::");
		return promoter;
		   }
	
	/*********************************************************************************************
	 * getAlloteeDetailsRestApiCall
	 *********************************************************************************************/
	public static AllotteeResponceModel getAlloteeDetailsRestApiCall(String url) {
		System.out.println("#######################################################################");
		System.out.println("getAlloteeDetailsRestApiCall : start");
		AllotteeResponceModel responseType = null;
		try {
			System.out.println(" url:" + url);
			RestTemplate restTemplate = new RestTemplate();
			responseType = restTemplate.getForObject(url, AllotteeResponceModel.class);
		} catch (Exception e) {
			throw new ResourceAccessException("Allotee Details are not found");
		}
		return responseType;
	}

	public static WithdrawalRestDto getByWidralStateCode(String url) {
		System.out.println("getByWidralStateCode : start==== " + url);
		WithdrawalRestDto dto = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			dto = restTemplate.getForObject(url, WithdrawalRestDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
