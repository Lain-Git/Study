package com.bird.main;


import static com.bird.util.Constant.*;
import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 小鸟类
 */
public class Bird {
    //小鸟矩形对象
    private Rectangle rect;

    //小鸟加速度
    private int acceleration;

    //小鸟的生命
    public boolean life = true;

    //存放小鸟图片
    private BufferedImage[] images;
    public static final int bird_img_count = 8;

    //鸟的状态(数组模拟多帧)
    private int state;
    public static final int state_0 = 0;
    public static final int state_1 = 1;
    public static final int state_2 = 2;
    public static final int state_3 = 3;
    public static final int state_4 = 4;
    public static final int state_5 = 5;
    public static final int state_6 = 6;
    public static final int state_7 = 7;

    //小鸟的位置
    private int x = 200, y = 200;

    //小鸟移动方向——上、下
    private boolean up = false,down = false;

    //小鸟初始移速
    private int speed = 4;

    //构造方法中对资源初始化
    public Bird() {
        images = new BufferedImage[bird_img_count];
        for(int i = 0; i < bird_img_count; i++) {
            images[i] =GameUtil.loadBufferedImage(bird_img[i]);
        }

        int w = images[0].getWidth();
        int h = images[0].getHeight();
        rect = new Rectangle(w, h);
    }

    //绘制小鸟
    public void draw(Graphics g) {
        flyLogic();
        g.drawImage(images[state],x,y,null);
        //小鸟矩形绘制
        //g.drawRect(x, y, (int)rect.getWidth(), rect.height);
        rect.x = this.x;
        rect.y = this.y;
    }

    //控制小鸟移动方向
    public void flyLogic() {
        if(up) {
            acceleration--;
            y += acceleration;
            if (acceleration < -10) {
                acceleration = -10;
            }
            if(y < 10) {
                y = 10;
                acceleration = 0;
            }
        }
        if(!up) {
            acceleration++;
            y += acceleration;
            if (acceleration > 10) {
                acceleration = 10;
            }
            if(y > 440) {
                y = 440;
                acceleration = 0;
            }
        }
    }

    public void fly(int fly) {
        switch (fly) {
            case 1:
                state = 1;
                up = true;
                break;
            case 2:
                state = 2;
                up = false;
                break;
        }
    }

    public Rectangle getRect() {
        return rect;
    }

    /**
     * 重新绘制小鸟的位置
     */
    public void reStartDraw() {
        life = true;
        x = 200;
        y = 200;
    }
}
