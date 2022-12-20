package com.bird.main;


import com.bird.util.Constant;
import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.image.BufferedImage;

/**
 * 障碍物类
 */
public class Barrier {
    //障碍物矩形对象
    private Rectangle rect;

    private boolean mob = true;

    //障碍物的移动速度
    private int speed = 3;

    //障碍物图片
    private static BufferedImage[] imgs;

    //障碍物的存活状态
    private boolean visible;

    static {
        final int count = 3;
        //类加载的时候将三个图片初始化
        imgs = new BufferedImage[count];
        for (int i = 0; i < count; i++) {
            imgs[i] = GameUtil.loadBufferedImage(Constant.barrier_img_path[i]);
        }
    }

    //障碍物的位置
    private int x, y;

    //障碍物的宽度、高度
    private int width, height;

    //障碍物的类型
    private int type;
    public static final int type_top = 0;
    public static final int type_bottom = 2;
    public static final int type_among = 4;
    public static final int type_mobile = 6;


    //获得障碍物的宽和高
    public static final int barrier_width = imgs[0].getWidth();
    public static final int barrier_height = imgs[0].getHeight();
    public static final int barrier_head_width = imgs[1].getWidth();
    public static final int barrier_head_height = imgs[1].getHeight();

    public Barrier(){
        rect = new Rectangle();
    };

    public Barrier(int x, int y, int height, int type) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.type = type;
        this.width = barrier_width;
    }

    //根据不同的类型绘制障碍物
    public void draw(Graphics g) {
        switch (type) {
            case type_top:
                drawTop(g);
                break;
            case type_bottom:
                drawBottom(g);
                break;
            case type_among:
                drawAmong(g);
                break;
            case type_mobile:
                drawMobile(g);
                break;
        }
    }

    //绘制从上向下的障碍物
    private void drawTop(Graphics g) {
        //求出所需要的障碍物的块数
        int count = (this.height - barrier_head_height)/barrier_height + 1;
        //for循环绘制障碍物
        for (int i = 0; i < count; i++) {
            g.drawImage(imgs[0], this.x, this.y+i*barrier_height, null );
        }
        //绘制障碍物的头
        int y = this.height-barrier_head_height;
        g.drawImage(imgs[2], x-(barrier_head_width-barrier_width)/2, y, null);
        x -= speed;
        if(x < -50) {
            visible = false;
        }
        rect(g);
    }

    //绘制从下向上的障碍物
    public void drawBottom(Graphics g) {
        //求出所需要的障碍物的块数
        int count = height/barrier_height + 1;
        //for循环绘制障碍物
        for (int i = 0; i < count; i++) {
            g.drawImage(imgs[0], this.x, Constant.FRAME_HEIGHT-i*barrier_height, null);
        }
        //绘制障碍物的头
        int y = Constant.FRAME_HEIGHT-height;
        g.drawImage(imgs[1], x-(barrier_head_width-barrier_width)/2, y, null);
        x -= speed;
        if(x < -50) {
            visible = false;
        }
        rect(g);
    }

    //绘制中间的障碍物
    public void drawAmong(Graphics g) {
        //求出所需要的障碍物的块数
        int count = (height-barrier_head_height)/barrier_height;
        //绘制上方的头部
        g.drawImage(imgs[1], x, y, null);
        //for循环绘制障碍物
        for (int i = 0; i < count; i++) {
            g.drawImage(imgs[0], this.x, y + barrier_head_height + i * barrier_height, null);
        }
        rect(g);
        //绘制下方的头部
        int y11 = y + height - barrier_head_height;
        g.drawImage(imgs[2], x, y11, null);
        x -= speed;
        if(x < -50) {
            visible = false;
        }
    }

    //绘制可以移动的障碍物
    public void drawMobile(Graphics g) {
        //求出所需要的障碍物的块数
        int count = (height-barrier_head_height)/barrier_height;
        //绘制上方的头部
        g.drawImage(imgs[1], x, y, null);
        //for循环绘制障碍物
        for (int i = 0; i < count; i++) {
            g.drawImage(imgs[0], this.x, y + barrier_head_height + i * barrier_height, null);
        }
        rect(g);
        //绘制下方的头部
        int y11 = y + height - barrier_head_height;
        g.drawImage(imgs[2], x, y11, null);
        x -= speed;
        if(x < -50) {
            visible = false;
        }
        //设置障碍物移动条件
        if(mob) {
            y += 5;
            if(y >= 250) {
                mob = false;
            }
        } else if (!mob) {
            y -= 5;
            if(y <= 100) {
                mob = true;
            }
        }
    }

    /**
     * 绘制障碍物矩形
     * @return
     */
    public void rect(Graphics g) {
        int x_1 = this.x;
        int y_1 = this.y;
        int w_1 = imgs[0].getWidth();
        //g.setColor(Color.blue);
        //g.drawRect(x_1, y_1, w_1, height);
        setRectangle(x_1, y_1, w_1, height);
    }

    /**
     * 障碍物的碰撞矩形参数
     * @return
     */
    public void setRectangle(int x, int y, int width, int height) {
        rect.x = x;
        rect.y = y;
        rect.width = width;
        rect.height = height;
    }

    //判断什么时候绘制下一组障碍物
    public boolean isInFrame() {
        return 1000-x > 300;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Rectangle getRect() {
        return rect;
    }
}
