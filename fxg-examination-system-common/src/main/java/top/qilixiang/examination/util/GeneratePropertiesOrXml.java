package top.qilixiang.examination.util;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;

import java.io.*;
import java.util.Map;
import java.util.Properties;

@Slf4j
/**
 * Properties可以创建xx.properties ; xx.xml文件
 */
public class GeneratePropertiesOrXml {

    public static void readPropertyFile(String fileName, Map<String, String> map, String comments) {
        Long startTime = System.currentTimeMillis();

        /*"./src/main/java/top/qilixiang/examination/util/"*/
        Properties properties = new Properties();
        File file = new File(fileName);//"./src/main/java/com/fxiaoke/demo/javaDemo/config.properties"
        if (!file.exists()) {
            try {
                file.createNewFile();
                log.info("{}文件创建成功", file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (OutputStream outputStream = new FileOutputStream(file)) {
            map.forEach((k, v) -> properties.setProperty(k, v));
            if (fileName.endsWith(".xml")) {
                properties.storeToXML(outputStream, comments, String.valueOf(Charsets.UTF_8));
            } else {
                properties.store(outputStream, comments);
            }
            Long endTime = System.currentTimeMillis() - startTime;
            log.info("写入成功,耗时:{}", endTime);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         driverClassName=com.mysql.jdbc.Driver
         validationQuery=SELECT 1
         jdbc_url=jdbc:mysql://localhost:3306/work_attendance?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull
         jdbc_username=root
         jdbc_password=root
         */
        Map map = Maps.newHashMap();
        map.put("driverClassName", "com.mysql.jdbc.Driver");
        map.put("jdbc_url", "jdbc:mysql://localhost:3306/fxg_examination_system?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
        map.put("jdbc_username", "root");
        map.put("jdbc_password", "123456");
        readPropertyFile("jdbc.properties", map, "jdbc配置项");

    }
}
