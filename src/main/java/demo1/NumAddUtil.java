package demo1;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class NumAddUtil {
private  volatile static int num = 0;
   private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static int add(int a) throws InterruptedException {
         num = 1;
        TimeUnit.SECONDS.sleep( 1);
        return num+1;
    }

    public static void main(String[] args) {
/*        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for( int i =0 ;i <20 ;i++){
            executorService.execute(()-> {
                try {
                   for(int j=0;j<10;j++){
                       TimeUnit.SECONDS.sleep( 1);
                       NumAddUtil.num++;
                   };
                   System.out.println(   NumAddUtil.num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }*/
/*        List<String> list = Lists.newArrayList();
        list.add("123");
        list.add("234");
        list.add("123");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        for(String s:collect){
            System.out.println(s);
        }*/
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
/*        BigDecimal bigDecimal = new BigDecimal(9999);
        BigDecimal bigDecima2 = new BigDecimal(10000);*/
/*        BigDecimal divide = bigDecimal.divide(bigDecima2,1,BigDecimal.ROUND_HALF_UP);
        if(divide.compareTo(new BigDecimal(1)) >= 0){
            System.out.println(divide);
        }else {
            System.out.println(bigDecimal);
        }*/
int views = 11234;
        /**18.0这种只展示18**/
        BigDecimal divisor = new BigDecimal(10000);
        if (views / divisor.intValue() >= 1) {
            BigDecimal divide = new BigDecimal(views).divide(divisor);
            System.out.println(decimalFormat.format(divide) + "w+浏览");
        } else {
            System.out.println(String.valueOf(views)+"浏览");
        }
    }

}
