package Week_7;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    HashMap<String, String> dic = new HashMap<String, String>();
    public String translate(String word) {
       return dic.get(word);
    }

    public void add(String word, String translation) {
        dic.put(word, translation);
    }
    public int amountOfWords(){
        return dic.size();
    }

    public ArrayList<String> translationList() {

        ArrayList<String> translations = new ArrayList<>();

        for (String key : this.dic.keySet()) {
            String value = this.dic.get(key);
            translations.add(key + " = " + value);
        }

        return translations;  }
}
