package br.com.zupacademy.natalia.proposta.proposta.security;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class PropostaCriptografada {

    public static String encrypt(String documento) {
        String salt = KeyGenerators.string().generateKey();
        TextEncryptor textEncryptor = Encryptors.queryableText(documento, salt);
        return textEncryptor.encrypt(documento);
    }

}
