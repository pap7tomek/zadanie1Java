package zadanie1;

import java.util.*;
import java.io.*;
public class zadanie1 {
	public static void main(String[] args) throws FileNotFoundException{
		  File file = new File("imiona.txt");
		  File file2 = new File("nazwiska.txt");
		  Scanner in = new Scanner(file);
		  Scanner in2 = new Scanner(file2);
		  String []imionaZen = new String[30];
		  String pomImie;
		  int indexImiona = 0;
		  while(in.hasNext()){
            pomImie = in.nextLine();
            if(pomImie.substring(pomImie.length()-1).equals("a")){
	            if(pomImie.equals("Jarema")){}
	            else{
	            	imionaZen[indexImiona] = pomImie;
	            	indexImiona++;
	            }
            }
		  }
		  int indexNazwiska = 0;
		  String pomNazwisko;
		  String pomNazwisko2;
		  String []nazwiska = new String[20];
		  StringTokenizer rozdzielanie;
		  while(in2.hasNext()){
			  pomNazwisko = in2.nextLine();
			  rozdzielanie = new StringTokenizer(pomNazwisko);
			  pomNazwisko2 = rozdzielanie.nextElement().toString();
			  pomNazwisko2 = rozdzielanie.nextElement().toString();
			  if(pomNazwisko2.substring(pomNazwisko2.length()-1).equals("-")){
				  pomNazwisko2 = pomNazwisko2.substring(0, pomNazwisko2.length()-1);
			  }
			  nazwiska[indexNazwiska] = pomNazwisko2;
			  indexNazwiska++;
		  }
		  Random generator = new Random();
	      PrintWriter out = new PrintWriter("szpieg.txt");
	      Scanner liczba = new Scanner(System.in);
	      int N = 0;
	      do{
	    	  N = liczba.nextInt();
	            if(N < 1 || N > 100){
	               System.out.println("Z³a liczba");
	            }
	      }while(N<1 || N>100);
	      String pesel = "";
	      Integer rok;
	      Integer miesiac;
	      Integer dzien;
	      String koncowka;
	      Integer tmp;
	      for(int i=0;i<N;i++){
	    	    pesel = "";
	    	    koncowka = "";
	            out.print(imionaZen[generator.nextInt(indexImiona)] + " ");
	            out.print(nazwiska[generator.nextInt(indexNazwiska)] + " ");
	            rok = generator.nextInt(77) + 23;
	            pesel += rok.toString();
	            miesiac = generator.nextInt(12) + 1;
	            if(miesiac < 10){
	            	pesel += ("0" + miesiac.toString());
	            }else{
	            	pesel += miesiac.toString();
	            }
	            dzien = generator.nextInt(31) + 1;
	            pesel += dzien.toString();
	            for(int j = 0; j < 5; j++){
	            	tmp = generator.nextInt(10);
	                pesel += tmp.toString();
	            };
	            pesel += koncowka.toString();
	            out.println(pesel);
	        }
	      out.close();
	      in.close();
	      in2.close();       
	}
}
