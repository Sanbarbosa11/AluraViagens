package com.cursoandroid.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cursoandroid.aluraviagens.R;
import com.cursoandroid.aluraviagens.model.Pacote;
import com.cursoandroid.aluraviagens.util.MoedaUtil;

import static com.cursoandroid.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);
        carregaPacodeRecebido();

    }

    private void carregaPacodeRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}