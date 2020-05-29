package com.app03;

import com.app02.Main2;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3Html {

    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setIncompatibleImprovements(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(Main2.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("app03/personsHtmlPage.ftl");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("msg", "Today is a beautiful day2");
        templateData.put("lang", "Java");


        List<Person> persons = initPersons(10);
        templateData.put("persons", persons);


        try(Writer out = new FileWriter(new File("persons.html"))){
            template.process(templateData, out);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

        try (StringWriter out = new StringWriter()) {

            System.out.println(out.getBuffer().toString());
            out.flush();
        }
    }


    private static List<Person> initPersons(int n){
        List<Person> persons = new ArrayList();
        for(int i=0;i<n;i++){
            persons.add(new Person("Name"+i, i));
        }
        return persons;
    }
}
