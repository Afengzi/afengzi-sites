package com.afengzi.test;

import com.afengzi.sites.service.config.impl.CreateFileServiceImpl;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-27
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class SpringXmlParseTest {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        ClassPathResource resource = new ClassPathResource("spring-service.xml");
        reader.loadBeanDefinitions(resource);




       BeanNameGenerator beanNameGenerator = reader.getBeanNameGenerator();

        BeanDefinitionRegistry registry = reader.getRegistry();

        Environment environment = reader.getEnvironment();
        environment.getProperty("indexHtmlPath") ;

        CreateFileServiceImpl createFileService = (CreateFileServiceImpl) factory.getBean("createFileService");
        createFileService.manualCreateIndexHtml("klov");
    }
}
