package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner( System.in );
		sc.useLocale( Locale.US );
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		
		System.out.println( "Enter cliente data:" );
		System.out.print( "Name: " );
		String name = sc.next();
		System.out.print( "Email: " );
		String email = sc.next();
		System.out.print( "Birth date (DD/MM/YYYY): " );
		Date birthDay = sdf.parse( sc.next() );
		
		
	}

}
