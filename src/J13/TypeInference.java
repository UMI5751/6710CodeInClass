package J13;

import java.util.LinkedList;
import java.util.Objects;
import java.util.function.IntFunction;

public class TypeInference {

    static class ThingHolder<T>{
        private T value;

        public ThingHolder(T value) {
            this.value = value;
        }

        public static <U> ThingHolder<U> makeHolder(U value){//传入U类对象，并用U类对象作为参数生成ThingHolder类对象
            return new ThingHolder(value);
        }
    }




    public static void main(String[] args) {
        var theAnswer = 42;
        System.out.println(theAnswer);

        LinkedList<String> s = new LinkedList<>() ;
        s.add("Hello");

        ThingHolder<String> holder = new ThingHolder<>("Hello");
        var anotherHolder = new ThingHolder<>("Hi again"); //java可以自动识别是String变量

        var yetAnotherHolder = ThingHolder.makeHolder(Integer.valueOf(42));

        //LinkedList<Object> x = new LinkedList();

        IntFunction increment = x -> x +1; //IntFunction默认x是int类型，必须用特定的lambda interface
        //var increment2 = x -> x + 1;//invalid，Java不知道x的类型




    }

}
