package GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	/**
	 * This method is used to append random no.
	 * @author Vijayalaxmi
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	/**
	 * This method is used to get Sytem date
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date; 
	}
	
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		Date dt = new Date();
		String date = dateformat.format(dt);
		return date;
	}
	
	
}
