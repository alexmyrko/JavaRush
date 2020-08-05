
/**
 * Created by Alex on 29.11.2019.
 */
class Dog{
    void bork(){
        System.out.println("Woff");
        this.mneu();
    }
    void mneu(){
        System.out.println("Mneu");
    }
    Dog(String s){
        System.out.println("Dog says " + s);
    }

    Dog(int i){
        this("woff");
        System.out.println(i + " times");
    }
}

public class solution1 {
    public static void main(String[] args) {
    Dog dog1 = new Dog(3);
    }
}
