package J14;

import org.junit.jupiter.api.Test;

import java.awt.desktop.AppReopenedEvent;
import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Boggle {
    static String[] dice= {"AJBBOO", "AFFPSK", "ANEAGE", "APSHCO", "FDEJHG", "ONFDJJ", "HSOWHY", "KSOEYC", "IWHDNC", "JDUYHS", "OSJHSN", "LSOSPJ", "JDUDHD", "KSLDOE", "KHYTDS", "KSIOPE"};//不全总共16个string，还有很多字母,代表16个dice，每面6个字母

    static final int ROW_Length = 4;

    static List<Set<Integer>> neighbours = new ArrayList<Set<Integer>>(dice.length);

    char[] boggleCharacters;
    Set<String> dictionary;

    /*
     0   1  2  3
     4   5  6  7
     8   9 10 11
     12 13 14 15
       the neighbouring 5 are 0 ,1, 2, 4, 6, 8, 9, 10
     */

    static {
        for (int i = 0; i < dice.length; i++){
            Set<Integer> neighbourOfI = new HashSet<>();
            int x = i / 4;
            int y = i % 4;
            for (int neighbourX = x - 1; neighbourX <= x + 1; neighbourX++) {//i左右相邻的数的上下模4同余的数
                if (neighbourX >= 0 && neighbourX < ROW_Length) {
                    for (int neighbourY = y - 1; neighbourY <= y + 1; neighbourY++) {//i左右相邻的数的上下模4同余的数
                        if (neighbourY >= 0 && neighbourY < ROW_Length) {
                            int neighbourDieNumber = neighbourX * 4 + neighbourY;//在同一列上相邻的数必然模4同余
                            neighbourOfI.add(neighbourDieNumber);
                        }
                    }
                }
            }
            neighbours.add(neighbourOfI);

        }
    }

    Boggle(){
        boggleCharacters = shake();
        dictionary = processDictionary("assets/engmix.txt");
    }

    public static void main(String[] args) {
        Boggle boggle = new Boggle();
        boggle.solve();
    }

    void solve(){
        for (int i = 0; i < dice.length; i++) {
            int start = i;
            boolean[] alreadyVisited = new boolean[dice.length];
            alreadyVisited[start] = true;
            String prefix = String.valueOf(boggleCharacters[start]);

            findWords(start, alreadyVisited, prefix);
        }
        //start at a particular die

        //for each neighbouring die
        //move to neighbour

    }

    private void findWords(int start, boolean[] alreadyVisited, String prefix) {
        for (Integer neighbour : neighbours.get(start)){
            if (!alreadyVisited[neighbour]){
                //recur
                String candidate = prefix + boggleCharacters[neighbour];
                if (candidate.length() >=3 && dictionary.contains(candidate)){
                    System.out.println(candidate);
                }
                alreadyVisited[neighbour] = true;
                findWords(neighbour, alreadyVisited, candidate);
                alreadyVisited[neighbour] = false;
            }
        }
    }

    Set<String> processDictionary(String filename){
        Set<String> words = new HashSet<>();
        try {
            Scanner s = new Scanner(new File(filename));//读取文件
            while (s.hasNext()){
                String word = s.next().toUpperCase();
                words.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(words.size());
        return words;

    }

    public static char[] shake() {
        char[] boggleDice = new char[16];
        Random rand = new Random();
        StringBuilder result = new StringBuilder();//更好用
        boolean[] alreadyselected = new boolean[dice.length];
        for (int i = 0; i < dice.length; i++){
            int face = rand.nextInt(6);//bound，随机数产生的最大值
            int die = rand.nextInt(dice.length);
            while (alreadyselected[die]){
                die = (die + 1) % dice.length; //防止die大于16,运行速度更快
                //die = rand.nextInt(dice.length);
            }
            alreadyselected[die] = true;
            char faceChar = dice[die].charAt(face);
            boggleDice[i] = faceChar;
            result.append(faceChar);
            if (i % ROW_Length == ROW_Length - 1){ //从0开始，第四个是序号3，改成4*4显示结果
                //result.append("\n");
                result.append(System.lineSeparator());//Unix和Windows系统的lineseperator不一样，最好这样写。
            }
        }
        System.out.println(result.toString());
        return boggleDice;
    }

    @Test
    public void testDictionary(){
        Boggle boggle  = new Boggle();
        assertTrue(boggle.dictionary.contains("THIN"));
        assertFalse(boggle.dictionary.contains("sfsdafdsa"));
    }

}
