package pers.god.demo.util;

import cn.hutool.core.util.HexUtil;
import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Sm2Util {

    /**
     * sm2曲线参数名称
     */
    public static final String CRYPTO_NAME_SM2 = "sm2p256v1";

    /**
     * SM2加密算法
     *
     * @param publicKey 公钥
     * @param data      待加密的数据
     * @return 密文，BC库产生的密文带由04标识符，与非BC库对接时需要去掉开头的04
     */
    public static String encrypt(String publicKey, String data) throws InvalidCipherTextException {
        // 按国密排序标准加密
        return encrypt(publicKey, data, SM2EngineExtend.CIPHERMODE_BC);
    }

    /**
     * SM2加密算法 （设置密文排列方式）
     *
     * @param publicKey  公钥
     * @param data       待加密的数据
     * @param cipherMode 密文排列方式0-C1C2C3；1-C1C3C2；
     * @return 密文，BC库产生的密文带由04标识符，与非BC库对接时需要去掉开头的04
     */
    public static String encrypt(String publicKey, String data, int cipherMode) throws InvalidCipherTextException {
        // 获取一条SM2曲线参数
        X9ECParameters sm2ECParameters = GMNamedCurves.getByName(CRYPTO_NAME_SM2);
        // 构造ECC算法参数，曲线方程、椭圆曲线G点、大整数N
        ECDomainParameters domainParameters = new ECDomainParameters(sm2ECParameters.getCurve(), sm2ECParameters.getG(), sm2ECParameters.getN());
        //提取公钥点
        ECPoint pukPoint = sm2ECParameters.getCurve().decodePoint(Hex.decode(publicKey));
        // 公钥前面的02或者03表示是压缩公钥，04表示未压缩公钥, 04的时候，可以去掉前面的04
        ECPublicKeyParameters publicKeyParameters = new ECPublicKeyParameters(pukPoint, domainParameters);

        SM2EngineExtend sm2Engine = new SM2EngineExtend();
        // 设置sm2为加密模式
        sm2Engine.init(true, cipherMode, new ParametersWithRandom(publicKeyParameters, new SecureRandom()));

        byte[] arrayOfBytes = null;
        try {
            byte[] in = data.getBytes();
            arrayOfBytes = sm2Engine.processBlock(in, 0, in.length);
        } catch (Exception e) {
            throw e;
        }
        return Hex.toHexString(arrayOfBytes);
    }

    /**
     * SM2解密算法
     *
     * @param privateKey 私钥
     * @param cipherData 密文数据
     * @return
     * @description 密文数据以04开头，传入的密文前面没有04则补上
     */
    public static String decrypt(String privateKey, String cipherData) throws InvalidCipherTextException {
        // // 按国密排序标准解密
        return decrypt(privateKey, cipherData, SM2EngineExtend.CIPHERMODE_BC);
    }

    /**
     * SM2解密算法
     *
     * @param privateKey 私钥
     * @param cipherData 密文数据
     * @param cipherMode 密文排列方式0-C1C2C3；1-C1C3C2；
     * @return
     */
    public static String decrypt(String privateKey, String cipherData, int cipherMode) throws InvalidCipherTextException {
        // 使用BC库加解密时密文以04开头，传入的密文前面没有04则补上
        if (!cipherData.startsWith("04")) {
            cipherData = "04" + cipherData;
        }
        byte[] cipherDataByte = HexUtil.decodeHex(cipherData);

        //获取一条SM2曲线参数
        X9ECParameters sm2ECParameters = GMNamedCurves.getByName(CRYPTO_NAME_SM2);
        //构造domain参数
        ECDomainParameters domainParameters = new ECDomainParameters(sm2ECParameters.getCurve(), sm2ECParameters.getG(), sm2ECParameters.getN());

        BigInteger privateKeyD = new BigInteger(privateKey, 16);
        ECPrivateKeyParameters privateKeyParameters = new ECPrivateKeyParameters(privateKeyD, domainParameters);

        SM2EngineExtend sm2Engine = new SM2EngineExtend();
        // 设置sm2为解密模式
        sm2Engine.init(false, cipherMode, privateKeyParameters);

        String result = "";
        try {
            byte[] arrayOfBytes = sm2Engine.processBlock(cipherDataByte, 0, cipherDataByte.length);
            return new String(arrayOfBytes);
        } catch (Exception e) {
            throw e;
        }
    }

}