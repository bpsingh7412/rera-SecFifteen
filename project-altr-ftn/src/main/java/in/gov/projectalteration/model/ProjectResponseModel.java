package in.gov.projectalteration.model;

public class ProjectResponseModel {

	private int status;
	private String message;
	private Object data;
	
	private ProjectResponseModel(int status , String mesg){
		this.status=status;
		this.message=mesg;
	}
	private ProjectResponseModel(int status , String mesg,Object obj){
		this.status=status;
		this.message=mesg;
		this.data=obj;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static ProjectResponseModel error(int status,String msg){
		return new 	ProjectResponseModel(status,msg);
		}
	public static ProjectResponseModel ok(){
		return new 	ProjectResponseModel(200,"Success");
		}
	public static ProjectResponseModel ok(Object obj){
	return new 	ProjectResponseModel(200,"Success",obj);
	}
	public static ProjectResponseModel error(String msg){
		return new 	ProjectResponseModel(500,msg);
		}
	
}
