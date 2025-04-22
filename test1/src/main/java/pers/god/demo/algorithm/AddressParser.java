package pers.god.demo.algorithm;

import org.apache.commons.lang3.StringUtils;

public class AddressParser {

    public static void main(String[] args) {
        String address1 = "河南省新乡辉县市";
        System.out.println(address1 + ":" + getLastAddress(address1));
    }

    public static String getLastAddress(String address) {
        String lastAddress = StringUtils.EMPTY;
        if (address.contains("市")) {
            if (address.contains("县")) {
                lastAddress = address.substring(address.indexOf("市") + 1, address.indexOf("县") + 1);
            } else if (!address.contains("自治区") && address.contains("区")) {
                lastAddress = address.substring(address.indexOf("市") + 1, address.indexOf("区") + 1);
            } else {
                if (address.contains("省")) {
                    lastAddress = address.substring(address.indexOf("省") + 1, address.indexOf("市") + 1);
                } else if (address.contains("自治区")) {
                    lastAddress = address.substring(address.indexOf("区") + 1, address.indexOf("市") + 1);
                }
            }
        } else if (address.contains("自治州")) {
            if (address.contains("县")) {
                lastAddress = address.substring(address.indexOf("州") + 1, address.indexOf("县") + 1);
            }
            if (!address.contains("自治区") && address.contains("区")) {
                lastAddress = address.substring(address.indexOf("州") + 1, address.indexOf("区") + 1);
            }
        } else if (address.contains("自治区")) {
            if (address.contains("县")) {
                lastAddress = address.substring(address.indexOf("区") + 1, address.indexOf("县") + 1);
            }
            if (!address.contains("自治区") && address.contains("区")) {
                lastAddress = address.substring(address.indexOf("区") + 1, address.indexOf("区") + 1);
            }
        } else if (address.contains("省")) {
            if (!address.contains("自治区") && address.contains("县")) {
                lastAddress = address.substring(address.indexOf("省") + 1, address.indexOf("县") + 1);
            }
            if (address.contains("区")) {
                lastAddress = address.substring(address.indexOf("省") + 1, address.indexOf("区") + 1);
            }
        }
        return lastAddress;
    }
}