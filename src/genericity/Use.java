package genericity;

import java.util.Random;

public class Use {
    public static void main(String[] args) {
        //用String赋值给E
        Demo<String> demo=new Demo<>();
        demo.add("libowen");
        //demo.add(1);
        Demo<Random> demo1=new Demo<>();
        demo1.add(new Random());
    }
}
