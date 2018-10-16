
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
public class DictionaryCommandline extends DictionaryManagement {

    public void showAllWords() {
        System.out.println("No\t|English\t\t|Vietnamese");
        System.out.println();
        for (int i = 0; i < Dictionary.myList.size(); i++) {
            System.out.println((i + 1) + "\t|" + Dictionary.myList.get(i).getSpelling()
                    + "\t\t\t|" + Dictionary.myList.get(i).getExplain());
        }
    }

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        insertFromFile();
        System.out.println("!!! He thong tu dien Anh- Viet xin chao !!!");
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            printHint();
            number = sc.nextInt();
            switch (number) {
                case 1: 
                    dictionaryLookup();
                    break;
                case 2: 
                    break;
                case 3:
                    break;
                case 4:
                    changeDataDictionary();
                    break;
                case 5:
                    showAllWords();
                    break;
                case 6:
                    System.out.println("Ban co chac chan muon thoat khong? ");
                    System.out.println("Co(nhan phim 1)");
                    System.out.println("Khong(nhan phim 2)");
                    int temp = sc.nextInt();
                    switch (temp) {
                        case 1: 
                            System.out.println("!!!Cam on ban da su dung he thong!!!");
                            System.out.println("!! Hen gap lai !!");
                            return ;
                        case 2:
                            
                    }       
            }            
        }

    }
    public void printHint() {
        System.out.println("\n");
        System.out.println("*************************************************");
        System.out.println("*   Tra tu: Bam phim 1                          *");
        System.out.println("*`  Them tu moi: Bam phim 2                     *");
        System.out.println("*   Xoa tu: Bam phim 3                          *");
        System.out.println("*   Sua tu: Bam phim 4                          *");
        System.out.println("*   In toan bo tu dien: Bam phim 5              *");
        System.out.println("*   Thoat khoi he thong: Bam phim 6             *");
        System.out.println("*************************************************");
        System.out.print("Moi ban lua chon: ");
    }

}
