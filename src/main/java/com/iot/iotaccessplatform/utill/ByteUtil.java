package com.iot.iotaccessplatform.utill;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 16:53
 * @Version 1.0
 **/
public class ByteUtil {

    /**
     * 字节数组转换为16进制字符串
     *
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return "";
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv).append(" ");
        }
        return stringBuilder.toString().toUpperCase();
    }

}
