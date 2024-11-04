package pers.god.demo.snowFlake;

import org.apache.commons.codec.digest.DigestUtils;
import pers.god.demo.password.PasswordEncoderHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author chuhao
 * @Date 2024/10/25
 * @Version 1.0.0
 */
public class DesToMd5Demo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("YGzPXzXtzAI=",
                "0+LlAUV23sqGKVdVsW/eSA==",
                "m5s7BMm8HuFGgmJ5NJQmLQ==",
                "j9APIMPrbsz2uopJpgcbEQ==",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "poogn414PrOBAXz0nTF50A==",
                "FSyqL6KueZzhxpMa1s6jCw==",
                "sLxYQSgeexzCmSJK7f+sDA==",
                "3z83LjLA+ZF7ntPyF9SdPg==",
                "poogn414PrOBAXz0nTF50A==",
                "rfUK9jDxCPwg7BWDT2jbfw==",
                "dT/JEcF1iUbhxpMa1s6jCw==",
                "HWCBpj9rHXLhxpMa1s6jCw==",
                "5mokbOQhXIr2uopJpgcbEQ==",
                "cp2xslp9toH2uopJpgcbEQ==",
                "1sOGxigGLZR9Le7fOU57eA==",
                "pOw9mjHAz7nhxpMa1s6jCw==",
                "yMFGwKQFzznhxpMa1s6jCw==",
                "vhe3Bed4R73hxpMa1s6jCw==",
                "oiCjHKW4z3thhUV+VUIDvg==",
                "poogn414PrOBAXz0nTF50A==",
                "poogn414PrOBAXz0nTF50A==",
                "u7+R8gl/upSstz40RnPKjw==",
                "pJHY58kyYdqstz40RnPKjw==",
                "7FhbyaHOLAmstz40RnPKjw==",
                "Dr09oriUY17n+8C43qBJ1A==",
                "1z9N+xF0N2rn+8C43qBJ1A==",
                "VrHUychLHkWstz40RnPKjw==",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "LvsGUTsL9uystz40RnPKjw==",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "e8uJtJZFNfaGKVdVsW/eSA==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "YGzPXzXtzAI=",
                "47cUW1JwcIrhxpMa1s6jCw==",
                "R9J0DRN5sqNhhUV+VUIDvg==",
                "WO2QFJ8LCS9hhUV+VUIDvg==",
                "poogn414PrOBAXz0nTF50A==",
                "UvetVTfw9yEg7BWDT2jbfw==",
                "YGzPXzXtzAI=",
                "06yy+lWiDhPhxpMa1s6jCw==",
                "poogn414PrOBAXz0nTF50A==",
                "poogn414PrOBAXz0nTF50A==",
                "YGzPXzXtzAI=",
                "ymLhAmZ7lMCGKVdVsW/eSA==",
                "Kzbw2eGomsLhxpMa1s6jCw==",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "83dQh+WyDWjhxpMa1s6jCw==",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "nQ0ZynXY1b3hxpMa1s6jCw==",
                "YGzPXzXtzAI=",
                "poogn414PrOBAXz0nTF50A==",
                "QkXnKtYLEKyf8nfBHsGdgA==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "MBQ8Fl2BOvf2uopJpgcbEQ==",
                "mf2398L7dbaGKVdVsW/eSA==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "CH8KBgYqqkle18E0lUaMIA==",
                "KJ6rX+TY2C4/zAMEA6tInA==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "FkIMkmKLRmHhxpMa1s6jCw==",
                "V+fx3qcNzENfMzeM5EUDCuHGkxrWzqML",
                "XqmRMSKEr5Sf8nfBHsGdgA==",
                "LzEoQtikWquf8nfBHsGdgA==",
                "hZ6VCDJnyPKf8nfBHsGdgA==",
                "YGzPXzXtzAI=",
                "maXIYodmQeyf8nfBHsGdgA==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "9tH9yON66WI=",
                "i+qO104q0UEg7BWDT2jbfw==",
                "KEvmeOUMwdrBsxLYxBIqPj/MAwQDq0ic",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "xdfcuEM3K2ustz40RnPKjw==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "5wi7j9wbofEBzeOgJ26jgw==",
                "B/OZGKBnh3thhUV+VUIDvg==",
                "AWX8wSXOZgJhhUV+VUIDvg==",
                "8zxSFEURQYRIRgXWcttmrQ==",
                "Hf10aluR5hG/okedWMPm4Q==",
                "YGzPXzXtzAI=",
                "kF3Jy3Y5umf2nwTefl0Pmg==",
                "ho55VtZaQK6GKVdVsW/eSA==",
                "MRoMb067+fSGKVdVsW/eSA==",
                "c83pfV3akO19Le7fOU57eA==",
                "poogn414PrOBAXz0nTF50A==",
                "YGzPXzXtzAI=",
                "YGzPXzXtzAI=",
                "/GPDBVYkiQsg7BWDT2jbfw==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "YGzPXzXtzAI=",
                "poogn414PrOBAXz0nTF50A==",
                "AJEdGftCsjBKSWKbUcPPwQ==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "OUK2UGIpJAyBAXz0nTF50A==",
                "dJrSvOzH0b4=",
                "dJrSvOzH0b4=",
                "CNY6qGLHgpupoE0gRhCh4g==",
                "pMJQE/PihY6uIKeVHaS9mg==",
                "trxjNa58lXtGgmJ5NJQmLQ==",
                "EglcVXvrsTnhxpMa1s6jCw==",
                "i9RAkyl4fyD2uopJpgcbEQ==",
                "OUK2UGIpJAyBAXz0nTF50A==");
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            String decrypted = PasswordEncoderHelper.decryptByDES(s);
            String encrypted = DigestUtils.md5Hex(decrypted);
            System.out.println("DES解密:" + decrypted + ",MD5加密:" + encrypted);
            newList.add(encrypted);
        }
        System.out.println("====================foreach====================");
        for (String s : newList) {
            System.out.println(s);
        }
    }
}
