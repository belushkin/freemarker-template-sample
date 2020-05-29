package com.app02;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setIncompatibleImprovements(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(Main2.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("app02/test.ftl");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("msg", "Today is a beautiful day2");
        templateData.put("lang", "Java");

        try (StringWriter out = new StringWriter()) {
            template.process(templateData, out);
            System.out.println(out.getBuffer().toString());
            out.flush();
        }
    }
}
