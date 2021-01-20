

public class test01 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        long i = 0;
        long start = System.currentTimeMillis();//记录开始时间
        while (i <= 1000000000) {
            i++;
        }

        long end = 0;//记录结束时间
        try {
            end = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long time = end - start;//计算消耗时间
        String string = "";
        if (string != null) {

        }

        System.out.println(time);

        System.out.println("一秒计算了" + 1000000000 / time * 1000 + "次");//计算并输出一秒计算次数.
    }

    @Override
    public void run() {
        int a = 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

