package pers.god.demo.snowFlake;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.InvalidCipherTextException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Sm2DecryptDemo {

    public static void main(String[] args) throws InvalidCipherTextException, UnsupportedEncodingException {
        String encrypted = "04931d06e97a7f2161a86cc0d5d60051f051b70fa2dfbbc85e8b6052c554b2d9d334e2d447568c24797d09a5236e1acce5d98e9a8ebbfce103de372904291ee6ad3653cd1cc121cd1453a4d842e16591ac22188a53690228c098f9783b497ee4026c1b37f2061698ab1ded874356514f63970545750c930ca4350d12ffa5da20cac989c70fecc86f36fde8cce53cfdde";
        String privateKey = "00F07EBC08D36FC22C595EBA3868A8EFAD3BAC17C2C152724F708649160C100FC3";
        SM2 sm2 = SmUtil.sm2(privateKey, null);
        String decrypted = sm2.decryptStr(encrypted, KeyType.PrivateKey);
        System.out.println(decrypted);

//        https://healthcare-test.gyyyhospital.com?hjyctoken=040866caf165679bedc51606e0058b073ba7967258443a9637bb1644867eaae6f04c63fecbafabe2afe6c668e4d6392ad008d4feb008d6ae6c749b0fd363e74073a5f2f1e37d5e35eda17a0b3e900f50575d1f9a17781f0877bc2892ce542a563212aacf6d5277ac8700bcae1f85d7a9e0ba8880c5e5109c09486307ebec91279e51b0b1e1cf7c7c132df95cec0fb514476574c828c807bf4d397c118eebc40d01a8cee36050aa7f3d4723d776c09929678efa69e1d219d94195f55a41ae7669a21fde3cb8833e865f79d3c21e15d9732b695dce53e57e48b260543032249eb06ccc7ba0c10bfd58cd91153ed83fad614d20b67d85c0e210493472b365d0777b75b240041d3c1de125

        String data = "[{\"uuid\":{\"algorithm\":\"SM4\",\"destroyed\":false,\"encoded\":\"aeVS5bstCHAyZagnPPhTNQ==\",\"format\":\"RAW\",\"keyIndex\":0}},{\"encode\":\"F8EA32BA0941B23EC20B18185D23321869639A8CE2E51707FE2EC46F368363F7\"}]";
        System.out.println(URLEncoder.encode(data, "UTF-8"));

        String s = DigestUtils.md5Hex("120225197410193165");
        System.out.println(s);
    }
}
