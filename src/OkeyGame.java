//Arif Mert M�s�r
//Okey Game Assignment
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class OkeyGame {
	
	//global de�i�kenler
	static int  birinci_oyuncu,ikinci_oyuncu,ucuncu_oyuncu,dorduncu_oyuncu; 
	static List <Integer> birinci_oyuncunun_eli = new ArrayList<>();
	static List <Integer> ikinci_oyuncunun_eli = new ArrayList<>();
	static List <Integer> ucuncu_oyuncunun_eli = new ArrayList<>();
	static List <Integer> dorduncu_oyuncunun_eli = new ArrayList<>();
	static List <Integer>  liste = new ArrayList<>(); //ta�lar da��t�ld�ktan sonra, kalan ta�lar� eksiltirken kullan�lacak ve kontrol edilecek ArrayList
	static int turn;//15 ta�la oyuna kimin ba�lamas� gerekti�ini tutacak global de�i�ken
	static Random random = new Random(); //Random class�ndan bir random de�i�keni zar atmak ve rastgele ta�lar� se�mek i�in
	
	//renkleri gruplar�na ay�rmak i�in 4 ayr� Arraylist; 
	 static List <Integer>  sarilar_birinci_oyuncu = new ArrayList<>();
	 static List <Integer>  maviler_birinci_oyuncu = new ArrayList<>();
	 static List <Integer>  siyahlar_birinci_oyuncu = new ArrayList<>();
	 static List <Integer>  kirmizilar_birinci_oyuncu = new ArrayList<>();
	 
	 static List <Integer>  sarilar_ikinci_oyuncu = new ArrayList<>();
	 static List <Integer>  maviler_ikinci_oyuncu = new ArrayList<>();
	 static List <Integer>  siyahlar_ikinci_oyuncu = new ArrayList<>();
	 static List <Integer>  kirmizilar_ikinci_oyuncu = new ArrayList<>();
	 
	 static List <Integer>  sarilar_ucuncu_oyuncu = new ArrayList<>();
	 static List <Integer>  maviler_ucuncu_oyuncu = new ArrayList<>();
	 static List <Integer>  siyahlar_ucuncu_oyuncu = new ArrayList<>();
	 static List <Integer>  kirmizilar_ucuncu_oyuncu = new ArrayList<>();
	 
	 static List <Integer>  sarilar_dorduncu_oyuncu = new ArrayList<>();
	 static List <Integer>  maviler_dorduncu_oyuncu = new ArrayList<>();
	 static List <Integer>  siyahlar_dorduncu_oyuncu = new ArrayList<>();
	 static List <Integer>  kirmizilar_dorduncu_oyuncu = new ArrayList<>();
	 
	
	public static void main(String[] args) {
		
		OyunaKimBasl�yor();
		TaslariDagit();
		OyunuOyna();
		KazananiBelirle();
	}
	
	
	
	public static void OyunaKimBasl�yor()
	{
		System.out.println("Zar� 1-6 aras�nda en b�y�k atan oyuna ba�lar!");
		System.out.println("Zarlar at�l�yor...");
	
		birinci_oyuncu = 1 + random.nextInt(6);
		ikinci_oyuncu = 1 + random.nextInt(6);
		ucuncu_oyuncu = 1 + random.nextInt(6);
		dorduncu_oyuncu = 1 + random.nextInt(6);
	
		System.out.println("Birinci Oyuncu: " + birinci_oyuncu);
		System.out.println("�kinci Oyuncu: " + ikinci_oyuncu);
		System.out.println("���nc� Oyuncu: " + ucuncu_oyuncu);
		System.out.println("D�rd�nc� Oyuncu: " + dorduncu_oyuncu);
		
		
		// at�lan en b�y�k zar� belirleme 
		// not: 2 veya daha fazla oyuncu en y�ksek zar� atm��sa, oyuna ba�layan ki�i a�a��daki algoritmaya g�re her zaman birinci oyuncu olur.
		int [] atilan_zarlar = {birinci_oyuncu, ikinci_oyuncu, ucuncu_oyuncu, dorduncu_oyuncu}; 
		int en_buyuk_zar = atilan_zarlar[0];
		int index = 0;
		
		for(int i = 0; i < 4; ++i)
		{
			if(en_buyuk_zar < atilan_zarlar[i])
			{
				en_buyuk_zar = atilan_zarlar[i];
				index = i;
			}
			
		}
		
		if(index == 0)
		{
			turn = 1; //birinci oyuncu ba�las�n
			System.out.println("En b�y�k zar at�p, oyuna ba�layacak oyuncu: Birinci Oyuncu");
			System.out.println();
		}
			
		else if(index == 1)
		{
			turn = 2; // ikinci oyuncu ba�las�n
			System.out.println("En b�y�k zar at�p, oyuna ba�layacak oyuncu: �kinci Oyuncu");
			System.out.println();
		}
			
		else if(index == 2)
		{
			turn = 3; // ���nc� oyuncu ba�las�n
			System.out.println("En b�y�k zar at�p, oyuna ba�layacak oyuncu: ���nc� Oyuncu");
			System.out.println();
		}
			
		else
		{
			turn = 4; // d�rd�nc� oyuncu ba�las�n
			System.out.println("En b�y�k zar at�p, oyuna ba�layacak oyuncu: D�rd�nc� Oyuncu");
			System.out.println();
		}
			
	}
	
	
	public static void TaslariDagit()
	{
		
		
		int[] taslari_dagit = {
				0,1,2,3,4,5,6,7,8,9,10,11,12, // sar� 1-13
				13,14,15,16,17,18,19,20,21,22,23,24,25, //mavi 1-13
				26,27,28,29,30,31,32,33,34,35,36,37,38, //siyah 1-13
				39,40,41,42,43,44,45,46,47,48,49,50,51, //kirmizi 1-13
				52, // sahte okey
				0,1,2,3,4,5,6,7,8,9,10,11,12, // sar� kopya 1-13
				13,14,15,16,17,18,19,20,21,22,23,24,25, //mavi kopya 1-13
				26,27,28,29,30,31,32,33,34,35,36,37,38, //siyah kopya 1-13
				39,40,41,42,43,44,45,46,47,48,49,50,51, //kirmizi kopya 1-13
				52};  // sahte okey kopya
		
		//arraydeki t�m ta�lar� ArrayList'ime kopyala ��nk� oyuncular ta�lar� dizdikten sonra ta� �ekerken, kalan ta�lardan eksilme yapaca��m 
		for (int i=0; i<106; i++)
		{
			liste.add(taslari_dagit[i]);
			//System.out.println(liste.get(i));
		}

		
	  int okey,gosterge;
	  
		do {
		 gosterge = random.nextInt( (taslari_dagit.length/2) ); // arrayin i�erisinden random bir say� se�me. 
		 okey = gosterge + 1;  // okey, g�stergenin 1 fazlas�
		} while (okey == 52 );  //Sahte okey, okey say�lamayaca��ndan s�rekli kontrol etme conditionu
			
		System.out.println("g�sterge: " + gosterge);
		
		for(int i=0; i<liste.size(); i++) // taslar da��t�l�rken g�stergelerden 1 tanesi a��laca�� i�in listeden silinecek
		{
			if( liste.get(i) == gosterge )
			{
				liste.remove(i);
				break;
			}
		}
		System.out.println("okey: " + okey);
		System.out.println();
		
		Collections.shuffle(liste);  //Arraylistimi kar��t�r herkese random gelmesi i�in
		
		if (turn == 1)
		{
			birinci_oyuncunun_eli = new ArrayList<>(15);  // oyuna 1.oyuncu ba�layacaksa 15 ta�la ba�las�n
			System.out.print("Birinci Oyuncunun Eli: ");
			for(int i=0; i<15; i++)
			{
				
				birinci_oyuncunun_eli.add(liste.get(i));   // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // oyuncunun 15 ta�� verildikten sonra 106 ta�tan, da��t�lan 15'i ��kart�ls�n
				System.out.print(birinci_oyuncunun_eli.get(i) + " "); 
			}
			
			
			System.out.println();
			System.out.print("�kinci Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				ikinci_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i);	// ikinci oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ikinci_oyuncunun_eli.get(i) + " ");
			}
			
			System.out.println();
			System.out.print("���nc� Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				ucuncu_oyuncunun_eli.add(liste.get(i));   // ta�lar listeden random �ekilde gelsin
				liste.remove(i);  // ���nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ucuncu_oyuncunun_eli.get(i) + " "); 
			}
			
			System.out.println();
			System.out.print("D�rd�nc� Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				dorduncu_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // D�rd�nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(dorduncu_oyuncunun_eli.get(i) + " "); 
			}
			
			/*
			//listedeki kalan ta�lar(check etmek i�in)
			System.out.println();
			for(int i=0; i<48; i++)
				System.out.print(liste.get(i) + " ");
			System.out.println();
			System.out.println(liste.size());
			*/
			
		}
			
		else if (turn == 2)
		{
			ikinci_oyuncunun_eli = new ArrayList<>(15);
			System.out.print("�kinci Oyuncunun Eli: ");
			for(int i=0; i<15; i++)
			{
				ikinci_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // �kinci oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ikinci_oyuncunun_eli.get(i) + " ");
			}
			
			System.out.println();
			System.out.print("���nc� Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				ucuncu_oyuncunun_eli.add(liste.get(i));   // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // ���nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ucuncu_oyuncunun_eli.get(i) + " "); 
			}
			
			System.out.println();
			System.out.print("D�rd�nc� Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				dorduncu_oyuncunun_eli.add(liste.get(i));  // ta�lar rastgele arrayden gelsin
				liste.remove(i); // D�rd�nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(dorduncu_oyuncunun_eli.get(i) + " ");  
			}
			
			System.out.println();
			System.out.print("Birinci Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				birinci_oyuncunun_eli.add(liste.get(i));   // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // Birinci oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(birinci_oyuncunun_eli.get(i) + " "); 
			}
			
			/*
			//listedeki kalan ta�lar(check etmek i�in)
			System.out.println();
			for(int i=0; i<48; i++)
				System.out.print(liste.get(i) + " ");
			System.out.println();
			System.out.println(liste.size());
			*/
		}
			
		
		
		else if (turn == 3)
		{
			ucuncu_oyuncunun_eli = new ArrayList<>(15);
			System.out.print("���nc� Oyuncunun Eli: ");
			for(int i=0; i<15; i++)
			{
				ucuncu_oyuncunun_eli.add(liste.get(i));   // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // ���nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ucuncu_oyuncunun_eli.get(i) + " "); 
			}
			
			System.out.println();
			System.out.print("D�rd�nc� Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				dorduncu_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // D�rd�nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(dorduncu_oyuncunun_eli.get(i) + " ");  
			}
			
			System.out.println();
			System.out.print("Birinci Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				birinci_oyuncunun_eli.add(liste.get(i));   // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // Birinci oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(birinci_oyuncunun_eli.get(i) + " "); 
			}
			
			System.out.println();
			System.out.print("�kinci Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				ikinci_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // �kinci oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ikinci_oyuncunun_eli.get(i) + " "); 
			}
			/*
			//listedeki kalan ta�lar(check etmek i�in)
			System.out.println();
			for(int i=0; i<48; i++)
				System.out.print(liste.get(i) + " ");
			System.out.println();
			System.out.println(liste.size());
			*/
			
		}
			
		
		else
		{
			dorduncu_oyuncunun_eli = new ArrayList<>(15);
			System.out.print("D�rd�nc� Oyuncunun Eli: ");
			for(int i=0; i<15; i++)
			{
				dorduncu_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // D�rd�nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(dorduncu_oyuncunun_eli.get(i) + " "); 
			}
			
			System.out.println();
			System.out.print("Birinci Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				birinci_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // Birinci oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(birinci_oyuncunun_eli.get(i) + " "); 
			}
			
			System.out.println();
			System.out.print("�kinci Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				ikinci_oyuncunun_eli.add(liste.get(i));  // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // �kinci oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ikinci_oyuncunun_eli.get(i) + " ");
			}
			
			System.out.println();
			System.out.print("���nc� Oyuncunun Eli: ");
			for(int i=0; i<14; i++)
			{
				ucuncu_oyuncunun_eli.add(liste.get(i));   // ta�lar listeden random �ekilde gelsin
				liste.remove(i); // ���nc� oyuncunun eli da��t�ld�ktan sonra listedeki t�m ta�lar i�erisinden ��kart�ls�n
				System.out.print(ucuncu_oyuncunun_eli.get(i) + " ");
			}
			
			/*
			//listedeki kalan ta�lar(check etmek i�in)
			System.out.println();
			for(int i=0; i<48; i++)
				System.out.print(liste.get(i) + " ");
			System.out.println();
			System.out.println(liste.size());
			*/
		}
			System.out.println();
	}
	
	public static void OyunuOyna()
	{
		System.out.println();
		System.out.println("Oyun sim�le ediliyor...");
		Collections.sort(birinci_oyuncunun_eli); //birinci oyuncunun elini diz
		Collections.sort(ikinci_oyuncunun_eli); // ikinci oyuncunun elini diz
		Collections.sort(ucuncu_oyuncunun_eli); // ���nc� oyuncunun elini diz
		Collections.sort(dorduncu_oyuncunun_eli); // d�rd�nc� oyuncunun elini diz 
		
		//0-12 sar�
		//13-25 mavi
		//26-38 siyah
		//39-51 k�rm�z�
		//52 sahte okey 
		
				 
					for(int i=0; i<birinci_oyuncunun_eli.size(); i++) 
					{
						//0-12 sar�lar� ay�r
						if( birinci_oyuncunun_eli.get(i) == 0 || birinci_oyuncunun_eli.get(i) == 1 || birinci_oyuncunun_eli.get(i) == 2 || birinci_oyuncunun_eli.get(i) == 3 || birinci_oyuncunun_eli.get(i) == 4 || birinci_oyuncunun_eli.get(i) == 5 || birinci_oyuncunun_eli.get(i) == 6 || birinci_oyuncunun_eli.get(i) == 7 || birinci_oyuncunun_eli.get(i) == 8 || birinci_oyuncunun_eli.get(i) == 9 || birinci_oyuncunun_eli.get(i) == 10 || birinci_oyuncunun_eli.get(i) == 11 || birinci_oyuncunun_eli.get(i) == 12 )
						{
							sarilar_birinci_oyuncu.add(birinci_oyuncunun_eli.get(i));
						}
						//13-25 mavileri ay�r
						else if( birinci_oyuncunun_eli.get(i) == 13 || birinci_oyuncunun_eli.get(i) == 14 || birinci_oyuncunun_eli.get(i) == 15 || birinci_oyuncunun_eli.get(i) == 16 || birinci_oyuncunun_eli.get(i) == 17 || birinci_oyuncunun_eli.get(i) == 18 || birinci_oyuncunun_eli.get(i) == 19 || birinci_oyuncunun_eli.get(i) == 20 || birinci_oyuncunun_eli.get(i) == 21 || birinci_oyuncunun_eli.get(i) == 22 || birinci_oyuncunun_eli.get(i) == 23 || birinci_oyuncunun_eli.get(i) == 24 || birinci_oyuncunun_eli.get(i) == 25 )
						{
							maviler_birinci_oyuncu.add(birinci_oyuncunun_eli.get(i));
						}
						//26-38 siyahlar� ay�r
						else if( birinci_oyuncunun_eli.get(i) == 26 || birinci_oyuncunun_eli.get(i) == 27 || birinci_oyuncunun_eli.get(i) == 28 || birinci_oyuncunun_eli.get(i) == 29 || birinci_oyuncunun_eli.get(i) == 30 || birinci_oyuncunun_eli.get(i) == 31 || birinci_oyuncunun_eli.get(i) == 32 || birinci_oyuncunun_eli.get(i) == 33 || birinci_oyuncunun_eli.get(i) == 34 || birinci_oyuncunun_eli.get(i) == 35 || birinci_oyuncunun_eli.get(i) == 36 || birinci_oyuncunun_eli.get(i) == 37 || birinci_oyuncunun_eli.get(i) == 38 )
						{
							siyahlar_birinci_oyuncu.add(birinci_oyuncunun_eli.get(i));
						}
						//39-51 k�rm�z�lar� ay�r
						else if( birinci_oyuncunun_eli.get(i) == 39 || birinci_oyuncunun_eli.get(i) == 40 || birinci_oyuncunun_eli.get(i) == 41 || birinci_oyuncunun_eli.get(i) == 42 || birinci_oyuncunun_eli.get(i) == 43 || birinci_oyuncunun_eli.get(i) == 44 || birinci_oyuncunun_eli.get(i) == 45 || birinci_oyuncunun_eli.get(i) == 46 || birinci_oyuncunun_eli.get(i) == 47 || birinci_oyuncunun_eli.get(i) == 48 || birinci_oyuncunun_eli.get(i) == 49 || birinci_oyuncunun_eli.get(i) == 50 || birinci_oyuncunun_eli.get(i) == 51 )
						{
							kirmizilar_birinci_oyuncu.add(birinci_oyuncunun_eli.get(i));
						}
					}	
				
					System.out.println("Birinci Oyuncunun Eli ta�lar dizildikten sonra:");
					System.out.println(birinci_oyuncunun_eli);
					System.out.print("Sar�lar: " + sarilar_birinci_oyuncu + " ");
					System.out.print("Maviler: " + maviler_birinci_oyuncu + " ");
					System.out.print("Siyahlar: " + siyahlar_birinci_oyuncu + " ");
					System.out.println("K�rm�z�lar: " + kirmizilar_birinci_oyuncu);	
					System.out.println();
					
				 
					 //yukarda yapt���m�n ayn�s�n� bu kez ikinci oyuncunun 4 ayr� renkleri i�in yap
					for(int i=0; i<ikinci_oyuncunun_eli.size(); i++)
					{
						if( ikinci_oyuncunun_eli.get(i) == 0 || ikinci_oyuncunun_eli.get(i) == 1 || ikinci_oyuncunun_eli.get(i) == 2 || ikinci_oyuncunun_eli.get(i) == 3 || ikinci_oyuncunun_eli.get(i) == 4 || ikinci_oyuncunun_eli.get(i) == 5 || ikinci_oyuncunun_eli.get(i) == 6 || ikinci_oyuncunun_eli.get(i) == 7 || ikinci_oyuncunun_eli.get(i) == 8 || ikinci_oyuncunun_eli.get(i) == 9 || ikinci_oyuncunun_eli.get(i) == 10 || ikinci_oyuncunun_eli.get(i) == 11 || ikinci_oyuncunun_eli.get(i) == 12 )
						{
							sarilar_ikinci_oyuncu.add(ikinci_oyuncunun_eli.get(i));
						}
						
						else if( ikinci_oyuncunun_eli.get(i) == 13 || ikinci_oyuncunun_eli.get(i) == 14 || ikinci_oyuncunun_eli.get(i) == 15 || ikinci_oyuncunun_eli.get(i) == 16 || ikinci_oyuncunun_eli.get(i) == 17 || ikinci_oyuncunun_eli.get(i) == 18 || ikinci_oyuncunun_eli.get(i) == 19 || ikinci_oyuncunun_eli.get(i) == 20 || ikinci_oyuncunun_eli.get(i) == 21 || ikinci_oyuncunun_eli.get(i) == 22 || ikinci_oyuncunun_eli.get(i) == 23 || ikinci_oyuncunun_eli.get(i) == 24 || ikinci_oyuncunun_eli.get(i) == 25 )
						{
							maviler_ikinci_oyuncu.add(ikinci_oyuncunun_eli.get(i));
						}
						
						else if( ikinci_oyuncunun_eli.get(i) == 26 || ikinci_oyuncunun_eli.get(i) == 27 || ikinci_oyuncunun_eli.get(i) == 28 || ikinci_oyuncunun_eli.get(i) == 29 || ikinci_oyuncunun_eli.get(i) == 30 || ikinci_oyuncunun_eli.get(i) == 31 || ikinci_oyuncunun_eli.get(i) == 32 || ikinci_oyuncunun_eli.get(i) == 33 || ikinci_oyuncunun_eli.get(i) == 34 || ikinci_oyuncunun_eli.get(i) == 35 || ikinci_oyuncunun_eli.get(i) == 36 || ikinci_oyuncunun_eli.get(i) == 37 || ikinci_oyuncunun_eli.get(i) == 38 )
						{
							siyahlar_ikinci_oyuncu.add(ikinci_oyuncunun_eli.get(i));
						}
						
						else if( ikinci_oyuncunun_eli.get(i) == 39 || ikinci_oyuncunun_eli.get(i) == 40 || ikinci_oyuncunun_eli.get(i) == 41 || ikinci_oyuncunun_eli.get(i) == 42 || ikinci_oyuncunun_eli.get(i) == 43 || ikinci_oyuncunun_eli.get(i) == 44 || ikinci_oyuncunun_eli.get(i) == 45 || ikinci_oyuncunun_eli.get(i) == 46 || ikinci_oyuncunun_eli.get(i) == 47 || ikinci_oyuncunun_eli.get(i) == 48 || ikinci_oyuncunun_eli.get(i) == 49 || ikinci_oyuncunun_eli.get(i) == 50 || ikinci_oyuncunun_eli.get(i) == 51 )
						{
							kirmizilar_ikinci_oyuncu.add(ikinci_oyuncunun_eli.get(i));
						}
					}	
				
					System.out.println("�kinci Oyuncunun Eli ta�lar dizildikten sonra:");
					System.out.println(ikinci_oyuncunun_eli);
					System.out.print("Sar�lar: " + sarilar_ikinci_oyuncu + " ");
					System.out.print("Maviler: " + maviler_ikinci_oyuncu + " ");
					System.out.print("Siyahlar: " + siyahlar_ikinci_oyuncu + " ");
					System.out.println("K�rm�z�lar: " + kirmizilar_ikinci_oyuncu);
					System.out.println();
					

					 
					//yukarda yapt���m�n ayn�s�n� bu kez ���nc� oyuncunun 4 ayr� renkleri i�in yap
					for(int i=0; i<ucuncu_oyuncunun_eli.size(); i++)
					{
						if( ucuncu_oyuncunun_eli.get(i) == 0 || ucuncu_oyuncunun_eli.get(i) == 1 || ucuncu_oyuncunun_eli.get(i) == 2 || ucuncu_oyuncunun_eli.get(i) == 3 || ucuncu_oyuncunun_eli.get(i) == 4 || ucuncu_oyuncunun_eli.get(i) == 5 || ucuncu_oyuncunun_eli.get(i) == 6 || ucuncu_oyuncunun_eli.get(i) == 7 || ucuncu_oyuncunun_eli.get(i) == 8 || ucuncu_oyuncunun_eli.get(i) == 9 || ucuncu_oyuncunun_eli.get(i) == 10 || ucuncu_oyuncunun_eli.get(i) == 11 || ucuncu_oyuncunun_eli.get(i) == 12 )
						{
							sarilar_ucuncu_oyuncu.add(ucuncu_oyuncunun_eli.get(i));
						}
						
						else if( ucuncu_oyuncunun_eli.get(i) == 13 || ucuncu_oyuncunun_eli.get(i) == 14 || ucuncu_oyuncunun_eli.get(i) == 15 || ucuncu_oyuncunun_eli.get(i) == 16 || ucuncu_oyuncunun_eli.get(i) == 17 || ucuncu_oyuncunun_eli.get(i) == 18 || ucuncu_oyuncunun_eli.get(i) == 19 || ucuncu_oyuncunun_eli.get(i) == 20 || ucuncu_oyuncunun_eli.get(i) == 21 || ucuncu_oyuncunun_eli.get(i) == 22 || ucuncu_oyuncunun_eli.get(i) == 23 || ucuncu_oyuncunun_eli.get(i) == 24 || ucuncu_oyuncunun_eli.get(i) == 25 )
						{
							maviler_ucuncu_oyuncu.add(ucuncu_oyuncunun_eli.get(i));
						}
						
						else if( ucuncu_oyuncunun_eli.get(i) == 26 || ucuncu_oyuncunun_eli.get(i) == 27 || ucuncu_oyuncunun_eli.get(i) == 28 || ucuncu_oyuncunun_eli.get(i) == 29 || ucuncu_oyuncunun_eli.get(i) == 30 || ucuncu_oyuncunun_eli.get(i) == 31 || ucuncu_oyuncunun_eli.get(i) == 32 || ucuncu_oyuncunun_eli.get(i) == 33 || ucuncu_oyuncunun_eli.get(i) == 34 || ucuncu_oyuncunun_eli.get(i) == 35 || ucuncu_oyuncunun_eli.get(i) == 36 || ucuncu_oyuncunun_eli.get(i) == 37 || ucuncu_oyuncunun_eli.get(i) == 38 )
						{
							siyahlar_ucuncu_oyuncu.add(ucuncu_oyuncunun_eli.get(i));
						}
						
						else if( ucuncu_oyuncunun_eli.get(i) == 39 || ucuncu_oyuncunun_eli.get(i) == 40 || ucuncu_oyuncunun_eli.get(i) == 41 || ucuncu_oyuncunun_eli.get(i) == 42 || ucuncu_oyuncunun_eli.get(i) == 43 || ucuncu_oyuncunun_eli.get(i) == 44 || ucuncu_oyuncunun_eli.get(i) == 45 || ucuncu_oyuncunun_eli.get(i) == 46 || ucuncu_oyuncunun_eli.get(i) == 47 || ucuncu_oyuncunun_eli.get(i) == 48 || ucuncu_oyuncunun_eli.get(i) == 49 || ucuncu_oyuncunun_eli.get(i) == 50 || ucuncu_oyuncunun_eli.get(i) == 51 )
						{
							kirmizilar_ucuncu_oyuncu.add(ucuncu_oyuncunun_eli.get(i));
						}
					}	
				
					System.out.println("���nc� Oyuncunun Eli ta�lar dizildikten sonra:");
					System.out.println(ucuncu_oyuncunun_eli);
					System.out.print("Sar�lar: " + sarilar_ucuncu_oyuncu + " ");
					System.out.print("Maviler: " + maviler_ucuncu_oyuncu + " ");
					System.out.print("Siyahlar: " + siyahlar_ucuncu_oyuncu + " ");
					System.out.println("K�rm�z�lar: " + kirmizilar_ucuncu_oyuncu);
					System.out.println();
					

					 
					//yukarda yapt���m�n ayn�s�n� bu kez d�rd�nc� oyuncunun 4 ayr� renkleri i�in yap
					for(int i=0; i<dorduncu_oyuncunun_eli.size(); i++)
					{
						if( dorduncu_oyuncunun_eli.get(i) == 0 || dorduncu_oyuncunun_eli.get(i) == 1 || dorduncu_oyuncunun_eli.get(i) == 2 || dorduncu_oyuncunun_eli.get(i) == 3 || dorduncu_oyuncunun_eli.get(i) == 4 || dorduncu_oyuncunun_eli.get(i) == 5 || dorduncu_oyuncunun_eli.get(i) == 6 || dorduncu_oyuncunun_eli.get(i) == 7 || dorduncu_oyuncunun_eli.get(i) == 8 || dorduncu_oyuncunun_eli.get(i) == 9 || dorduncu_oyuncunun_eli.get(i) == 10 || dorduncu_oyuncunun_eli.get(i) == 11 || dorduncu_oyuncunun_eli.get(i) == 12 )
						{
							sarilar_dorduncu_oyuncu.add(dorduncu_oyuncunun_eli.get(i));
						}
						
						else if( dorduncu_oyuncunun_eli.get(i) == 13 || dorduncu_oyuncunun_eli.get(i) == 14 || dorduncu_oyuncunun_eli.get(i) == 15 || dorduncu_oyuncunun_eli.get(i) == 16 || dorduncu_oyuncunun_eli.get(i) == 17 || dorduncu_oyuncunun_eli.get(i) == 18 || dorduncu_oyuncunun_eli.get(i) == 19 || dorduncu_oyuncunun_eli.get(i) == 20 || dorduncu_oyuncunun_eli.get(i) == 21 || dorduncu_oyuncunun_eli.get(i) == 22 || dorduncu_oyuncunun_eli.get(i) == 23 || dorduncu_oyuncunun_eli.get(i) == 24 || dorduncu_oyuncunun_eli.get(i) == 25 )
						{
							maviler_dorduncu_oyuncu.add(dorduncu_oyuncunun_eli.get(i));
						}
						
						else if( dorduncu_oyuncunun_eli.get(i) == 26 || dorduncu_oyuncunun_eli.get(i) == 27 || dorduncu_oyuncunun_eli.get(i) == 28 || dorduncu_oyuncunun_eli.get(i) == 29 || dorduncu_oyuncunun_eli.get(i) == 30 || dorduncu_oyuncunun_eli.get(i) == 31 || dorduncu_oyuncunun_eli.get(i) == 32 || dorduncu_oyuncunun_eli.get(i) == 33 || dorduncu_oyuncunun_eli.get(i) == 34 || dorduncu_oyuncunun_eli.get(i) == 35 || dorduncu_oyuncunun_eli.get(i) == 36 || dorduncu_oyuncunun_eli.get(i) == 37 || dorduncu_oyuncunun_eli.get(i) == 38 )
						{
							siyahlar_dorduncu_oyuncu.add(dorduncu_oyuncunun_eli.get(i));
						}
						
						else if( dorduncu_oyuncunun_eli.get(i) == 39 || dorduncu_oyuncunun_eli.get(i) == 40 || dorduncu_oyuncunun_eli.get(i) == 41 || dorduncu_oyuncunun_eli.get(i) == 42 || dorduncu_oyuncunun_eli.get(i) == 43 || dorduncu_oyuncunun_eli.get(i) == 44 || dorduncu_oyuncunun_eli.get(i) == 45 || dorduncu_oyuncunun_eli.get(i) == 46 || dorduncu_oyuncunun_eli.get(i) == 47 || dorduncu_oyuncunun_eli.get(i) == 48 || dorduncu_oyuncunun_eli.get(i) == 49 || dorduncu_oyuncunun_eli.get(i) == 50 || dorduncu_oyuncunun_eli.get(i) == 51 )
						{
							kirmizilar_dorduncu_oyuncu.add(dorduncu_oyuncunun_eli.get(i));
						}
					}	
				
					System.out.println("D�rd�nc� Oyuncunun Eli ta�lar dizildikten sonra:");
					System.out.println(dorduncu_oyuncunun_eli);
					System.out.print("Sar�lar: " + sarilar_dorduncu_oyuncu + " ");
					System.out.print("Maviler: " + maviler_dorduncu_oyuncu + " ");
					System.out.print("Siyahlar: " + siyahlar_dorduncu_oyuncu + " ");
					System.out.println("K�rm�z�lar: " + kirmizilar_dorduncu_oyuncu);
					System.out.println();
		
	}
	
	public static void KazananiBelirle()
	{
		//en �ok ard���k ta�� olan oyunu bitirmeye en yak�n olacak!
		//sari,mavi,siyah,kirmizi
		
		int counter_birinci_oyuncu_sari = 0;
		int counter_birinci_oyuncu_mavi = 0;
		int counter_birinci_oyuncu_siyah = 0;
		int counter_birinci_oyuncu_kirmizi = 0;
	
		int counter_ikinci_oyuncu_sari = 0;
		int counter_ikinci_oyuncu_mavi = 0;
		int counter_ikinci_oyuncu_siyah = 0;
		int counter_ikinci_oyuncu_kirmizi = 0;
		
		int counter_ucuncu_oyuncu_sari = 0;
		int counter_ucuncu_oyuncu_mavi = 0;
		int counter_ucuncu_oyuncu_siyah = 0;
		int counter_ucuncu_oyuncu_kirmizi = 0;
		
		int counter_dorduncu_oyuncu_sari = 0;
		int counter_dorduncu_oyuncu_mavi = 0;
		int counter_dorduncu_oyuncu_siyah = 0;
		int counter_dorduncu_oyuncu_kirmizi = 0;
		
		int counter_birinci_oyuncu=0, counter_ikinci_oyuncu=0,counter_ucuncu_oyuncu=0,counter_dorduncu_oyuncu=0;
		int min=0,max=0;	
	
		//birinci oyuncunun elinde ka� tane ard���k sar� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<sarilar_birinci_oyuncu.size()-1; i++)
		{   
			min = sarilar_birinci_oyuncu.get(i); 
			if( sarilar_birinci_oyuncu.get(i+1) == min+1 )
			{
				counter_birinci_oyuncu_sari++;
			}
		}
		
		System.out.println("Birinci oyuncunun elinde " + counter_birinci_oyuncu_sari + " tane ard���k sar� ta� var!");

		//birinci oyuncunun elinde ka� tane ard���k mavi ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<maviler_birinci_oyuncu.size()-1; i++)
		{   
			min = maviler_birinci_oyuncu.get(i); 
			if( maviler_birinci_oyuncu.get(i+1) == min+1 )
			{
				counter_birinci_oyuncu_mavi++;
			}
		}
		
		System.out.println("Birinci oyuncunun elinde " + counter_birinci_oyuncu_mavi + " tane ard���k mavi ta� var!");

		//birinci oyuncunun elinde ka� tane ard���k siyah ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<siyahlar_birinci_oyuncu.size()-1; i++)
		{   
			min = siyahlar_birinci_oyuncu.get(i); 
			if( siyahlar_birinci_oyuncu.get(i+1) == min+1 )
			{
				counter_birinci_oyuncu_siyah++;
			}
		}
		
		System.out.println("Birinci oyuncunun elinde " + counter_birinci_oyuncu_siyah + " tane ard���k siyah ta� var!");
		
		//birinci oyuncunun elinde ka� tane ard���k k�rm�z� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<kirmizilar_birinci_oyuncu.size()-1; i++)
		{   
			min = kirmizilar_birinci_oyuncu.get(i); 
			if( kirmizilar_birinci_oyuncu.get(i+1) == min+1 )
			{
				counter_birinci_oyuncu_kirmizi++;
			}
		}
		
		System.out.println("Birinci oyuncunun elinde " + counter_birinci_oyuncu_kirmizi + " tane ard���k k�rm�z� ta� var!");
		
		//birinci oyuncunun elinde ard���k toplam ta� say�s�n� hesaplama:
		counter_birinci_oyuncu = counter_birinci_oyuncu_sari + counter_birinci_oyuncu_mavi + counter_birinci_oyuncu_siyah + counter_birinci_oyuncu_kirmizi;
		System.out.println("Toplam... Birinci oyuncunun elinde " + counter_birinci_oyuncu + " tane ard���k ta� var!" );
		System.out.println();
		
		//ikinci oyuncunun elinde ka� tane ard���k sar� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<sarilar_ikinci_oyuncu.size()-1; i++)
		{   
			min = sarilar_ikinci_oyuncu.get(i); 
			if( sarilar_ikinci_oyuncu.get(i+1) == min+1 )
			{
				counter_ikinci_oyuncu_sari++;
			}
		}
		
		System.out.println("�kinci oyuncunun elinde " + counter_ikinci_oyuncu_sari + " tane ard���k sar� ta� var!");

		//ikinci oyuncunun elinde ka� tane ard���k mavi ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<maviler_ikinci_oyuncu.size()-1; i++)
		{   
			min = maviler_ikinci_oyuncu.get(i); 
			if( maviler_ikinci_oyuncu.get(i+1) == min+1 )
			{
				counter_ikinci_oyuncu_mavi++;
			}
		}
		
		System.out.println("�kinci oyuncunun elinde " + counter_ikinci_oyuncu_mavi + " tane ard���k mavi ta� var!");

		//ikinci oyuncunun elinde ka� tane ard���k siyah ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<siyahlar_ikinci_oyuncu.size()-1; i++)
		{   
			min = siyahlar_ikinci_oyuncu.get(i); 
			if( siyahlar_ikinci_oyuncu.get(i+1) == min+1 )
			{
				counter_ikinci_oyuncu_siyah++;
			}
		}
		
		System.out.println("�kinci oyuncunun elinde " + counter_ikinci_oyuncu_siyah + " tane ard���k siyah ta� var!");
		
		//ikinci oyuncunun elinde ka� tane ard���k k�rm�z� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<kirmizilar_ikinci_oyuncu.size()-1; i++)
		{   
			min = kirmizilar_ikinci_oyuncu.get(i); 
			if( kirmizilar_ikinci_oyuncu.get(i+1) == min+1 )
			{
				counter_ikinci_oyuncu_kirmizi++;
			}
		}
		
		System.out.println("�kinci oyuncunun elinde " + counter_ikinci_oyuncu_kirmizi + " tane ard���k k�rm�z� ta� var!");
		
		//ikinci oyuncunun elinde ard���k toplam ta� say�s�n� hesaplama:
		counter_ikinci_oyuncu = counter_ikinci_oyuncu_sari + counter_ikinci_oyuncu_mavi + counter_ikinci_oyuncu_siyah + counter_ikinci_oyuncu_kirmizi;
		System.out.println("Toplam... �kinci oyuncunun elinde " + counter_ikinci_oyuncu + " tane ard���k ta� var!" );
		System.out.println();
		
		//���nc� oyuncunun elinde ka� tane ard���k sar� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<sarilar_ucuncu_oyuncu.size()-1; i++)
		{   
			min = sarilar_ucuncu_oyuncu.get(i); 
			if( sarilar_ucuncu_oyuncu.get(i+1) == min+1 )
			{
				counter_ucuncu_oyuncu_sari++;
			}
		}
		
		System.out.println("���nc� oyuncunun elinde " + counter_ucuncu_oyuncu_sari + " tane ard���k sar� ta� var!");

		//���nc� oyuncunun elinde ka� tane ard���k mavi ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<maviler_ucuncu_oyuncu.size()-1; i++)
		{   
			min = maviler_ucuncu_oyuncu.get(i); 
			if( maviler_ucuncu_oyuncu.get(i+1) == min+1 )
			{
				counter_ucuncu_oyuncu_mavi++;
			}
		}
		
		System.out.println("���nc� oyuncunun elinde " + counter_ucuncu_oyuncu_mavi + " tane ard���k mavi ta� var!");

		//���nc� oyuncunun elinde ka� tane ard���k siyah ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<siyahlar_ucuncu_oyuncu.size()-1; i++)
		{   
			min = siyahlar_ucuncu_oyuncu.get(i); 
			if( siyahlar_ucuncu_oyuncu.get(i+1) == min+1 )
			{
				counter_ucuncu_oyuncu_siyah++;
			}
		}
		
		System.out.println("���nc� oyuncunun elinde " + counter_ucuncu_oyuncu_siyah + " tane ard���k siyah ta� var!");
		
		//���nc� oyuncunun elinde ka� tane ard���k k�rm�z� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<kirmizilar_ucuncu_oyuncu.size()-1; i++)
		{   
			min = kirmizilar_ucuncu_oyuncu.get(i); 
			if( kirmizilar_ucuncu_oyuncu.get(i+1) == min+1 )
			{
				counter_ucuncu_oyuncu_kirmizi++;
			}
		}
		
		System.out.println("���nc� oyuncunun elinde " + counter_ucuncu_oyuncu_kirmizi + " tane ard���k k�rm�z� ta� var!");
		
		//ikinci oyuncunun elinde ard���k toplam ta� say�s�n� hesaplama:
		counter_ucuncu_oyuncu = counter_ucuncu_oyuncu_sari + counter_ucuncu_oyuncu_mavi + counter_ucuncu_oyuncu_siyah + counter_ucuncu_oyuncu_kirmizi;
		System.out.println("Toplam... ���nc� oyuncunun elinde " + counter_ucuncu_oyuncu + " tane ard���k ta� var!" );
		System.out.println();
		
		
		//D�rd�nc� oyuncunun elinde ka� tane ard���k sar� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<sarilar_dorduncu_oyuncu.size()-1; i++)
		{   
			min = sarilar_dorduncu_oyuncu.get(i); 
			if( sarilar_dorduncu_oyuncu.get(i+1) == min+1 )
			{
				counter_dorduncu_oyuncu_sari++;
			}
		}
		
		System.out.println("D�rd�nc� oyuncunun elinde " + counter_dorduncu_oyuncu_sari + " tane ard���k sar� ta� var!");

		//D�rd�nc� oyuncunun elinde ka� tane ard���k mavi ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<maviler_dorduncu_oyuncu.size()-1; i++)
		{   
			min = maviler_dorduncu_oyuncu.get(i); 
			if( maviler_dorduncu_oyuncu.get(i+1) == min+1 )
			{
				counter_dorduncu_oyuncu_mavi++;
			}
		}
		
		System.out.println("D�rd�nc� oyuncunun elinde " + counter_dorduncu_oyuncu_mavi + " tane ard���k mavi ta� var!");

		//D�rd�nc� oyuncunun elinde ka� tane ard���k siyah ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<siyahlar_dorduncu_oyuncu.size()-1; i++)
		{   
			min = siyahlar_dorduncu_oyuncu.get(i); 
			if( siyahlar_dorduncu_oyuncu.get(i+1) == min+1 )
			{
				counter_dorduncu_oyuncu_siyah++;
			}
		}
		
		System.out.println("D�rd�nc� oyuncunun elinde " + counter_dorduncu_oyuncu_siyah + " tane ard���k siyah ta� var!");
		
		//D�rd�nc� oyuncunun elinde ka� tane ard���k k�rm�z� ta� var:
		//2 ard���k ta� 1 per eder,
		for(int i=0; i<kirmizilar_dorduncu_oyuncu.size()-1; i++)
		{   
			min = kirmizilar_dorduncu_oyuncu.get(i); 
			if( kirmizilar_dorduncu_oyuncu.get(i+1) == min+1 )
			{
				counter_dorduncu_oyuncu_kirmizi++;
			}
		}
		
		System.out.println("D�rd�nc� oyuncunun elinde " + counter_dorduncu_oyuncu_kirmizi + " tane ard���k k�rm�z� ta� var!");
		
		//ikinci oyuncunun elinde ard���k toplam ta� say�s�n� hesaplama:
		counter_dorduncu_oyuncu = counter_dorduncu_oyuncu_sari + counter_dorduncu_oyuncu_mavi + counter_dorduncu_oyuncu_siyah + counter_dorduncu_oyuncu_kirmizi;
		System.out.println("Toplam... D�rd�nc� oyuncunun elinde " + counter_dorduncu_oyuncu + " tane ard���k ta� var!" );
		System.out.println();
		
		//Oyunu Kazanan� belirleme:
		int [] toplam_ardisik_taslar = {counter_birinci_oyuncu, counter_ikinci_oyuncu, counter_ucuncu_oyuncu, counter_dorduncu_oyuncu}; 
		int en_fazla_ardisik_tas_bulunan_el = toplam_ardisik_taslar[0];
		int index = 0;
		
		for(int i = 0; i < 4; ++i)
		{
			if(en_fazla_ardisik_tas_bulunan_el < toplam_ardisik_taslar[i])
			{
				en_fazla_ardisik_tas_bulunan_el = toplam_ardisik_taslar[i];
				index = i;
			}
			
		}
		
		if(index == 0)
		{
			// herhangi bir di�er oyuncu ile e�itlik halinde kazanan olmas�n:
			if( counter_birinci_oyuncu == counter_ikinci_oyuncu || counter_birinci_oyuncu == counter_ucuncu_oyuncu || counter_birinci_oyuncu == counter_dorduncu_oyuncu)
			{
				System.out.println("E�itlik var! Oyunu Bitirmeye en yak�n el yok ");
			}
			else
			{		
				System.out.println("Oyunu Bitirmeye en yak�n el: Birinci Oyuncu!");
				System.out.println(birinci_oyuncunun_eli);	
			}

		}
			
		else if(index == 1)
		{
			// herhangi bir di�er oyuncu ile e�itlik halinde kazanan olmas�n:
			if( counter_ikinci_oyuncu == counter_birinci_oyuncu || counter_ikinci_oyuncu == counter_ucuncu_oyuncu || counter_ikinci_oyuncu == counter_dorduncu_oyuncu)
			{
				System.out.println("E�itlik var! Oyunu Bitirmeye en yak�n el yok ");
			}
			else
			{		
				System.out.println("Oyunu Bitirmeye en yak�n el: �kinci Oyuncu!");
				System.out.println(ikinci_oyuncunun_eli);	
			}
			
		}
			
		else if(index == 2)
		{
			// herhangi bir di�er oyuncu ile e�itlik halinde kazanan olmas�n:
			if( counter_ucuncu_oyuncu == counter_birinci_oyuncu || counter_ucuncu_oyuncu == counter_ikinci_oyuncu || counter_ucuncu_oyuncu == counter_dorduncu_oyuncu)
			{
				System.out.println("E�itlik var! Oyunu Bitirmeye en yak�n el yok ");
			}
			else
			{		
				System.out.println("Oyunu Bitirmeye en yak�n el: ���nc� Oyuncu!");
				System.out.println(ucuncu_oyuncunun_eli);	
			}
			
		}
			
		else 
		{
			// herhangi bir di�er oyuncu ile e�itlik halinde kazanan olmas�n:
			if( counter_dorduncu_oyuncu == counter_birinci_oyuncu || counter_dorduncu_oyuncu == counter_ikinci_oyuncu || counter_dorduncu_oyuncu == counter_ucuncu_oyuncu)
			{
				System.out.println("E�itlik var! Oyunu Bitirmeye en yak�n el yok ");
			}
			else
			{		
				System.out.println("Oyunu Bitirmeye en yak�n el: D�rd�nc� Oyuncu!");
			}
		}
							
	}
}