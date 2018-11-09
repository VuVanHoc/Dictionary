
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class DictionaryManagement extends Dictionary {

    public void insertFromCommandline() {
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

    public void importFromFile() {
        String pathName = "data/dictionaries.txt";
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

    }

    public String getSpelling(String textInALine) {
        int index = 0;
        for (int i = 0; i < textInALine.length(); i++) {
            if (textInALine.charAt(i) == '\t') {
                index = i;
                break;
            }
        }
        return textInALine.substring(0, index);

    }

    public String getExplaining(String textInALine) {
        int index = 0;
        for (int i = 0; i < textInALine.length(); i++) {
            if (textInALine.charAt(i) == '\t') {
                index = i;
                break;
            }
        }
        return textInALine.substring(index + 1, textInALine.length());
    }

    public static String dictionaryLookup(String wordFinding) {

        wordFinding = wordFinding.toLowerCase();
        for (int i = 0; i < Dictionary.myList.size(); i++) {
            if (Dictionary.myList.get(i).getSpelling().toLowerCase().trim().equals(wordFinding)) {

                return Dictionary.myList.get(i).getExplain();
            }
        }
        return "Xin lỗi. Từ bạn cần tìm không có trong từ điển!";
    }

    public boolean isInDictionary(String word) {
        for (int i = 0; i < Dictionary.myList.size(); i++) {
            if (Dictionary.myList.get(i).getSpelling().equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void changeDataDictionary() {
        System.out.println("Nhap tu ban muon sua trong tu dien: ");
        Scanner sc = new Scanner(System.in);
        String spell = sc.nextLine();
        spell = spell.toLowerCase();

        if (isInDictionary(spell)) {
            System.out.println("Nhap nghia cua tu: ");
            String explain = sc.nextLine();
            Word word = new Word(spell, explain);
            for (int i = 0; i < Dictionary.myList.size(); i++) {
                if (Dictionary.myList.get(i).getSpelling().equals(spell)) {
                    Dictionary.myList.remove(i);
                    Dictionary.myList.add(i, word);
                    break;
                }
            }
            dictionaryExportToFile();
        } else {
            System.out.println("Xin loi ban!!! He thong khong co tu ban muon sua.");

        }

    }

    public void addNewWord() {
        System.out.println("Nhap tu ban muon them vao tu dien:");
        Scanner sc = new Scanner(System.in);
        String spell = sc.nextLine();
        spell = spell.toLowerCase();
        System.out.println("Nhap nghia cua tu:");
        String explain = sc.nextLine();
        explain = explain.toLowerCase();
        Word word = new Word(spell, explain);
        Dictionary.myList.add(word);
        dictionaryExportToFile();

    }

    public void deleteWord() {
        System.out.println("Nhap tu ban muon xoa khoi tu dien: ");
        Scanner sc = new Scanner(System.in);
        String spell = sc.nextLine();
        spell = spell.toLowerCase();

        if (isInDictionary(spell)) {
            for (int i = 0; i < Dictionary.myList.size(); i++) {
                if (Dictionary.myList.get(i).getSpelling().equals(spell)) {
                    Dictionary.myList.remove(i);
                    break;
                }
            }
            dictionaryExportToFile();
        } else {
            System.out.println("Xin loi ban!!! He thong khong co tu ban muon xoa.");

        }

    }

    public void dictionaryExportToFile() {
        String pathFile = "data/dictionaries.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(pathFile));

            for (int i = 0; i < Dictionary.myList.size(); i++) {
                String s;
                s = Dictionary.myList.get(i).getSpelling() + "\t" + Dictionary.myList.get(i).getExplain();

                bw.write(s);
                bw.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
