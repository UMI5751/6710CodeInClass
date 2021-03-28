package C01;

public class MaternalLine {
    static String maternalAncestor(int n){
        assert n >= 1; //如果n>=1则程序继续执行，否则会抛出exception
        if (n == 1){
            return "mother";
        }else if (n ==2){
            return "grandmother";
        }
        return "great-" + maternalAncestor(n - 1); //recursive
    }

    public static void main(String[] args) {
        System.out.println("Maternal order 1 is" + maternalAncestor(1));
        System.out.println("Maternal order 2 is" + maternalAncestor(2));

    }
}
