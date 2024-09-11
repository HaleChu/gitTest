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
//        KeyPair pair = SecureUtil.generateKeyPair("SM2");
//        String privateKey = HexUtil.encodeHexStr(pair.getPrivate().getEncoded());
//        String publicKey = HexUtil.encodeHexStr(pair.getPublic().getEncoded());
//        System.out.println("公钥:" + publicKey);
//        System.out.println("私钥:" + privateKey);

        String publicKey = "04581EBBF44F92566D1F79C5EEFBFE7CAAFB0046185DAB5A0317AF6ECAAD3A0B88AFE7D3B37B5F3809AE86D45256855CB3054F57922EA259A80CA17F1B32F28E91";

        String data = "430725198812200334";

        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encryptHex = sm2.encryptHex(data, KeyType.PublicKey);
        System.out.println(encryptHex);
//
//
//        String data = "04835acdd117918b42f1daac51e8518b43537aa02bd7986eb0753197e42ab7304b511e01929eb9f74879a9723315c749afbddbd5982eb2bd3eb981b33825ca4cfc2a25cf916b4d912ca6b68d4bde42cbbea68cd7829789bded932fefffbb57d7c9f539b9af6be5ec1cf1908868a4cf7b827660ca2b56279faadca0433d80e6580d573a9a253f924034c761fba1fc4a4c9f7e88e4";
//        String privateKey = "00CFFDE1C46C0671DED077249B65F9AAED79AA9B89892C37897F75E7C544D20879";
//        SM2 sm2 = SmUtil.sm2(privateKey, null);
//        String decrypted = sm2.decryptStr(data, KeyType.PrivateKey);
//        System.out.println(decrypted);
//
        System.out.println(URLEncoder.encode("[{\"uuid\":{\"destroyed\":false,\"keyIndex\":0,\"format\":\"RAW\",\"algorithm\":\"SM4\",\"encoded\":\"wzzJSB/qTa2Klr2saN3VyQ==\"}},{\"encode\":\"AC5EDE31D1CAEBE90867D2600F1538F0\"},{\"b64SignedData\":\"zpZOVfw95ee2V0QgHoW7toI2va249d3KBG3zyx2/balwzlxwvqZggOmR6mxsA7atVw9runmsQIet6StOH6Kv/A==\"}]", "utf-8"));

//        String data = "2bf9232474930c17b98dee921ad5372a0098f024c648438374313304b3d869405f1763185ec42b8616891c9a7495de582cf7810182af7bdc0eab1601dc7c55601860be1c8d71e65ea548f45b434631238c4d952c7b7ada532c2ecb321da8b5ea79c9915a787da987b2fd565ec9d8c1f2e15b";
//        String privateKey = "68c75b12d868c0f7607b9792184ccce8ec4a8e4f6ce830bfa2ba3b91f75023c3";
//        String decrypt = Sm2Util.decrypt(privateKey, data, 0);
//        System.out.println(decrypt);

//        System.out.println(PasswordEncoderHelper.decryptByDES("bJIkzwSubc4="));

//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("identificationNumber", "446968199612027791");
//        map.put("timestamp", System.currentTimeMillis());
//        map.put("secretKey", "talentService");
//        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(map)).toLowerCase();
//        map.put("sign", sign);
//        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE2FSWQvXImXs5r6yWdIImedqWl53L6Bx6XZPzBYBZKH935yEhEdKoM+PpR3JpZ2LtzzTDtcpHF8Bq2+csGpPHkg==";
//        SM2 sm2 = SmUtil.sm2(null, publicKey);
//        String encrypted = sm2.encryptBase64(JSONObject.toJSONString(map), KeyType.PublicKey);
//        System.out.println(encrypted);

        System.out.println(DigestUtils.md5Hex("123456"));


    }
}
