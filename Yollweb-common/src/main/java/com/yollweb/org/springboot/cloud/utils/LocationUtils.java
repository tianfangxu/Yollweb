/**
 * 
 */
package com.yollweb.org.springboot.cloud.utils;

/**
 * @ClassNameLocationUtils
 * @Description:TODO位置工具
 * @author vpjsl
 * @date 2017年11月1日 
 * 根据两个位置的经纬度，来计算两地的距离（单位为KM） 参数为double类型 
 * long1 位置1经度
 * lat1位置1纬度 
 * long2 位置2经度 
 * lat2 位置2纬度
 */

public class LocationUtils {
	 private static final double EARTH_RADIUS = 6378.137;

	    private static double rad(double d){
	        return d * Math.PI / 180.0;
	    }

	    public static double getDistance(double long1, double lat1, double long2, double lat2) {
	        double a, b, d, sa2, sb2;
	        lat1 = rad(lat1);
	        lat2 = rad(lat2);
	        a = lat1 - lat2;
	        b = rad(long1 - long2);

	        sa2 = Math.sin(a / 2.0);
	        sb2 = Math.sin(b / 2.0);
	        d = 2   * EARTH_RADIUS
	                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
	                * Math.cos(lat2) * sb2 * sb2));
	        return d;
	    }
	    public static void main(String[] args) {
	    	System.out.println(getDistance( 121.192223,31.280077, 121.44969,31.305743 ));
		}

}
