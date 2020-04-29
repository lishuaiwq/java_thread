package demon3;

import com.google.common.collect.Maps;

import java.util.Map;

public class Base {
    public static int c = 20;

    private int a = 10;

    private Integer b;


    public Base(){
        System.out.println("执行构造函数");
    }

    {
        System.out.println("执行普通代码块:a:"+a);
        System.out.println("执行普通代码块:b:"+b);
    }

    static {
        System.out.println(c);
        System.out.println("执行静态代码块:a:");
    }


/*    synchronized(){
        System.out.println(c);
        System.out.println("执行静态代码块:a:");
    }*/
    public synchronized static void main(String[] args) {



        Map<String,Object> map = Maps.newHashMap();
        int a = 0;
       map.put("b",a);
       Long b = Integer.toUnsignedLong((Integer) map.get("a")) ;
        System.out.println(b);
    }
}
