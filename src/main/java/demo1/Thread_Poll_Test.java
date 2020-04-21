package demo1;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Thread_Poll_Test {
   public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16,
            120, TimeUnit.SECONDS, new LinkedBlockingQueue<>(120));

    public static void main(String[] args) {


        threadPoolExecutor.submit(() -> System.out.println("呵呵呵"));



/*

        try{   retry:

            for(int i= 0;i<10;i++){
                System.out.println("haha");
                for(int j = 0;j<5; j++){
                    if(j==5){
                        continue retry;
                    }
                }

            }
        }finally {
            System.out.println("fibnally");
        }

        System.out.println("hehe");
*/
/*        DecimalFormat decimalFormat = new DecimalFormat("0.#");
       *//* String distance = decimalFormat.format(0);
        System.out.println(distance);*//*


            int views =189999;
            *//**18.0这种只展示18**//*
            if (views / 10000 >= 1) {
                BigDecimal divide = new BigDecimal(views).divide(new BigDecimal(10000));
                System.out.println(decimalFormat.format(divide) + "w");;
            } else {
                System.out.println(String.valueOf(views));;
            }*/

        List<String> list = Lists.newArrayList();
        for(int i = 0;i < 100 ;i ++){
            list.add(String.valueOf(i));
        }
    /*    Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }*/
    for(String s:list){
        System.out.println(s+"1"+"2");
    }
    }
}
