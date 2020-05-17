package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProjectAppDetailModel implements Serializable {

	private static final long serialVersionUID = -2764595446344571527L;

	private Long id;

	private Long prjRegId;// reference

	private String projectName;

	private String projectType;

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/YYYY")

	private Calendar startDate;

	private Calendar completionDate;

	private String projectStatus;

	private String projectDesc;

	private String projectAddress;

	private String projectAddress2;

	private String stateCode;

	private String stateName;

	private String distCode;

	private String distName;

	private String subDistCode;

	private String subDistName;

	private String openParkingArea;

	private String airportDistance;
	private String ulbServiceDelivery;
	private String publicTransit;
	private String publicGarden;
	private String policeStation;
	private String mainRailwayStation;
	private String multiSpecialityHospital;
	private String fireStation;

	private String waterLevel;
	private String waterLevelFlag;
	private String dateOfSoilReport;
	private Long soilReportId;
	private String soilReportUid;

	/* Land details */
	private String pinCode;
	private String moje; // multiple value addmore
	private String revenueSurveyNo;
	private String blockNo;
	private String citySurveyNo;

	/* TP details */

	private String validTpName;

	/* Non TP details */
	private String tPNo;
	private String plotNo;
	private String tPName;
	private String finalPlotNo;
	private String subPlotNumber;
	private String buildingBlocks;

	private Double totAreaOfLand;

	private Double totAreaOfLandLayout;

	private Double totLandAreaForProjectUnderReg;

	private Double totCarpetArea;

	private Double totalCarpetAreaForSellable;

	private Double totCarpetAreaUnderLayout;

	private Double totCarpetAreaForProjectUnderReg;

	private Double totCoverdArea;

	private Double totOpenArea;

	private Double areaOfGarageForSale;

	private Double hardCopySubmitionOffice;

	private Double areaOfParkinfForSale;

	private Double coveredParkingArea;

	private Integer coveredParking;

	private Integer noOfParkinfForSale;

	private Integer noOfGarageForSale;

	private Integer garageSoldout;

	private Integer noOfMonthDelayed;

	private Long costOfLand;

	private Long estimatedCost;

	private Long totalProjectCost;

	private String reasonForDelayed;

	private String officeCode;

	private String officeName;

	/*************************************************
	 * Document
	 *************************************************/
	private Long compeletionCertDocId;

	private String compeletionCertDocUId;

	private Long declarationFormbNewDocId;

	private String declarationFormbNewDocUId;

	private Long projectCertDocId;

	private String projectCertDocUId;

	private Long projectRevokeDocId;

	private String projectRevokeDocUId;

	/*************************************************
	 * Approver
	 *************************************************/

	private String approvingAuthority;

	private Date modifiedOn;

	private String modifiedBy;

	private Calendar updatedOn;
	
	
	

	public String getWaterLevelFlag() {
		return waterLevelFlag;
	}

	public void setWaterLevelFlag(String waterLevelFlag) {
		this.waterLevelFlag = waterLevelFlag;
	}

	public String getAirportDistance() {
		return airportDistance;
	}

	public void setAirportDistance(String airportDistance) {
		this.airportDistance = airportDistance;
	}

	public String getUlbServiceDelivery() {
		return ulbServiceDelivery;
	}

	public void setUlbServiceDelivery(String ulbServiceDelivery) {
		this.ulbServiceDelivery = ulbServiceDelivery;
	}

	public String getPublicTransit() {
		return publicTransit;
	}

	public void setPublicTransit(String publicTransit) {
		this.publicTransit = publicTransit;
	}

	public String getPublicGarden() {
		return publicGarden;
	}

	public void setPublicGarden(String publicGarden) {
		this.publicGarden = publicGarden;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getMainRailwayStation() {
		return mainRailwayStation;
	}

	public void setMainRailwayStation(String mainRailwayStation) {
		this.mainRailwayStation = mainRailwayStation;
	}

	public String getMultiSpecialityHospital() {
		return multiSpecialityHospital;
	}

	public void setMultiSpecialityHospital(String multiSpecialityHospital) {
		this.multiSpecialityHospital = multiSpecialityHospital;
	}

	public String getFireStation() {
		return fireStation;
	}

	public void setFireStation(String fireStation) {
		this.fireStation = fireStation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrjRegId() {
		return prjRegId;
	}

	public void setPrjRegId(Long prjRegId) {
		this.prjRegId = prjRegId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public void setStartDatestr(String startDate) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd");
		Date d = dateFormat.parse(startDate);
		System.out.println("startDatestartDatestartDate " + startDate);
		this.startDate = Calendar.getInstance();
		this.startDate.setTime(d);
		System.out.println(" this.startDate this.startDate this.startDate " + this.startDate);
	}

	public Calendar getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Calendar completionDate) {
		this.completionDate = completionDate;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistCode() {
		return distCode;
	}

	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public String getSubDistCode() {
		return subDistCode;
	}

	public void setSubDistCode(String subDistCode) {
		this.subDistCode = subDistCode;
	}

	public String getSubDistName() {
		return subDistName;
	}

	public void setSubDistName(String subDistName) {
		this.subDistName = subDistName;
	}

	public Double getTotAreaOfLand() {
		return totAreaOfLand;
	}

	public void setTotAreaOfLand(Double totAreaOfLand) {
		this.totAreaOfLand = totAreaOfLand;
	}

	public Double getTotLandAreaForProjectUnderReg() {
		return totLandAreaForProjectUnderReg;
	}

	public void setTotLandAreaForProjectUnderReg(Double totLandAreaForProjectUnderReg) {
		this.totLandAreaForProjectUnderReg = totLandAreaForProjectUnderReg;
	}

	public Double getTotCarpetAreaUnderLayout() {
		return totCarpetAreaUnderLayout;
	}

	public void setTotCarpetAreaUnderLayout(Double totCarpetAreaUnderLayout) {
		this.totCarpetAreaUnderLayout = totCarpetAreaUnderLayout;
	}

	public Double getTotCarpetAreaForProjectUnderReg() {
		return totCarpetAreaForProjectUnderReg;
	}

	public void setTotCarpetAreaForProjectUnderReg(Double totCarpetAreaForProjectUnderReg) {
		this.totCarpetAreaForProjectUnderReg = totCarpetAreaForProjectUnderReg;
	}

	public Double getTotCoverdArea() {
		return totCoverdArea;
	}

	public void setTotCoverdArea(Double totCoverdArea) {
		this.totCoverdArea = totCoverdArea;
	}

	public Double getTotOpenArea() {
		return totOpenArea;
	}

	public void setTotOpenArea(Double totOpenArea) {
		this.totOpenArea = totOpenArea;
	}

	public Double getAreaOfGarageForSale() {
		return areaOfGarageForSale;
	}

	public void setAreaOfGarageForSale(Double areaOfGarageForSale) {
		this.areaOfGarageForSale = areaOfGarageForSale;
	}

	public Double getAreaOfParkinfForSale() {
		return areaOfParkinfForSale;
	}

	public void setAreaOfParkinfForSale(Double areaOfParkinfForSale) {
		this.areaOfParkinfForSale = areaOfParkinfForSale;
	}

	public Double getCoveredParkingArea() {
		return coveredParkingArea;
	}

	public void setCoveredParkingArea(Double coveredParkingArea) {
		this.coveredParkingArea = coveredParkingArea;
	}

	public Integer getCoveredParking() {
		return coveredParking;
	}

	public void setCoveredParking(Integer coveredParking) {
		this.coveredParking = coveredParking;
	}

	public Integer getNoOfParkinfForSale() {
		return noOfParkinfForSale;
	}

	public void setNoOfParkinfForSale(Integer noOfParkinfForSale) {
		this.noOfParkinfForSale = noOfParkinfForSale;
	}

	public Integer getNoOfGarageForSale() {
		return noOfGarageForSale;
	}

	public void setNoOfGarageForSale(Integer noOfGarageForSale) {
		this.noOfGarageForSale = noOfGarageForSale;
	}

	public Integer getGarageSoldout() {
		return garageSoldout;
	}

	public void setGarageSoldout(Integer garageSoldout) {
		this.garageSoldout = garageSoldout;
	}

	public Integer getNoOfMonthDelayed() {
		return noOfMonthDelayed;
	}

	public void setNoOfMonthDelayed(Integer noOfMonthDelayed) {
		this.noOfMonthDelayed = noOfMonthDelayed;
	}

	public Long getCostOfLand() {
		return costOfLand;
	}

	public void setCostOfLand(Long costOfLand) {
		this.costOfLand = costOfLand;
	}

	public Long getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Long estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Long getTotalProjectCost() {
		return totalProjectCost;
	}

	public void setTotalProjectCost(Long totalProjectCost) {
		this.totalProjectCost = totalProjectCost;
	}

	public String getReasonForDelayed() {
		return reasonForDelayed;
	}

	public void setReasonForDelayed(String reasonForDelayed) {
		this.reasonForDelayed = reasonForDelayed;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Long getCompeletionCertDocId() {
		return compeletionCertDocId;
	}

	public void setCompeletionCertDocId(Long compeletionCertDocId) {
		this.compeletionCertDocId = compeletionCertDocId;
	}

	public String getCompeletionCertDocUId() {
		return compeletionCertDocUId;
	}

	public void setCompeletionCertDocUId(String compeletionCertDocUId) {
		this.compeletionCertDocUId = compeletionCertDocUId;
	}

	public Long getDeclarationFormbNewDocId() {
		return declarationFormbNewDocId;
	}

	public void setDeclarationFormbNewDocId(Long declarationFormbNewDocId) {
		this.declarationFormbNewDocId = declarationFormbNewDocId;
	}

	public String getDeclarationFormbNewDocUId() {
		return declarationFormbNewDocUId;
	}

	public void setDeclarationFormbNewDocUId(String declarationFormbNewDocUId) {
		this.declarationFormbNewDocUId = declarationFormbNewDocUId;
	}

	public Long getProjectCertDocId() {
		return projectCertDocId;
	}

	public void setProjectCertDocId(Long projectCertDocId) {
		this.projectCertDocId = projectCertDocId;
	}

	public String getProjectCertDocUId() {
		return projectCertDocUId;
	}

	public void setProjectCertDocUId(String projectCertDocUId) {
		this.projectCertDocUId = projectCertDocUId;
	}

	public Long getProjectRevokeDocId() {
		return projectRevokeDocId;
	}

	public void setProjectRevokeDocId(Long projectRevokeDocId) {
		this.projectRevokeDocId = projectRevokeDocId;
	}

	public String getProjectRevokeDocUId() {
		return projectRevokeDocUId;
	}

	public void setProjectRevokeDocUId(String projectRevokeDocUId) {
		this.projectRevokeDocUId = projectRevokeDocUId;
	}

	public String getApprovingAuthority() {
		return approvingAuthority;
	}

	public void setApprovingAuthority(String approvingAuthority) {
		this.approvingAuthority = approvingAuthority;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Calendar getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Calendar updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Double getHardCopySubmitionOffice() {
		return hardCopySubmitionOffice;
	}

	public void setHardCopySubmitionOffice(Double hardCopySubmitionOffice) {
		this.hardCopySubmitionOffice = hardCopySubmitionOffice;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getMoje() {
		return moje;
	}

	public void setMoje(String moje) {
		this.moje = moje;
	}

	public String getRevenueSurveyNo() {
		return revenueSurveyNo;
	}

	public void setRevenueSurveyNo(String revenueSurveyNo) {
		this.revenueSurveyNo = revenueSurveyNo;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getCitySurveyNo() {
		return citySurveyNo;
	}

	public void setCitySurveyNo(String citySurveyNo) {
		this.citySurveyNo = citySurveyNo;
	}

	public String gettPNo() {
		return tPNo;
	}

	public void settPNo(String tPNo) {
		this.tPNo = tPNo;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String gettPName() {
		return tPName;
	}

	public void settPName(String tPName) {
		this.tPName = tPName;
	}

	public String getFinalPlotNo() {
		return finalPlotNo;
	}

	public void setFinalPlotNo(String finalPlotNo) {
		this.finalPlotNo = finalPlotNo;
	}

	public String getSubPlotNumber() {
		return subPlotNumber;
	}

	public void setSubPlotNumber(String subPlotNumber) {
		this.subPlotNumber = subPlotNumber;
	}

	public String getBuildingBlocks() {
		return buildingBlocks;
	}

	public void setBuildingBlocks(String buildingBlocks) {
		this.buildingBlocks = buildingBlocks;
	}

	public String getProjectAddress2() {
		return projectAddress2;
	}

	public void setProjectAddress2(String projectAddress2) {
		this.projectAddress2 = projectAddress2;
	}

	public String getValidTpName() {
		return validTpName;
	}

	public void setValidTpName(String validTpName) {
		this.validTpName = validTpName;
	}

	public String getOpenParkingArea() {
		return openParkingArea;
	}

	public void setOpenParkingArea(String openParkingArea) {
		this.openParkingArea = openParkingArea;
	}

	public String getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(String waterLevel) {
		this.waterLevel = waterLevel;
	}

	public String getDateOfSoilReport() {
		return dateOfSoilReport;
	}

	public void setDateOfSoilReport(String dateOfSoilReport) {
		this.dateOfSoilReport = dateOfSoilReport;
	}

	public Long getSoilReportId() {
		return soilReportId;
	}

	public void setSoilReportId(Long soilReportId) {
		this.soilReportId = soilReportId;
	}

	public String getSoilReportUid() {
		return soilReportUid;
	}

	public void setSoilReportUid(String soilReportUid) {
		this.soilReportUid = soilReportUid;
	}

	public Double getTotAreaOfLandLayout() {
		return totAreaOfLandLayout;
	}

	public void setTotAreaOfLandLayout(Double totAreaOfLandLayout) {
		this.totAreaOfLandLayout = totAreaOfLandLayout;
	}

	public Double getTotCarpetArea() {
		return totCarpetArea;
	}

	public void setTotCarpetArea(Double totCarpetArea) {
		this.totCarpetArea = totCarpetArea;
	}

	public Double getTotalCarpetAreaForSellable() {
		return totalCarpetAreaForSellable;
	}

	public void setTotalCarpetAreaForSellable(Double totalCarpetAreaForSellable) {
		this.totalCarpetAreaForSellable = totalCarpetAreaForSellable;
	}

}
