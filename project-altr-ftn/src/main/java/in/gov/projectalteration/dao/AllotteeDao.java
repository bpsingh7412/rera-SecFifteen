package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.AllotteeDetailModel;
@Repository
public interface AllotteeDao extends JpaRepository<AllotteeDetailModel, Long> {
	 public List<AllotteeDetailModel> findByAllotteeMobile(String allotteeMobile);
	 public List<AllotteeDetailModel> findByPrjAltIdAndAllotteeMobile(Long prjId,String allotteeMobile);
	 
	 public AllotteeDetailModel findByKycIdAndPrjId(String kycId,Long prjId);
}
