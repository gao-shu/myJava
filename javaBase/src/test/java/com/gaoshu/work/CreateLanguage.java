package com.gaoshu.work;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class CreateLanguage {
    public static void main(String[] args) {
        List<String> strings = readFiles("C:\\Users\\Admin\\Downloads\\zh-CN");
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> record = new HashMap<>();
        List<String> collect = strings.stream().filter(s -> false == s.contains("index.js")).collect(Collectors.toList());
        AtomicReference<String> nameFre = new AtomicReference<>("");
        collect.forEach(s -> {
            List<String> strings1 = readJs(s);
            List<String> collect1 = strings1.stream().filter(s1 -> false == s1.isEmpty()).collect(Collectors.toList());
            AtomicReference<String> name = new AtomicReference<>("");
            AtomicReference<String> value = new AtomicReference<>("");
            String s3 = collect1.get(collect1.size() - 1).split(":")[0].split("\\{")[1];
            AtomicReference<String> className = new AtomicReference<>(s3);

            collect1.forEach(s1 -> {
                String s2 = s1.trim();

                if(s2.isEmpty() || s2.startsWith("const") || s2.startsWith("||")
                        || s2.startsWith("}") || s2.startsWith("/*") || s2.startsWith("\\//")|| s2.startsWith("\\*")
                        || s2.startsWith("export") || s2.startsWith("...")||
                        StrUtil.startWith(s2, "*") ||StrUtil.startWith(s2, "//")
                        ||StrUtil.startWith(s2, "import") ||StrUtil.startWith(s2, "import")){
                }else if(StrUtil.startWith(s2, "commonPhrases") || StrUtil.startWith(s2, "teamMembers: {")
                        || StrUtil.startWith(s2, "distribute: {")|| StrUtil.startWith(s2, "fieldSort: {")
                        || StrUtil.startWith(s2, "duplicate: {")|| StrUtil.startWith(s2, "crmDetail: {")
                        || StrUtil.startWith(s2, "activity: {")|| StrUtil.startWith(s2, "followUp: {")
                        || StrUtil.startWith(s2, "activity: {")|| StrUtil.startWith(s2, "activity: {")){
                }else{
                    name.set(s2.substring(0, s2.indexOf(":")));
                    value.set(s2.substring(s2.indexOf(":") + 1, s2.length()));
                    value.set(value.get().substring(2, value.get().length()));
                    if( value.get().indexOf("'") > 0){
                        value.set(value.get().substring(0, value.get().indexOf("'")));
                    }else if(value.get().indexOf("`") > 0){
                        value.set(value.get().substring(0, value.get().indexOf("`")));
                    }else if(value.get().indexOf("'")<1){
                        value.set("");
                    }


                    if(s.contains("crm\\other")){
                        className.set("teamMembers");
                    }

                    String strip1 = StrUtil.strip(value.get(), "\\/");
                    String strip = StrUtil.strip(value.get(), "'");
                    record.put("chinese", value.get());
                    dataList.add(record);
                    System.out.println(className+"."+name+"@"+value.get());
                }
            });
        });
    }

    //遍历所有文件
    private static List<String> listQ = new ArrayList<String>();
    private static List<String> readFiles(String filePath){
        File f = null;
        f = new File(filePath);
        File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。
        List<File> list = new ArrayList<File>();

        for (File file : files) {
            if(file.isDirectory()) {
                //如何当前路劲是文件夹，则循环读取这个文件夹下的所有文件
                readFiles(file.getAbsolutePath());
            } else {
                list.add(file);
                listQ.add(file.getAbsolutePath());
            }
        }
//        for(File file : files) {
//            System.out.println(file.getAbsolutePath());
//        }
        return listQ;
    }
    //读取文件内容
    private static List<String> readJs(String fileUrl){
        List<String> strings = FileUtil.readLines(fileUrl, StandardCharsets.UTF_8);
        return strings;
    }
    //放入excel
    private static void writeJs(List<Map<String, Object>> dataList){
        try (ExcelWriter writer = ExcelUtil.getWriter()) {
            writer.addHeaderAlias("fileName", "原始字段");
            writer.addHeaderAlias("module", "所属模块");
            writer.addHeaderAlias("chinese", "中文");


//            translateMap.forEach((k, v) -> {
//                Map<String, Object> record = new HashMap<>();
//                record.put("fileName", k);
//                if (crmCustomFieldKey.contains(k)){
//                    record.put("module","crm.customField");
//                    record.put("chinese", chineseMap.get(k));
//                }if (jxcCustomFieldKey.contains(k)){
//                    record.put("module","jxc.customField");
//                    record.put("chinese", chineseMap.get(k));
//                } else if (backTipsKey.contains(k)){
//                    record.put("module", "backTips");
//                    record.put("chinese", chineseMap.get(k));
//                } else if (chineseModuleSet.contains(k)) {
//                    record.put("module",chineseModuleMap.get(k));
//                    record.put("chinese", chineseMap.get(k));
//                }
//                record.put("translateName", v);
//                dataList.add(record);
//            });

            writer.setOnlyAlias(true);
            writer.write(dataList, true);
            writer.setRowHeight(0, 20);
            for (int i = 0; i < 4; i++) {
                writer.setColumnWidth(i, 30);
            }
            Cell cell = writer.getCell(0, 0);
            CellStyle cellStyle = cell.getCellStyle();
            cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font font = writer.createFont();
            font.setBold(true);
            font.setFontHeightInPoints((short) 16);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
            //自定义标题别名
            //response为HttpServletResponse对象
            HttpServletResponse response = null;
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
            response.setHeader("Content-Disposition", "attachment;filename=languagePack.xls");
            ServletOutputStream out = response.getOutputStream();
            writer.flush(out);
        } catch (Exception e) {
//            log.error("导出语言包错误：", e);
        }
    }
}
