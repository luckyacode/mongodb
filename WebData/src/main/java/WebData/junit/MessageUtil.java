package WebData.junit;

public class MessageUtil {
	String message;
	public MessageUtil(String message){
		this.message=message;		
	}
	
	public String printMessage(){
		System.out.println(message);
		return message;
	}
}
