package q002;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * Q002 並べ替える
 *
 * dataListに "ID,名字" の形式で20個のデータがあります。
 * これをID順に並べて表示するプログラムを記述してください。
 *
 * dataListの定義を変更してはいけません。
 *
 *
[出力結果イメージ]
1,伊藤
2,井上
（省略）
9,清水
10,鈴木
11,高橋
（省略）
20,渡辺
 */
public class Q002 {
    /**
     * データ一覧
     */
    private static final String[] dataList = {
            "8,佐藤",
            "10,鈴木",
            "11,高橋",
            "12,田中",
            "20,渡辺",
            "1,伊藤",
            "18,山本",
            "13,中村",
            "5,小林",
            "3,加藤",
            "19,吉田",
            "17,山田",
            "7,佐々木",
            "16,山口",
            "6,斉藤",
            "15,松本",
            "2,井上",
            "4,木村",
            "14,林",
            "9,清水"
    };
    public static void main(String[] args) {
        Arrays.sort(dataList);
        System.out.println(Arrays.asList(dataList));

        ArrayList<Person> persons = new ArrayList<>();
        for (String line : dataList) {
            String[] strData= line.split(",",0);
            persons.add(new Person(Integer.parseInt(strData[0]),strData[1]));
        }
        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person personFirst, Person personSecond) {
                return Integer.compare(personFirst.getId(), personSecond.getId());
            }
        });
        for (int i = 0; i < dataList.length; i++){
            System.out.println(persons.get(i));
        }
    }
    public static class Person  {
        private Integer id;
        private String name;

        public Person(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return this.id;
        }
        public String getName() {
            return this.name;
        }
        public String toString() {
            return id+ "," + name;
        }
    }
}
// 完成までの時間: 4時間 0分