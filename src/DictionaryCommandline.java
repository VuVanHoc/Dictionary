/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class DictionaryCommandline extends DictionaryManagement{

    public  void showAllWords() {
        System.out.println("No \t | English \t\t |Vietnamese");
        for(int i=0; i< Dictionary.myList.size(); i++)
        {
            System.out.println((i+1) + " \t | " + Dictionary.myList.get(i).getSpelling()
                 + " \t\t |" + Dictionary.myList.get(i).getExplain());
        }
    }
    
    public void dictionaryBasic(){
        insertFromCommandline();
        showAllWords();
    }
    
    public void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        dictionaryLookup();
    }
    
}
