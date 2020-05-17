package in.gov.projectalteration.projectapp.dto;

public class CountResponseDto {

	
	private String type;
	private long total;
	private long lessThan15;
	private long greaterThan30;
	private long between15to30;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getLessThan15() {
		return lessThan15;
	}
	public void setLessThan15(long lessThan15) {
		this.lessThan15 = lessThan15;
	}
	public long getGreaterThan30() {
		return greaterThan30;
	}
	public void setGreaterThan30(long greaterThan30) {
		this.greaterThan30 = greaterThan30;
	}
	public long getBetween15to30() {
		return between15to30;
	}
	public void setBetween15to30(long between15to30) {
		this.between15to30 = between15to30;
	}
	
	
	
	
}
