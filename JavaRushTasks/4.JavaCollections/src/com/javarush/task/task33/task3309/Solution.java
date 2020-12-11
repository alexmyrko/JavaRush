package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(obj,stringWriter);

        StringReader stringReader = new StringReader(stringWriter.toString());
        stringWriter = new StringWriter();
        BufferedReader reader = new BufferedReader(stringReader);
        String result = null;
        String row;
        while((row = reader.readLine()) != null) {
            if (row.contains(String.format("<%s>", tagName))) {
                result = String.format("<!--%s-->\n%s\n", comment, row);
            } else {
                result = row+"\n";
            }
            stringWriter.write(result);
        }
        return stringWriter.toString();
    }

    public static void main(String[] args) throws JAXBException, IOException {
        String result = toXmlWithComment(new First(), "second", "it's a comment");
        System.out.println(result);
    }


    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4 = "second";
        @XmlElement(name = "second")
        public String item5 = "![CDATA[need CDATA because of \"";
    }
}
