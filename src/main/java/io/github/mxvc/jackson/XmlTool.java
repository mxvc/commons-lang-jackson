package io.github.mxvc.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class XmlTool {

    public static String beanToXml(Object bean) throws JsonProcessingException {
        ObjectMapper xmlMapper = new XmlMapper();

        //忽略空属性
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        ObjectWriter objectWriter = xmlMapper.writerWithDefaultPrettyPrinter();

        String xml = objectWriter.writeValueAsString(bean);
        return xml;
    }

    public static <T> T xmlToBean( String xml, Class<T> cls) throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        return mapper.readValue(xml, cls);
    }

    public static <T> List<T> xmlToBeanListQuietly(String xml, Class<T> cls) {
        if (xml == null) {
            return null;
        }
        try {
            ObjectMapper mapper = new XmlMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, cls);
            return mapper.readValue(xml, javaType);
        } catch (Exception e) {
            e.printStackTrace(); // ignore
        }
        return null;
    }

}
