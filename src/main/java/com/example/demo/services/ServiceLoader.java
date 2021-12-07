package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ServiceLoader {

    Logger logger = LoggerFactory.getLogger(ServiceLoader.class);
    
    @Autowired
	private ResourceLoader resourceLoader;

    @Value( "${data.path}" )
	String dataPath;

    public Resource loadData() throws Exception {
        String rootpath = new File(".").getAbsolutePath();
        String pathDemo = rootpath + "/" + dataPath + "/hello/data.example.txt";

		logger.info("pathDemo: " + pathDemo);
		return resourceLoader.getResource("file:///"+ pathDemo);
	}

    // public String readFromInputStream(InputStream inputStream)
    // throws IOException {
    //     StringBuilder resultStringBuilder = new StringBuilder();
    //     try (BufferedReader br
    //     = new BufferedReader(new InputStreamReader(inputStream))) {
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             resultStringBuilder.append(line).append("\n");
    //         }
    //     }
    //     return resultStringBuilder.toString();
    // }
}