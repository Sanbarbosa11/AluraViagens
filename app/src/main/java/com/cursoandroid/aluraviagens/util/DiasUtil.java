package com.cursoandroid.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " Dias";
    public static final String SINGULAR = " Dia";

    public static String formataEmTexto(int quatidadeDeDias) {

        if (quatidadeDeDias > 1) {
            return quatidadeDeDias + PLURAL;
        }
            return quatidadeDeDias + SINGULAR;
        }
}
