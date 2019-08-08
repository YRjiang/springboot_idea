package com.example.springboot.controller;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Objects;

public class ImageDecoder {

    /**
     * 本地图片转换Base64的方法 * * @param imgPath
     */
    private static void ImageToBase64(String imgPath) {
        byte[] data = null; // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
    }


    //生成图片到指定的目录下
/*    private static boolean GenerateImage(String imgStr, String imgFilePath) {
        try {
            Base64Decoder decoder = new Base64Decoder();
            //base64位字符串进行解码转换
            byte[] bytes = decoder.decode(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }*/


    /**
     * 图片转BASE64
     * @param imagePath 路径
     * @return
     */
    public static String imageChangeBase64(String imagePath){
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imagePath);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * BASE转图片
     * @param baseStr  base64字符串
     * @param imagePath 生成的图片
     * @return
     */
    public static boolean base64ChangeImage(String baseStr,String imagePath){
        if (baseStr == null){
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(baseStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imagePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String agr0) {
        //加密
        String basestr = imageChangeBase64("D://1.jpg");
        System.out.println(basestr);
        //解密
        base64ChangeImage(basestr,"D://2.jpg");
    }

}
