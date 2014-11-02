package zinjvi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * Created by zinchenko on 02.11.14.
 */
public class FM {

    public static final Map MAP = new HashMap();
    static {
        MAP.put("kXXX", "from map");
    }

    public static void main(String[] args) {
        //Freemarker configuration object
        Configuration cfg = new Configuration();

        cfg.setSharedVariable("dir", new Dir());

        try {
            //Load template from source folder
            Template template = cfg.getTemplate("src/main/java/test.ftl");

            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("message", "Hello World!");
//            data.put("key", "value");

            //List parsing
            List<String> countries = new ArrayList<String>();
            countries.add("India");
            countries.add("United States");
            countries.add("Germany");
            countries.add("France");

            data.put("countries", countries);


            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

//            // File output
//            Writer file = new FileWriter (new File("C:\\FTL_helloworld.txt"));
//            template.process(data, file);
//            file.flush();
//            file.close();


            System.out.println(MAP);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    static class Dir implements TemplateDirectiveModel {

        @Override
        public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                            TemplateDirectiveBody templateDirectiveBody)
                throws TemplateException, IOException {



//            environment.


            environment.getDataModel().

            String templateName = (String) map.get("template").toString();

            if(MAP.containsKey(templateName)) {


                environment.getOut().append((CharSequence) MAP.get(templateName));
            } else {
                StringWriter stringWriter = new StringWriter();
//                stringWriter.append((CharSequence) MAP.get(templateName));

                templateDirectiveBody.render(stringWriter);

                String rendered = stringWriter.toString();

                MAP.put(templateName, rendered);


                environment.getOut().append(rendered);
            }


            System.out.println("dir");
        }
    }

}
