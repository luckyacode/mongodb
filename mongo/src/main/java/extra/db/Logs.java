package extra.db;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logs {
	public static Logger log = null;

	public static Logger getLog(){
		
		if(log!=null)
			return log;
		log = Logger.getLogger("mylog");
		FileHandler fh;
		try{
			 fh = new FileHandler("C:/Users/Praveen/Desktop/Mongodb/log.txt");			
			 log.addHandler(fh);
			 fh.setFormatter(new mformatter());
			 log.info("Logs Started");
		}catch(Exception e){
			e.printStackTrace();
		}

		return log;
	}
	
	public static void main(String args[]){
		log = getLog();
		log.info("connect");
}
}
 class mformatter extends Formatter{
	@Override
	public String format(LogRecord l){
		StringBuilder sb = new StringBuilder();
		sb.append(l.getMessage());
		sb.append("\n");
		return sb.toString();
	}
}


