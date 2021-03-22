package J12;

public class IntHolder {
    private int value;

    public IntHolder(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString(){
        return String.valueOf(value);//valueOf(int i): 返回 int 参数的字符串表示形式。
    }

    public static void main(String[] args) {
        IntHolder h = new IntHolder(42);
        System.out.println(h);
    }

}
