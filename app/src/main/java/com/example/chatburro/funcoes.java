package com.example.chatburro;

import android.content.SharedPreferences;

public class funcoes {

    protected static String recuperarDados(SharedPreferences sharePref, String key) {
        return sharePref.getString(key, "Não exite valor para a chave");
    }

    protected static void salvarDados(SharedPreferences sharePref, String key, String mensagem) {
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString(key, mensagem);
        editor.apply();
    }
}
