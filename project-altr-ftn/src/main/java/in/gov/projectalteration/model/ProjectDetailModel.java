package in.gov.projectalteration.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "ProjectDetailModel")
@Table(name = "TL_PROJECT_ALT_DETAIL")
public class ProjectDetailModel implements Serializable {

	private static final long serialVersionUID = -2764595446344571527L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prj_alt_dtl_id")
	private Long altprojectDetailId;

	//@NotNull(message = "Project Alteration must not be empty")
	@Column(name = "PRJ_ALT_ID_DTL_FK")
	private Long projectAltrId;// reference

	//@NotNull(message = "projectName must not be empty")
	@Column(name = "PRJ_NAME")
	private String projectName;

	//@NotNull(message = "projectType must not be empty")
	@Column(name = "PRJ_TYPE")
	private String projectType;

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/YYYY")

	@Column(name = "PRJ_START_DATE")
	private Calendar startDate;

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/YYYY")
	@Column(name = "PRJ_COMPLETION_DATE")
	private Calendar completionDate;

	@Column(name = "PRJ_STATUS")
	private String projectStatus;
	
	@Column(name = "EXPLANATORYNOTE")
	private String explanatoryNote;
	
	@Column(name = "PROJECT_SPECIFICATION")
	private String projectSpecification;
	
	
	

	@Column(name = "PRJ_DESC")
	private String projectDesc;

	@Column(name = "PRJ_ADDRESS")
	private String projectAddress;

	@Column(name = "PRJ_ADDRESS2")
	private String projectAddress2;

	@Column(name = "PRJ_STATE_CODE")
	private String stateCode;

	@Column(name = "PRJ_SATE_NAME")
	private String stateName;

	@Column(name = "PRJ_DISTRICT_CODE")
	private String distCode;

	@Column(name = "PRJ_DISTRICT_NAME")
	private String distName;

	@Column(name = "PRJ_SUB_DISTRICT_CODE")
	private String subDistCode;

	@Column(name = "PRJ_SUB_DISTRICT_NAME")
	private String subDistName;

	@Column(name = "PRJ_OPEN_PARKING_AREA")
	private String openParkingArea;

	@Column(name = "PRJ_AIRPORT_KM")
	private String airportDistance;
	@Column(name = "PRJ_UBLSERVICES_KM")
	private String ulbServiceDelivery;
	@Column(name = "PRJ_PUBLICTRANSMIT_KM")
	private String publicTransit;
	@Column(name = "PRJ_PUBLICGARDEN_KM")
	private String publicGarden;
	@Column(name = "PRJ_POLICE_STATION_KM")
	private String policeStation;
	@Column(name = "PRJ_MAIN_RAILWAYSTATION_KM")
	private String mainRailwayStation;
	@Column(name = "PRJ_MLTSPCLITY_HOSPITAL_KM")
	private String multiSpecialityHospital;
	@Column(name = "PRJ_FIRE_STATION_KM")
	private String fireStation;

	/* Land details */
	@Column(name = "PRJ_PIN_CODE")
	private String pinCode;
	@Column(name = "PRJ_MOJE")
	private String moje; // multiple value addmore
	@Column(name = "PRJ_REVENUE_SURVEY_NO")
	private String revenueSurveyNo;
	@Column(name = "PRJ_BLOCK_NO")
	private String blockNo;
	@Column(name = "PRJ_CITY_SURVEY_NO")
	private String citySurveyNo;

	/* TP details */

	@Column(name = "PRJ_TP_NAME")
	private String validTpName;

	/* Non TP details */
	@Column(name = "PRJ_TP_NO")
	private String tPNo;
	@Column(name = "PRJ_PLOT_NO")
	private String plotNo;
	@Column(name = "PRJ_TPNAME_NO")
	private String tPName;
	@Column(name = "PRJ_FINAL_PLOT__NO")
	private String finalPlotNo;
	@Column(name = "PRJ_SUB_PLOT_NO")
	private String subPlotNumber;
	@Column(name = "PRJ_BUILDING_BLOCK_NO")
	private String buildingBlocks;

