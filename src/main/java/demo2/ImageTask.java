package demo2;

public class ImageTask {
    public String  producerImage(Integer integer){
        try {
            //任务耗时这么多~
            Thread.sleep(1000);
            return String.valueOf(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
