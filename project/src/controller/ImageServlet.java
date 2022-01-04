package controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/servlet/ImageServlet")
public class ImageServlet extends HttpServlet {
    //步骤
    //1.定义BufferedImage对象
    //2.获得Graphics
    //3.通过Random长生随机验证码信息
    //4.使用Graphics绘制图片
    //5.记录验证码信息到session中
    //6.使用ImageIO输出图片
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //图片的宽度和高度
        int width=90;
        int height=33;
        //验证码个数和干扰线个数
        int len=4;
        int count=15;
        //设置图片宽高和图片类型
        BufferedImage image=new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        //1.获取图片画笔和设置字体
        Graphics graphics = image.getGraphics();
        graphics.setFont(new Font(null,Font.BOLD,height-4));
        //取随机验证码
        Random random=new Random();
        //2.设置画笔颜色绘画图片背景颜色
        graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        //3.绘制一个与设置图片大小一致
        graphics.fillRect(0, 0, width, height);
        //验证码字符
        String code="";
        char[] codeArray="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        //获取随机验证码
        for (int i = 0; i < len; i++) {
            char c=codeArray[random.nextInt(codeArray.length)];
            code=code+c;
            //设置验证码字体随机
            graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            //绘画验证码
            graphics.drawString(c+"", (i+1)*18, height-4);
        }
        //保存在session中
        HttpSession session=req.getSession();
        session.setAttribute("code",code);
        //绘制干扰线
        for (int i = 0; i < count; i++) {
            //设置随机干扰线颜色
            graphics.setColor(new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255),random.nextInt(255)));
            //绘制干扰线
            graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }
        //输出图片
        ImageIO.write(image,"png",resp.getOutputStream());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }
}

















