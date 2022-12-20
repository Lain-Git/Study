package com.bird.main;


import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 云类
 */
public class Cloud {
    //云图片
    private BufferedImage img;

    //云的移速
    private int speed;

    //云的位置
    private int x, y;

    public Cloud(BufferedImage img, int speed, int x, int y) {
        this.img = img;
        this.speed = speed;
        this.x = x+250;
        this.y = y+50;
    }

    public void draw(Graphics g) {
        x -= speed;
        g.drawImage(img, x, y, null);
    }

    /**
     * 用于判断云是否飞出屏幕之外
     */
    public boolean isOutFrame() {
        if(x < -150)
            return true;
        return false;
    }
}
