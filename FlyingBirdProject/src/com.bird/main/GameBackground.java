package com.bird.main;

import com.bird.util.Constant;
import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.bird.util.Constant.FRAME_HEIGHT;
import static com.bird.util.Constant.FRAME_WIDTH;
import static com.bird.util.Constant.bg_color;

/**
 * 游戏背景类
 */
public class GameBackground {
    //背景需要的资源图片
    private BufferedImage bg_img;

    //构造器初始化资源
    public GameBackground() {
        bg_img = GameUtil.loadBufferedImage(Constant.bg_img_path);
    }

    //绘制图片
    public void draw(Graphics g) {

        //填充背景色,在绘制图片之前填充
        g.setColor(bg_color);
        g.fillRect(0,0,FRAME_WIDTH,FRAME_HEIGHT);
        g.setColor(Color.black);

        //得到图片的宽度跟高度
        int height = bg_img.getHeight();
        int width = bg_img.getWidth();

        //所需要的图片的张数
        int count = FRAME_WIDTH/width + 1;
        for(int i = 0; i < count; i++) {
            g.drawImage(bg_img, width*i, Constant.FRAME_HEIGHT-height, null);
        }
    }
}
