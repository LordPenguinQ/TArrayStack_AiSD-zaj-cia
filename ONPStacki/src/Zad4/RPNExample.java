package Zad4;

import lib.tools.RPNGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RPNExample {
    public static void run(){
        Scanner scan=new Scanner(System.in);
        String pathname="";     //plik zanjduje się w pliku obok src (nie wewnątrz)
                                //plik podawać bez rozszeżenie .txt \/
        String example="";
        do{
            System.out.println("Podaj pilik !");
            try{
                pathname=scan.nextLine()+".txt";       //statyczne dodawanie rozszeżenia .txt
            }catch(IllegalArgumentException e){
                System.out.println("Błędna nazwa / brak nazwy"+e);
            }
        }while(pathname.isEmpty());

        try{
            File fileExaple=new File(pathname);
            Scanner reader=new Scanner(fileExaple);
//            while(reader.hasNextLine()){      //do pobierania linijek z folderu ( jak jest wincej niż jena)
//                example=reader.nextLine();
//            }
            example=reader.nextLine();
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("Brak pliku !!");
        }
        System.out.println(example);
        RPNGenerator rpnGenerator=new RPNGenerator(256);

        String out = rpnGenerator.generator(example);
        System.out.println(out);
    }
}
