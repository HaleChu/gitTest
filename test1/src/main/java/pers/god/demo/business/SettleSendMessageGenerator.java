package pers.god.demo.business;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author chuhao
 * @Date 2024/9/7
 * @Version 1.0.0
 */
public class SettleSendMessageGenerator {

    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("identificationNumber", "110103197408020913");
        map.put("timestamp", System.currentTimeMillis());
        map.put("secretKey", "talentService");
        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(map));
        map.remove("secretKey");
        map.put("sign", sign);
        String publicKey = "047698C0BA2DB2CEEB53BF7A09E44F01F95EF58CAFD2774CCF089F5345AC1E0B7B0ECDC7C076FDAD7227D4CB5C337D3D470B093C62C52FDD7F070CA5307059C86F";
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encrypted = sm2.encryptHex(JSONObject.toJSONString(map), KeyType.PublicKey);
        System.out.println(encrypted);

        SM2 sm2New = SmUtil.sm2("00DD7C8FE972D6A223D854DCFEDD264B4981D7AB443F63172948754974DBB60520", null);
        String encrypted1 = "047196b592378e207f303565b6a00e294a285b102d0831129f4f86cef4b84684d4d16fc86843a6c65389d7ea36a784ffe880a01b95fc456bd5768631f6197b3ac0515f3aca6ffd279f37ea6d26e093a03ead9038fd9ca8f63bf02d6b3b71f0acd215f6988d78493c6f0c91f7628e8caf935171f2392a2b16bc127636f7e5ecaa0f36b68d73abe76f966eaaee04c92d966f7339a2ed585a9bf7b8563e2b31f52089181d3a2f2f9bd54c77e7057bc8e2136a5330f4b4acf1c66f2107f4d42e46ee5267d58b2381ddcbd5d58654e0d14fafee960160a1e7e29f6503b092ed1ce253d1a7495a40f742efd3fbb08110b83e68b90b541fef5adebfa2da6f48de05e83c84b316be7aa42e1683e918ff465b8f07743db21be1700ac263990b05f469fde648509801dfee8b7fb6a0248f53aef49817d5a796486dab16c82873a37245b9ac20e110308fc2bff3baf0949087372f2cbffc18ccfccbf8186ee209aac32c75298bf7b90883e12a2db4d2611b568cdc5168876561bfa7c61b388e7fa2cce45b96171727a6b5881adab34b4289fed53f";
        System.out.println(sm2New.decryptStr(encrypted1, KeyType.PrivateKey));

        String encrypted2 = "04c3262ec39ea77756b0b94c65bc1a459e840b9e47c135befcb423de963db19fd669f40c45e51ead4367fa12445e6a97989739eb57b880faa67dd8ed311ebc334cf84dc5dd5c9c2025a897e7f52f1c1d8b9f3831dd2d65f22fc3037dd057efa7bee4e8d96c3c9e56ef5f619a16cea3e8efee9638ba2c0fcf1eb0b5c9f611c3916f3b505b0f953ec85e9981fa61cabd86facb335046c7a7e8ef567d52dfad47c67b6f1faf0b70f996a12123c84a1f661d69ee2cc53c55cf3ac2d6b265541159f5dcf4116107391f44194bad7638dd815dc341509778467903a35debf01b053f50932c8c72322b40fc392368f5570470e5192a843dab63be41576fde58f3c56d17d260e03b665eb32d7f32571ae3ed1029c1425e29354171c4864bcd5066f96556044b03560875a8bc3d584905aca70092dfe1e1c1feacec8a5d41c1abf6af65f5387715cb06b8f933107847cbf6a44ec7704083e61158102ead796e04e100e7c3e6cf96377b55cbcad0224cda3c0f1bc0b41c56aa34b07ae5772aeb562803be2ae6a314a27c4b0ede46777fdace2e615c92c2";
        System.out.println(sm2New.decryptStr(encrypted2, KeyType.PrivateKey));
    }
}
