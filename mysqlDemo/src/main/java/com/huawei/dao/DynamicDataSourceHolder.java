package com.huawei.dao;

/**
 * ��ȡ��ǰ�̵߳�����Դ��
 * 
 * @author  pWX535751
 * @version  [�汾��, 2019��2��1��]
 * @since  [�Ʒ���/ģ��汾]
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
