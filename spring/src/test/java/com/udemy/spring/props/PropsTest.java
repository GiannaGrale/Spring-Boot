package com.udemy.spring.props;

import com.udemy.spring.SpringBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropsTest extends SpringBaseTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void  propsTest() throws IOException {
       Properties properties = PropertiesLoaderUtils
                .loadProperties(resourceLoader.getResource("data/my.properties"));
        System.out.println(properties);
    }
}
