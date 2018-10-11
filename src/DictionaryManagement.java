
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class DictionaryManagement {

    public  void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so luong tu: ");
        int soTu;
        soTu = sc.nextInt();

        String spelling, explain;

        for (int i = 0; i < soTu; i++) {
            Scanner s = new Scanner(System.in);
            System.out.print("Spelling: ");
            spelling = s.nextLine();
            System.out.print("Explain: ");
            explain = s.nextLine();

            Word word = new Word(spelling, explain);
            Dictionary.myList.add(word);
        }

    }

    public void insertFromFile() {
        String pathName = "D:\\OOP\\Java- Summer 2018\\Dictionary_English_Vietnamese\\data\\dictionaries.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pathName));
            String textInALine;
            while ((textInALine = br.readLine()) != null) {
                Word word = new Word(getSpelling(textInALine), getExplaining(textInALine));
                Dictionary.myList.add(word);
                
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.getStackTrace();
            }

        }
//        String s = "Vu van Hoc";
//        System.out.println(getExplaining(s));
//        System.out.println(getSpelling(s));

    }
    public String getSpelling(String textInALine) {
        int index = 0;
        for(int i=0; i<textInALine.length(); i++)
        {
            if(textInALine.charAt(i) == '\t') {
                index = i;
                break;
            }
        }
        return textInALine.substring(0, index + 1 );
        
    }
    
    public String getExplaining(String textInALine) {
        int index = 0;
        for(int i=0; i<textInALine.length(); i++)
        {
            if(textInALine.charAt(i) == '\t') {
                index = i;
                break;
            }
        }
        return textInALine.substring(index + 1, textInALine.length());
    } 

}
