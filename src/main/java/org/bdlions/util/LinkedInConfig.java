/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.util;

import java.io.IOException;

/**
 *
 * @author nazmul hasan
 */
public class LinkedInConfig extends PropertyProvider{
    private static LinkedInConfig instance;
    public static final String SHARE_URL            = "SHARE_URL";
    public static final String SHARE_HTML_LINK      = "SHARE_HTML_LINK";    
    public static final String MINI                 = "MINI";
    public static final String TITLE                = "TITLE";
    public static final String SUMMARY              = "SUMMARY";
    public static final String SOURCE               = "SOURCE";
    
    private LinkedInConfig(String fileName) throws IOException {
        super(fileName);
    }
    
    public static LinkedInConfig getInstance(){
        try{
            if(instance == null){
                instance = new LinkedInConfig("linkedin.properties");
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return instance;
    }
    
    @Override
    public String get(String key){
        return super.get(key);
    }
}
