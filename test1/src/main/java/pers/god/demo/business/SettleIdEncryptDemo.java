package pers.god.demo.business;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;

import java.io.UnsupportedEncodingException;

public class SettleIdEncryptDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SM2 sm2 = SmUtil.sm2(null, "04c502803578aac80608c69c8fc84765d756b1bc9cdccb88b0e48a6fdce486cc1a01ea09c7a59cb1cb16ef527d988d6ae87a3017ca8a537a2e048ed3ce098ef41b");
        System.out.println(sm2.encryptHex("41270219950109654X", KeyType.PublicKey));
    }
}
