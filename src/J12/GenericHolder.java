package J12;

public class GenericHolder <T> { //T代表general的类，看调用时候具体传什么,可以传多个
    private T value;

    static class A{
        @Override
        public String toString(){
            return  "this is an instance of A ";
        }
    }

    public GenericHolder(T value){
        this.value = value;

    }

    public T getValue(){
        return value;
    }

    public <U> String addToString(U something){//类内需要传入另一个generic类的实例
        return this.toString() + something.toString();
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        GenericHolder<Integer> h = new GenericHolder<>(42);// 在这里具体化用什么type的类
        GenericHolder<Long> l = new GenericHolder<>(42l);
        System.out.println(l);
        System.out.println(h);

        GenericHolder<A> aHolder = new GenericHolder<>(new A());//需要A类的实例作为constructor，new一个传进去,允许生成static nested class的实例
        System.out.println(aHolder);

        Long bigNumber = 1000000l;
        System.out.println(aHolder.addToString(bigNumber));
    }

}
