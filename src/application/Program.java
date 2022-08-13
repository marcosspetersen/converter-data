package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

	public static void main(String[] args) {

		
		String string = "01/05/2018";
		System.out.println(convertDate(string));	
		
	}
	
	public static String convertDate(String s) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MM");
		
		SimpleDateFormat[] format = {
				new SimpleDateFormat("dd/MM/yyyy"),
				new SimpleDateFormat("ddMMyyyy")
		};
		
		String str = s.replaceAll("\\s+", "");
		System.out.println(str);
		Date data = null;
		for (SimpleDateFormat sdf : format) {
				try {
					data = sdf.parse(str);
				} catch (ParseException e) {
					System.out.println("Tentando outro formato");
				}
		}
		
		String dataCorreta;
		if (data != null) {
			dataCorreta = sdf1.format(data);
		}
		else {
			dataCorreta = ("Data não obtida");
		}
		return dataCorreta;
	}

}
