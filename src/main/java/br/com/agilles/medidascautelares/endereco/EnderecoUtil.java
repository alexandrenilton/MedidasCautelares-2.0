package br.com.agilles.medidascautelares.endereco;

/**
 * Created by jille on 07/11/2016.
 */
public class EnderecoUtil {
    public static boolean validaCep(String cep) {
        if (!cep.matches("\\d{8}")) {
            return false;
        }

        return true;
    }
}
