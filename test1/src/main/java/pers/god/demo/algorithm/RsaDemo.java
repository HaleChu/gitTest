package pers.god.demo.algorithm;

/**
 * @Author chuhao
 * @Date 2023/12/4
 * @Version 1.0.0
 */
public class RsaDemo {

    //Rsa 公钥
    public final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdXqjJEDQYtdTA+Ds2Z1NChwP5IBSje5o2y6+LREE6r4vTvPdU" +
            "TJku6zLiIuNqFHXSSox2fq3BUr18wnUDWhyCFAfc6JvsQ2ExueJVPhz5CdMH9yAxHEgyjE3vSmGuFAGmYDnoe0KUAPGriTMVZTWhjd1L0VE5o6S5" +
            "vblmaGMuAwIDAQAB";

    //Rsa 私钥
    public final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ1eqMkQNBi11MD4OzZnU0KHA/kgFKN7mjbLr4t" +
            "EQTqvi9O891RMmS7rMuIi42oUddJKjHZ+rcFSvXzCdQNaHIIUB9zom+xDYTG54lU+HPkJ0wf3IDEcSDKMTe9KYa4UAaZgOeh7QpQA8auJMxVlNaG" +
            "N3UvRUTmjpLm9uWZoYy4DAgMBAAECgYAim+fI2Dxs1shka/MxwsWH0wOnrUt8rLk8pc0Eds1Vp7e7qEpIitQBgo5dN0kGUlubFPQRN0jlRFoR7v4" +
            "m75FnHZY4prjlfHiZ/Qv4uesDM01hTn4IW0Si0g/iBUeivmkEJ8kAfaeFRWkUJwGRNksvzDlA2VslMu+TFZDCLp7cCQJBANfS0JvNAfvW8YgOwhl" +
            "qpeAi2Ab8xgBL6smVChoAsW0SmDwVuDh+Th+uQvQsMj958FomYnxzyci8bWpINTp5uI8CQQC6qjNFMk5gy7HSn82nCXGwj4M5oWMqGy8l8dH3xz2" +
            "oxHzxRNjzP0Y8hFXgpMR+O5xTHclCv4QsUEHcnm+NRiVNAkEAxQDMJstVWjpzsow2JNkynItxwb8ORcsGgAcpd17Wlgd5Kq9wvzCbw1NgDl4hZ8u" +
            "417FeCNfwgulsvq022S+uhQJAJcPHaal61/R9/nncNn4fpTPzvZYcJOmpCUk6TKHfpKRUDs/6AIR9pkKzySYspslSoDI3hKyQhhKasJLRSMi3RQJ" +
            "AVzlP2tr3o1yCVTJU2avBNJQTPGA7hFitr+FY5PYeKDVs3KbCKMYLHruuTt2WiabcfBB3h0VAhX4oiMVU66fuNw==";

    public static void main(String[] args) {
        //Rsa 公钥
        String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdXqjJEDQYtdTA+Ds2Z1NChwP5IBSje5o2y6+LREE6r4vTvPdU" +
                "TJku6zLiIuNqFHXSSox2fq3BUr18wnUDWhyCFAfc6JvsQ2ExueJVPhz5CdMH9yAxHEgyjE3vSmGuFAGmYDnoe0KUAPGriTMVZTWhjd1L0VE5o6S5" +
                "vblmaGMuAwIDAQAB";

        //Rsa 私钥
        String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ1eqMkQNBi11MD4OzZnU0KHA/kgFKN7mjbLr4t" +
                "EQTqvi9O891RMmS7rMuIi42oUddJKjHZ+rcFSvXzCdQNaHIIUB9zom+xDYTG54lU+HPkJ0wf3IDEcSDKMTe9KYa4UAaZgOeh7QpQA8auJMxVlNaG" +
                "N3UvRUTmjpLm9uWZoYy4DAgMBAAECgYAim+fI2Dxs1shka/MxwsWH0wOnrUt8rLk8pc0Eds1Vp7e7qEpIitQBgo5dN0kGUlubFPQRN0jlRFoR7v4" +
                "m75FnHZY4prjlfHiZ/Qv4uesDM01hTn4IW0Si0g/iBUeivmkEJ8kAfaeFRWkUJwGRNksvzDlA2VslMu+TFZDCLp7cCQJBANfS0JvNAfvW8YgOwhl" +
                "qpeAi2Ab8xgBL6smVChoAsW0SmDwVuDh+Th+uQvQsMj958FomYnxzyci8bWpINTp5uI8CQQC6qjNFMk5gy7HSn82nCXGwj4M5oWMqGy8l8dH3xz2" +
                "oxHzxRNjzP0Y8hFXgpMR+O5xTHclCv4QsUEHcnm+NRiVNAkEAxQDMJstVWjpzsow2JNkynItxwb8ORcsGgAcpd17Wlgd5Kq9wvzCbw1NgDl4hZ8u" +
                "417FeCNfwgulsvq022S+uhQJAJcPHaal61/R9/nncNn4fpTPzvZYcJOmpCUk6TKHfpKRUDs/6AIR9pkKzySYspslSoDI3hKyQhhKasJLRSMi3RQJ" +
                "AVzlP2tr3o1yCVTJU2avBNJQTPGA7hFitr+FY5PYeKDVs3KbCKMYLHruuTt2WiabcfBB3h0VAhX4oiMVU66fuNw==";

        String username = "系统管理员";
        String password = "Aa@123456";

        try {
            String encryptUsername = "YfSv+xbV3bszMUwcnBj5D29CfDNEkD6IYGYiLDIYz0+jX4XU85ho1Go5sAvmc8bwNcVHFXWyFY4cdmm5/zIbQQFImMpe6nRID4M5+SIajG6NIXinygHAwXqeL4O7T+MlZTzeNyXjCYruxxNo/oUt7EXpLxAWG1yPnG56kgFEJ1I=";
            String encryptPassword = "klrZx7PeJChB4n8zqPfKLVFZ4IBXXZnfOShBRDdUOkZtV5zy3kdQA4IzIr48WZsN3umA3q935UIb7X/5J28TkD28VP25i9Ry9Trjvn/dHYU4Pakxkav6SZ0t5omLDfOkqgAprTMKB79hbR0juwEkf0RxwazS2x9KkleMFya8R2s=";
            System.out.println(RsaUtils.decryptByPrivateKey(PRIVATE_KEY, encryptUsername));
            System.out.println(RsaUtils.decryptByPrivateKey(PRIVATE_KEY, encryptPassword));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
