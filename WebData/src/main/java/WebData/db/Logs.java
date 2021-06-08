package WebData.db;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class Logs {
	public static Logger log = null;
	public static void main(String args[]){
		log = getLog();
		log.info("OK NOW");
	}
	public static Logger getLog(){
		if(log!=null)
			return log;
		log = Logger.getLogger("MyLogs");
		FileHandler fh=null;
		try{
			fh = new FileHandler("C:/Users/Praveen/Desktop/Mongodb/WebData.log");
			fh.setFormatter(new Mformatter());
			log.addHandler(fh);
			log.info("Logs Started Creating..............");
		}catch(Exception e){
			e.printStackTrace();
		}
		return log;
	}
}
class Mformatter extends Formatter{
	@Override
	public String format(LogRecord l){
		StringBuilder sb = new StringBuilder();
		sb.append(l.getMessage().toString());
		sb.append("\n");
		return sb.toString();
	}
}
