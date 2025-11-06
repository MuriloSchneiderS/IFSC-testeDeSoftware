package com.ifsc.tdd_teste;

import java.util.Date;

public class Cliente{
    private String nome, cpf;
    private Date dataDeNascimento;
    public Cliente(String nome, String cpf, String dataDeNascimento) throws ClienteException{
        
    }
    //if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){throw new ClienteException("CPF inválido: O CPF deve estar no formato XXX.XXX.XXX-XX.");
}
/*
1) todo cliente deve ter nome, cpf e data de nascimento
Ao se criar um cliente deve-se validar seu nome, cpf e data de nascimento com as seguintes regras:
1.1) cpf deve ser no formato XXX.YYY.ZZZ-WW. Caso contrário uma exception não verificada do
tipo ClienteException deve ser lançada – crie essa classe)
1.2) nome não deve ter caracteres não alfabéticos. Caso contrário uma exception não verificada do
tipo ClienteException deve ser lançada)
1.3) cpf deve ser válido. Caso contrário uma exception não verificada do tipo ClienteException
deve ser lançada)
1.4) data nascimento deve ser maior que 1900 e menor que a data atual. Caso contrário uma
exception não verificada do tipo ClienteException deve ser lançada)
*/