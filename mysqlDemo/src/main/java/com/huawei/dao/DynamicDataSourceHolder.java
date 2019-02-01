package com.huawei.dao;

/**
 * 获取当前线程的数据源的
 * 
 * @author  pWX535751
 * @version  [版本号, 2019年2月1日]
 * @since  [云服务/模块版本]
 */
public class DynamicDataSourceHolder {
    
    private static ThreadLocal<String> holder = new ThreadLocal<>();
    
    public static String getDataSourceStr() {
        return holder.get();
    }
    
    public static void setDataSourceStr(String dataSourceStr) {
        holder.set(dataSourceStr);
    } 
    
    public static void clearDataSourceStr() {
        holder.remove();
    }
}
