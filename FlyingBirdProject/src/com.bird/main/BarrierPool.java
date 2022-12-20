package com.bird.main;


import java.util.ArrayList;
import java.util.List;

/**
 * 为了避免反复的创建和销毁对象，使用对象池来提前创建好一些对象
 * 使用的时候从池子中获取，使用完毕后归还对象池
 */
public class BarrierPool {
    //用于管理池中所有对象的容器
    private static List<Barrier> pool = new ArrayList<>();
    //池中初始的对象个数
    public static final int initCount = 10;
    //对象池中的最大个数
    public static final int maxCount = 15;

    static {
        //初始化池中对象
        for (int i = 0; i < initCount; i++) {
            pool.add(new Barrier());
        }
    }

    /**
     * 从池子中获取一个对象
     */
    public static Barrier getPool() {
        int size = pool.size();

        //池中有对象才可以拿
        if (size > 0) {
            //移除并返回对象
            System.out.println("从池中拿走一个对象");
            return pool.remove(size - 1);
        } else {
            //没有对象就new
            System.out.println("新建一个对象");
            return new Barrier();
        }
    }

    /**
     * 有对象归还容器
     */
    public static void setPool(Barrier barrier) {
        if(pool.size() < maxCount) {
            pool.add(barrier);
            System.out.println("对象已归还池中");
        }
    }
}
