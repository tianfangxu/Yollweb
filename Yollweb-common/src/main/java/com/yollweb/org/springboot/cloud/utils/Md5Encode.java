package com.yollweb.org.springboot.cloud.utils;

import java.security.MessageDigest;

public class Md5Encode {
	/**
	 * MD5带盐加密
	 * @param source
	 * @param salt
	 * @return
	 * @throws Exception
	 */
	public static String md5WithSalt(String source,String salt) throws Exception{
		byte[] saltByte=null;
		byte[] sourceByte=null;
		if(source==null){
			return null;
		}
	    final char[] DIGITS = {
	            '0', '1', '2', '3', '4', '5', '6', '7',
	            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
	    };
		if(salt!=null){
			saltByte=salt.getBytes("UTF-8");
		}
		sourceByte=source.getBytes("UTF-8");
		MessageDigest digest = MessageDigest.getInstance("MD5");
		 if (saltByte != null) {
	            digest.reset();
	            digest.update(saltByte);
	     }
		 byte[] hashed = digest.digest(sourceByte);
		 int l = hashed.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & hashed[i]) >>> 4];
            out[j++] = DIGITS[0x0F & hashed[i]];
        }
		return new String(out);
	}
}