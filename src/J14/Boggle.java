package J14;

import java.util.Random;

public class Boggle {
    static String[] dice= {"AJBBOO", "AFFPSK", "ANEAGE", "APSHCO", "FDEJHG", "ONFDJJ", "HSOWHY", "KSOEYC", "IWHDNC", "JDUYHS", "OSJHSN", "LSOSPJ", "JDUDHD", "KSLDOE", "KHYTDS", "KSIOPE"};//不全总共16个string，还有很多字母,代表16个dice，每面6个字母

    static final int ROW_Length = 16;

    public static void main(String[] args) {
        char[] boggleDice = shake();
    }

    public static char[] shake() {
        char[] boggleDice = new char[16];
        Random rand = new Random(10);
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

        return boggleDice;
    }
}
