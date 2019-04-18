package com.guoyu.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author guguoyu
 * @date 2019/4/18
 * @since JDK 1.8
 */
public class ImageUtil {
    /**
     * 用来生成告警图片，在原来的图片originPathName的基础上画上方框之后，并生成到新的图片地址generatedPathName
     *
     * @param originPathName    原始图片的地址；例如: /home/123.jpg
     * @param generatedPathName 生成告警之后的图片地址；例如： /home/456.jpg
     * @param x                 离原点横向的距离（原点的位置为图片的左上角）,单位为像素；例如：50
     * @param y                 离原点纵向的距离（原点的位置为图片的左上角）,单位为像素；例如：60
     * @param width             方框的宽度,单位为像素；例如：100
     * @param height            方框的高度,单位为像素；例如：200
     * @author guguoyu
     */
    public static void drawRectangle(String originPathName, String generatedPathName, int x, int y, int width, int height) {

        try {
            //图片路径
            BufferedImage image = ImageIO.read(new File(originPathName));
            Graphics2D graphics = image.createGraphics();
            //画笔颜色
            graphics.setColor(Color.RED);
            //矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
            graphics.drawRect(x, y, width, height);
            //输出图片的地址
            FileOutputStream out = new FileOutputStream(generatedPathName);

            ImageIO.write(image, "jpeg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
