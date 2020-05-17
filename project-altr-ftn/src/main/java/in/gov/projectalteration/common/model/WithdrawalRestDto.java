package in.gov.projectalteration.common.model;

import java.util.List;


public class WithdrawalRestDto {
	
	List<WithdrawalRequestModel> withdrawalList;

	public List<WithdrawalRequestModel> getWithdrawalList() {
		return withdrawalList;
	}

	public void setWithdrawalList(List<WithdrawalRequestModel> withdrawalList) {
		this.withdrawalList = withdrawalList;
	}
	
	
	
}
