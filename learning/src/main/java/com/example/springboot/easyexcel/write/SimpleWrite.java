package com.example.springboot.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.example.springboot.model.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class SimpleWrite {

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    /**
     * 最简单的写
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 直接写即可
     */

    @Test
    public void simpleWrite() {

        // 写法1
        String fileName = "E:/0.program/6.idea/springboot_idea/learning/src/main/resources/"
                //+ System.currentTimeMillis()
                + "demo.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

        log.info("这里测试 log4j2 日志打印");


        // 写法2
        /*
        fileName = "E:/0.program/6.idea/springboot_idea/learning/src/main/resources/"
                + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(data(), writeSheet);
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
        */
    }

}
