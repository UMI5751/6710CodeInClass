package J10;

public class Boxing {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(6); // 新建一个Integer object并赋值,不管写多少次valueof（6），Java都会返回同一个object
        a = Integer.valueOf(6);//java总是会返回同一个object
        a = Integer.valueOf(6);
        a = Integer.valueOf(6);

        Integer a1 = new Integer(6); //java会返回不同的object，每次都会新建一个,Create a brand new object Integer.valueof(6)
        Integer b = 6;//这样也可以，更简单，autoboxing,会指向之前创建过的Integer a

        Object z = a;
        Integer y = (Integer) z;

        int c = y;
        int d = new Integer(6);

        int e = b; //unboxing

        Integer[] arrayofInteger = new Integer[100]; //expensive to store
        int[] arrayOfInt = new int[100];



        if (a == b){//检查是否同一个object，指针是否指向同一个object，equal()会检测对象内部是否完全一致
            System.out.println("equal");
        }

        if (a1 == b){ //
            System.out.println("==");
        }else{
            System.out.println("not ==");
        }

        if (a1.equals(b)){ //，equal()会检测对象内部是否完全一致
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }




    }
}
