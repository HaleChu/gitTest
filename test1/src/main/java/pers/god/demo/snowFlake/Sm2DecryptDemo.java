package pers.god.demo.snowFlake;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import org.bouncycastle.crypto.InvalidCipherTextException;

import java.io.UnsupportedEncodingException;

public class Sm2DecryptDemo {

    public static void main(String[] args) throws InvalidCipherTextException, UnsupportedEncodingException {
//        KeyPair pair = SecureUtil.generateKeyPair("SM2");
//        String privateKey = HexUtil.encodeHexStr(pair.getPrivate().getEncoded());
//        String publicKey = HexUtil.encodeHexStr(pair.getPublic().getEncoded());
//        System.out.println("公钥:" + publicKey);
//        System.out.println("私钥:" + privateKey);
//
        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEjHhWQpAUu453d+i4zODDS+DsMLTmDgC+/SIEVZ+OzOuadWLYYBo5KPF4EqglR24cCmNmFRVbwuHs3fATS/kiIA==";
        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg7FQnTaQwDSnsoaaw6aoG6Y9O0Xf0X6lDpc6swJTv1aygCgYIKoEcz1UBgi2hRANCAASMeFZCkBS7jnd36LjM4MNL4OwwtOYOAL79IgRVn47M65p1YthgGjko8XgSqCVHbhwKY2YVFVvC4ezd8BNL+SIg";

        String data = "{\"handleTime\":1723688153738,\"phoneNumber\":\"18262513113\",\"secretKey\":\"talentService\",\"faceValue\":\"500\",\"sourceLabel\":\"XIAOXIANG\",\"sign\":\"71f85a8edfc2500a0d3b4de39c98b9d0\",\"productName\":\"251F001000003806\",\"timestamp\":1723688153742\"}";

        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);
        String encryptBase64 = sm2.encryptBase64(data, KeyType.PublicKey);
        System.out.println(encryptBase64);

        String source = sm2.decryptStr(encryptBase64, KeyType.PrivateKey);
        System.out.println(source);

//        String data = "BI+33X6F73Hh65VYQsu6FrlBGLug1J1hsFwj5u2jt9fkMG5wy7oR+dceYoDeMAXvPuQWYrYfmn8Is0sWNdoQDJFxtrNn4HZW3j0fdXwMg9gQJzEzANQZYCxTeBZ5F2HQcRbhNh0MfSY1bI3bmlABJgTc8e/iJwgDODnLH/0Uy4miw75F58vBevRfAaoT8ThyzQ7fj6JthjEcxMX5wjVdNUwKabiyVh3i88J7Q6+4ula21cJhlKwwEJYia/E6j7NGk7qPouTk4lNnvgBUNnxqweoJRVztwV163kG/6PS86t8SvaNLQm6FHnIvqMFuXi7TCdj31lWrftdth+bgUJt8yFvGKtuhGC/O/wa9FuhdS8FwearFRlOtoAVKL+SukK469ZZnYiCQVee2+ImUeRjEl9UxGfUKjrPgN95DVRPa5J6YFZuXcLk=";
//        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg7FQnTaQwDSnsoaaw6aoG6Y9O0Xf0X6lDpc6swJTv1aygCgYIKoEcz1UBgi2hRANCAASMeFZCkBS7jnd36LjM4MNL4OwwtOYOAL79IgRVn47M65p1YthgGjko8XgSqCVHbhwKY2YVFVvC4ezd8BNL+SIg";
//        SM2 sm2 = SmUtil.sm2(privateKey, null);
//        String decrypted = sm2.decryptStr(data, KeyType.PrivateKey);
//        System.out.println(decrypted);
//
//        System.out.println(URLEncoder.encode(data,"utf-8"));

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
    }
}
