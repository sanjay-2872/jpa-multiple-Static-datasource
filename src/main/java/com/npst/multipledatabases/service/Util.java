package com.npst.multipledatabases.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
@Service
public class Util {

    private static InputStream input = null;
    private static Properties prop = null;

    public static Properties getInstance() {
        if (prop == null) {
            prop = new Properties();
            try {
                input = new FileInputStream(new File("/home/sanjaykumar/workspace/projects/multipledatabases (1)/src/main/resources/server.properties"));
                prop.load(input);
                if (log.isDebugEnabled()) {
                    log.debug("httpConfig file is loaded succesfully");
                    System.out.println("httpConfig file is loaded succesfully");
                    input.close();
                }
            } catch (FileNotFoundException fnfExp) {
                log.error(fnfExp.getMessage(), new Exception(fnfExp));
            } catch (Exception exception) {
                log.error(exception.getMessage(), new Exception(exception));
            }
        }

        return prop;
    }

    public static String getProperty(String keyName) {
        prop = getInstance();
        String keyValue = prop.getProperty(keyName);
        if (keyValue == null || keyValue.equals("")) {
            return "";
        }
        return keyValue.trim();
    }

    public static Map<String, Boolean> checkServerstatus(String service){
        Map<String,Boolean> status = new HashMap<>();
        Socket portCheck;
        String host = getProperty(service+"_SERVER_IP");
        String[] ports = getProperty(service+"_SERVER_PORTS").split(",");
        fetchServerPortsStatus(ports, host, status);
        return status;
    }

    private static void fetchServerPortsStatus(String[] ports, String host, Map<String, Boolean> status) {
        Socket portCheck;
        for (String port : ports) {
            try {
                log.debug("Checking for - {}:{}", host, port);
                portCheck = new Socket(host, Integer.parseInt(port));
                boolean isConnected = portCheck.isConnected();
                log.info("is connected :: {},{}",port,isConnected);
                status.put(host +":"+ port,isConnected);
            }
            catch (UnknownHostException e) {
                log.error("UnknownHost Exception occurred - Cause :: {}", e.getMessage(), e);
                status.put(host +":"+ port,false);
                break;
            }
            catch (IOException e) {
                log.error("Exception occurred - Cause :: {}", e.getMessage(), e);
                status.put(host +":"+ port,false);
            }
        }
    }
}
