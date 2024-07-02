package com.javarush.lesson01.config;



import lombok.SneakyThrows;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

import static org.hibernate.cfg.JdbcSettings.JAKARTA_JDBC_DRIVER;

@Component // аннотация для ApplicationContext
@ToString
public class ApplicationProperties extends Properties {


    @SneakyThrows
//    public ApplicationProperties(String fileProperties) { //  for XML configuration

    public ApplicationProperties(@Value("application.properties") String fileProperties) {  // fileProperties - legacy  from XML configuration
        this.load(new FileReader(CLASSES_ROOT + "/" + fileProperties));
        try {
            String driver = this.getProperty(JAKARTA_JDBC_DRIVER);
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //any runtime
    public final static Path CLASSES_ROOT = Paths.get(URI.create(
            Objects.requireNonNull(
                    ApplicationProperties.class.getResource("/")
            ).toString()));

    //only in Tomcat (not use in tests)
    public final static Path WEB_INF = CLASSES_ROOT.getParent();
}