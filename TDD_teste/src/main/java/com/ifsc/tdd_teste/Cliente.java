package com.ifsc.tdd_teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cliente{
    private String nome, cpf;
    private LocalDate dataDeNascimento;
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //
    public Cliente(String nome, String cpf, String dataDeNascimento) throws ClienteException{
        if(!validaCpf(cpf))
            throw new ClienteException("cpf invalido.");
        this.cpf = cpf;
        if(!validaNome(nome))
            throw new ClienteException("nome não deve ter caracteres não alfabéticos.");
        this.nome = nome;
        if(validaDataDeNascimento(dataDeNascimento))
            this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatoData);
    }
    //
    private boolean validaNome(String nome){
        return nome!=null && nome.matches("[a-zA-ZÀ-ÿ\\s]+");
    }
    
    private boolean validaCpf(String cpf){
        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new ClienteException("cpf deve ser no formato XXX.YYY.ZZZ-WW.");
        }
        char[] digitosCPF = cpf.replaceAll("[.-]","").toCharArray();
        // rejeita CPFs com tamanho incorreto, caracteres não numéricos ou todos iguais
        if (digitosCPF.length != 11) 
            return false;
        for (char c : digitosCPF){
            if (!Character.isDigit(c)) 
                return false;
        }
        boolean todosIguais = true;
        for (int i=1; i<digitosCPF.length; i++) {
            if (digitosCPF[i] != digitosCPF[0]) { 
                todosIguais = false; 
                break; 
            }
        }
        if (todosIguais) 
            return false;
        
        //primeiro digito verificador
        int valorTotal=0;
        for(int i=0, multiplicador=10; i<9; i++, multiplicador--){//1º digito X 10, 2º X 9... 9º X 2
            valorTotal += (digitosCPF[i]-'0'/*transforma de char para int*/) * multiplicador;
        }
        int primeiroDigitoVerificador = 11 - valorTotal%11;
        if (primeiroDigitoVerificador >= 10) 
            primeiroDigitoVerificador = 0;
        boolean primeiraVerificacao = primeiroDigitoVerificador == (digitosCPF[9]-'0');

        //segundo digito verificador
        valorTotal = 0;
        for(int i=0, multiplicador=11; i<10; i++, multiplicador--){//1º digito X 11, 2º X 10... 10º X 2
            valorTotal += (digitosCPF[i]-'0') * multiplicador;
        }
        int segundoDigitoVerificador = 11 - valorTotal%11;
        if (segundoDigitoVerificador >= 10) 
            segundoDigitoVerificador = 0;
        boolean segundaVerificacao = segundoDigitoVerificador == (digitosCPF[10]-'0');
        //
        return primeiraVerificacao && segundaVerificacao;
    }
    
    private boolean validaDataDeNascimento(String dataDeNascimento){
        try {
            LocalDate data = LocalDate.parse(dataDeNascimento, formatoData);
            LocalDate limiteInferior = LocalDate.of(1900, 1, 1);
            LocalDate limiteSuperior = LocalDate.now();

            if (data.isBefore(limiteInferior)) 
                throw new ClienteException("data de nascimento deve ser maior que 1900.");
            if (data.isAfter(limiteSuperior)) 
                throw new ClienteException("data de nascimento deve ser menor que a data atual.");

            return true;
        }catch(DateTimeParseException e){
            throw new ClienteException("data invalida.");
        }
    }
}
/*
1) todo cliente deve ter nome, cpf e data de nascimento
Ao se criar um cliente deve-se validar seu nome, cpf e data de nascimento com as seguintes regras:
1.1) cpf deve ser no formato XXX.YYY.ZZZ-WW.
Caso contrário uma exception não verificada do tipo ClienteException deve ser lançada – crie essa classe)
1.2) nome não deve ter caracteres não alfabéticos. 
Caso contrário uma exception não verificada do tipo ClienteException deve ser lançada)
1.3) cpf deve ser válido. 
Caso contrário uma exception não verificada do tipo ClienteException deve ser lançada)
1.4) data nascimento deve ser maior que 1900 e menor que a data atual. 
Caso contrário uma exception não verificada do tipo ClienteException deve ser lançada)
*/