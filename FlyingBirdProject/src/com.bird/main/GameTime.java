package com.bird.main;

public class GameTime {
    //开始
    private long beginTime;
    //结束
    private long endTime;
    //时间差
    private long differ;

    public GameTime(){}

    public void begin() {
        beginTime = System.currentTimeMillis();
    }

    public long differ() {
        endTime = System.currentTimeMillis();
        return differ = (endTime - beginTime)/1000;
    }
}
