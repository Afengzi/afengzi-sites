package com.afengzi.sites.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class Result {

    private Map<String,Object> result ;
    private boolean isSuccess=false ;
    private static final String DEFAULT_FAILED_KEY = "fail" ;
    private static final String DEFAULT_SUCCESSFUL_KEY = "success" ;

    public Result() {
        this.result = new HashMap<String, Object>();
    }

    public Result setFailedResult(Object value){
        result.put(DEFAULT_FAILED_KEY,value) ;
        return this ;
    }

    public String getFailedMessage(){
        return String.valueOf(result.get(DEFAULT_FAILED_KEY)) ;
    }

    public String getSuccessfulMessage(){
        return String.valueOf(result.get(DEFAULT_SUCCESSFUL_KEY)) ;
    }
    public Result setSuccessfulResult(Object value){
        setSuccess(true);
        result.put(DEFAULT_SUCCESSFUL_KEY,value) ;
        return this ;
    }

    public void put(String key,Object obj){
        result.put(key,obj);
    }

    public Object get(String key){
        return result.get(key);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