	@Column(name = "PRJ_TOTAL_LAND_AREA")
	private Double totAreaOfLand;

	@Column(name = "PRJ_TOTAL_LAND_AREA_LAYOUT")
	private Double totAreaOfLandLayout;

	@Column(name = "PRJ_TTL_LAND_AREA_FOR_PRJ_UNDER_REG")
	private Double totLandAreaForProjectUnderReg;

	@Column(name = "PRJ_TTL_CARPET_AREA")
	private Double totCarpetArea;

	@Column(name = "PRJ_TTL_CARPET_AREA_SELLABLE")
	private Double totalCarpetAreaForSellable;

	@Column(name = "PRJ_TTL_CARPET_AREA_UNDER_LAYOUT")
	private Double totCarpetAreaUnderLayout;

	@Column(name = "PRJ_TTL_CARPET_AREA_FOR_PROJECT_UNDER_REG")
	private Double totCarpetAreaForProjectUnderReg;

	@Column(name = "PRJ_TTL_COVERED_AREA")
	private Double totCoverdArea;

	@Column(name = "PRJ_TTL_OPEN_AREA")
	private Double totOpenArea;

	@Column(name = "PRJ_AREA_OF_GARAGE_FOR_SALE")
	private Double areaOfGarageForSale;

	@Column(name = "PRJ_HARD_COPY_SUBMITION_OFFICE")
	private Double hardCopySubmitionOffice;

	@Column(name = "PRJ_AREA_OF_PARKING_FOR_SALE")
	private Double areaOfParkinfForSale;

	@Column(name = "PRJ_AREA_OF_COVERED_PARKING")
	private Double coveredParkingArea;

	@Column(name = "PRJ_NO_OF_COVERED_PARKING")
	private Integer coveredParking;

	@Column(name = "PRJ_NO_OF_PARKING_FOR_SALE")
	private Integer noOfParkinfForSale;

	@Column(name = "PRJ_NO_OF_GARAGE_FOR_SALE")
	private Integer noOfGarageForSale;

	@Column(name = "PRJ_GARAGE_SOLDOUT")
	private Integer garageSoldout;

	@Column(name = "PRJ_NO_OF_MONTHS_DELAYED")
	private Integer noOfMonthDelayed;

	@Column(name = "PRJ_COST_OF_LAND")
	private Long costOfLand;

	@Column(name = "PRJ_ESTIMATED_COST")
	private Long estimatedCost;

	@Column(name = "PRJ_TOTAL_PROJECT_COST")
	private Long totalProjectCost;

	@Column(name = "PRJ_REASON_FOR_DELAYED")
	private String reasonForDelayed;

	@Column(name = "PRJ_RERA_OFFICE_CODE")
	private String officeCode;

	@Column(name = "PRJ_RERA_OFFICE_NAME")
	private String officeName;

	/*************************************************
	 * Approver
	 *************************************************/

	@Column(name = "PRJ_APPROVING_AUTHORITY")
	private String approvingAuthority;

	@Column(name = "PRJ_MODIFIED_ON")
	private Date modifiedOn;

	@Column(name = "PRJ_MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "PRJ_LAST_UPDATED_ON")
	private Calendar updatedOn;

	@Column(name = "PRJ_REASON_EXT")
	private String reasonExt;
	
		
	
	public Long getAltprojectDetailId() {
		return altprojectDetailId;
	}

	public void setAltprojectDetailId(Long altprojectDetailId) {
		this.altprojectDetailId = altprojectDetailId;
	}

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
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

	public String getExplanatoryNote() {
		return explanatoryNote;
	}

	public void setExplanatoryNote(String explanatoryNote) {
		this.explanatoryNote = explanatoryNote;
	}

	public String getProjectSpecification() {
		return projectSpecification;
	}

	public void setProjectSpecification(String projectSpecification) {
		this.projectSpecification = projectSpecification;
	}

	public String getReasonExt() {
		return reasonExt;
	}

	public void setReasonExt(String reasonExt) {
		this.reasonExt = reasonExt;
	}

	

	
}
