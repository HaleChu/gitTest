package pers.god.demo.business;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.SM2;

import java.io.File;

/**
 * @Author chuhao
 * @Date 2025/7/8
 * @Version 1.0.0
 */
public class TalentInfoSm2Demo {

    /**
     * SM2公私钥
     */
    public static final String SM2_PRIVATE_KEY_BASE64 = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgg2I6nKYA3P6zJX6FTSfz/0jvcjm8F6exHhWqy8sWZ+ygCgYIKoEcz1UBgi2hRANCAARYbvAgzccuXAxJzkkKBdAlsoExizPQMRNmooN7bY+XlSIUazJi0kIpGXe9Oe/PhTSZA1WvC5arIk75DfUpVn/g";
    public static final String SM2_PUBLIC_KEY_BASE64 = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEWG7wIM3HLlwMSc5JCgXQJbKBMYsz0DETZqKDe22Pl5UiFGsyYtJCKRl3vTnvz4U0mQNVrwuWqyJO+Q31KVZ/4A==";
    public static final SM2 DEFAULT_SM2 = SmUtil.sm2(SM2_PRIVATE_KEY_BASE64, SM2_PUBLIC_KEY_BASE64);

    public static void main(String[] args) {
        File file = new File("D:\\人才数据包20241206121621.zip");
        byte[] encrypt = DEFAULT_SM2.encrypt(FileUtil.readBytes(file));
        FileUtil.writeBytes(encrypt, "D:\\人才数据包20241206121621");
    }
}
