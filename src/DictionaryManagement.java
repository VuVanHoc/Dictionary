
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

    public static void insertFromCommandline() {
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
        String pathName = "D:\\OOP\\Java- Summer 2018\\Dictionary_Requeriment\\data\\dictionaries.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pathName));
            String textInALine;
            while ((textInALine = br.readLine()) != null) {
                System.out.println(textInALine);
                textInALine = br.readLine();
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

    }

}
