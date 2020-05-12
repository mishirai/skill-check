package q003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.TreeMap;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }
    public static void main(String[] args) {
        String line = null;
        String word = null;
        String[] exWord = {",","."};
        int i = 0;
        int cnt = 0;
        int wordSize = 0;
        Map<String, Integer> m = new HashMap<>();
        try {
            InputStream is = openDataFile();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {            //n行読み込み
                String[] strWord= line.split(" ",0);
                for (i=0; i < strWord.length;i++){
                    word = strWord[i];
                    wordSize = word.length();
                    //","と"."を取り除く
                    if ((word.substring(wordSize - 1)).equals(exWord[0])
                            || (word.substring(wordSize - 1)).equals(exWord[1])){
                        word = word.substring(0,wordSize-1);
                    }
                    //文字数のカウント
                    if (m.containsKey(word)){
                        cnt = m.get(word) +1;
                        m.replace(word,cnt);
                    }else{
                        m.put(word,1);
                    }
                }
            }
            TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(m);
            System.out.println("TreeMap");
            for (String key : treeMap.keySet()) {
                System.out.println(key + " = " + treeMap.get(key));
            }
        } catch (FileNotFoundException e1) {
            System.out.println("File is not exist.");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

}
// 完成までの時間: 8時間 xx分