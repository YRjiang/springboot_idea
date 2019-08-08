package com.example.springboot.controller;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class PdfDecoderTest {

    @Test
    public void baseTest(){
        // pdf 转 base64
        long timeMillis1 = System.currentTimeMillis();
        File file = new File("D://1.pdf");
        String pdfToBase64 = PDFToBase64(file);
        System.out.println(pdfToBase64);

        long timeMillis2 = System.currentTimeMillis();
        long l = timeMillis2 - timeMillis1;
        System.out.println(l);

        // base64 转 pdf
        base64StringToPdf(pdfToBase64,"D://pdf2.pdf");
        System.out.println(System.currentTimeMillis() - timeMillis2);

    }


    /**
     * Description: 将base64编码内容转换为Pdf
     * @param  "base64编码内容", 文件的存储路径（含文件名）
     * @Author fuyuwei
     * Create Date: 2015年7月30日 上午9:40:23
     */
    public static void base64StringToPdf(String base64Content, String filePath) {
        BASE64Decoder decoder = new BASE64Decoder();
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            byte[] bytes = decoder.decodeBuffer(base64Content);//base64编码内容转换为字节数组

            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            bis = new BufferedInputStream(byteInputStream);
            File file = new File(filePath);
            File path = file.getParentFile();
            if (!path.exists()) {
                path.mkdirs();
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //closeStream(bis, fos, bos);
            try {
                bis.close();
                fos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Description: 将pdf文件转换为Base64编码
     * @param  "要转的的pdf文件"
     * @Author fuyuwei
     * Create Date: 2015年8月3日 下午9:52:30
     */
    public static String PDFToBase64(File file) {
        BASE64Encoder encoder = new BASE64Encoder();
        FileInputStream fin = null;
        BufferedInputStream bin = null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout = null;
        try {
            fin = new FileInputStream(file);
            bin = new BufferedInputStream(fin);
            baos = new ByteArrayOutputStream();
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while (len != -1) {
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节
            bout.flush();
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                bin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
