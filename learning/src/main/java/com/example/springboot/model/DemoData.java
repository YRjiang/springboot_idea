package com.example.springboot.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

@Data
// 以下三个注解设置
@ContentRowHeight(20) // 内容单元格的高度
@HeadRowHeight(40) // 标题单元格的高度
@ColumnWidth(25)
public class DemoData {

    @ExcelProperty(value = {"主标题", "字符串标题"}, index = 0) // index 指定哪一列
    private String string;

    @ExcelProperty(value = {"主标题", "日期标题"})
    @ColumnWidth(50)  // 宽度为50
    private Date date;

    @ExcelProperty(value = {"主标题", "数字标题"})
    private Double doubleData;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;

}
