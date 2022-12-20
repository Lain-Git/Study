package com.bird.main;


import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 游戏前景类
 */
public class GameFront {
    //云彩个数
    private static final int cloud_count = 2;

    //存放云的容器
    private List<Cloud> clouds;

    //云的飞行速度
    private static final int cloud_speed = 1;

    //使用到的图片资源
    private BufferedImage[] img;

    //用于产生随机数
    private Random random;

    //构造器初始化数据
    public GameFront() {
        clouds = new ArrayList<>();
        img = new BufferedImage[cloud_count];

        //向容器中添加云的图片
        for (int i = 0; i < cloud_count; i++) {
            img[i] = GameUtil.loadBufferedImage("resources/cloud" + i + ".png");
        }
        random = new Random();
    }

    //绘制云
    public void draw(Graphics g) {
        logic();

        for(int i = 0; i < clouds.size(); i++) {
            clouds.get(i).draw(g);
        }
    }

    /**
     * 用于云彩的个数控制
     */
    private void logic() {
        if((int)500*Math.random() < 5) {
            Cloud cloud = new Cloud(img[random.nextInt(cloud_count)],cloud_speed,700,random.nextInt(150));
            clouds.add(cloud);
        }
        for(int i = 0; i < clouds.size(); i++) {
            Cloud cloud = clouds.get(i);
            if(cloud.isOutFrame()) {
                clouds.remove(i);
                i--;
                System.out.println("云被移除" + cloud);
            }
        }
    }
}
