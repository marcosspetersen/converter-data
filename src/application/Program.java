package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

	public static void main(String[] args) {

		
		String string = "01 05 2018";
		System.out.println(convertDate(string));	
		
	}
	
	public static String convertDate(String s) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MM");
		
		SimpleDateFormat format10 = new SimpleDateFormat("dd/MM/yyyy");
		
		SimpleDateFormat format8 = new SimpleDateFormat("ddMMyyyy");
		
		//Substituir datas com espaco por /
		String str = s.replaceAll("\\s+", "/");
		
		Date data = null;
		
		//verificando o tamanho do string para aplicar a marcara correta
		if (str.length() == 10) {
			
			//inverter a data caso venha com ano primeiro
			String[] stringData = str.split("/");
			if (stringData[0].length() == 4) {
				str = stringData[2] + "/" + stringData[1] + "/" + stringData[0];
			}
			
			try {
				data = format10.parse(str);
			} catch (ParseException e) {
				System.out.println("Tentando outro formato");
			}
			
		} else {
			try {
				data = format8.parse(str);
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
