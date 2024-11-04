package pers.god.demo.snowFlake;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.InvalidCipherTextException;
import pers.god.demo.password.PasswordEncoderHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Sm2DecryptDemo {

    public static void main(String[] args) throws InvalidCipherTextException, UnsupportedEncodingException {
//        String encrypted = "04b2b162bef8abd18b76331e542146be2bc4224c1c17475d83396a6f10eac768a8c418df0b7888107026a8cd7ed33bb74bc62cfd87c9fc86f937794075d79c5b93e5aa75c61d596d0dc7cbfbba460b8026defe31895df844b5de72ca56fdca59240607a54c83ae8debcf3a09719eda76a32dc370c9a0cedc26729fbea4909922ec4ac5cadf1c8a8ac1c3a924d5528ef3f112244d330eab7102fb0a8afdd23f26f98a950e96be9b77663a29ee750a4466476728e64d5b7873b8c8288beceafa1bfa957454556ec9ca9c8bb754b1aa7f33791afd209cdb3585c9166810b1179f435d0f5fdd42f16c6b0ee3a64f9ce248e83d87e57c5474011b3ee8";
//        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgV8ixiZcAyipmFdCMA8PhX2/9ANtbn8smSGaBv13+TDmgCgYIKoEcz1UBgi2hRANCAAQfArJj8DYy+7g2vKiPnOyCgLc+0uxPWPh0O+6DsVXpWHa4TBfRD1KOdTLPoCKY7NSs+HHyFZNadLEtk58qmQk5";
//        SM2 sm2 = SmUtil.sm2(privateKey, null);
//        String decrypted = sm2.decryptStr(encrypted, KeyType.PrivateKey);
//        System.out.println(decrypted);

//        https://healthcare-test.gyyyhospital.com?hjyctoken=040866caf165679bedc51606e0058b073ba7967258443a9637bb1644867eaae6f04c63fecbafabe2afe6c668e4d6392ad008d4feb008d6ae6c749b0fd363e74073a5f2f1e37d5e35eda17a0b3e900f50575d1f9a17781f0877bc2892ce542a563212aacf6d5277ac8700bcae1f85d7a9e0ba8880c5e5109c09486307ebec91279e51b0b1e1cf7c7c132df95cec0fb514476574c828c807bf4d397c118eebc40d01a8cee36050aa7f3d4723d776c09929678efa69e1d219d94195f55a41ae7669a21fde3cb8833e865f79d3c21e15d9732b695dce53e57e48b260543032249eb06ccc7ba0c10bfd58cd91153ed83fad614d20b67d85c0e210493472b365d0777b75b240041d3c1de125

        String data = "[{\"uuid\":{\"destroyed\":false,\"keyIndex\":0,\"format\":\"RAW\",\"algorithm\":\"SM4\",\"encoded\":\"tnLpokruOUgNWsIVzH2xHA==\"}},{\"encode\":\"8FE2BBB948E9EACDD5D4036D02A59DC4\"},{\"b64SignedData\":\"prDujA6+DqNF0MnbaOHILozNuQMGe48zapNbU9GLx+ldIUDkQzxcpjj+QtYzwyDcYI9gFKo2wf8VJXf5U+Ol2A==\"}]";
        System.out.println(URLEncoder.encode(data, "UTF-8"));

        String s = DigestUtils.md5Hex("421102198602140515");
        System.out.println(s);

        String str = "T1w2lH0fdmmbqlftpRwqoiMiG8bMgf3N2T%2F%2F8nX1g9Q8%2BlYZnz5kv3OzsoWYgxLwR%2BVo%2F%2BPtQyp16qf0efphNBPs9eTdr8spaKYl59nHi1mVkvZpwiQIqaSv58HbbNULxB7RVzGMV1VgJT9ixUgU5BVmjNdgm1bAhedXupZmSWQ%3D";
        System.out.println(str.length());

        System.out.println(PasswordEncoderHelper.decryptByDES("YbsXngrNJ8Y="));
    }
}
