import com.ifsc.tdd_teste.Conta;

public class ContaTest {

}
/*
Construa uma classe Conta. Para tanto primeiro programe um caso de teste que deve falhar e
após programe como corrigir cada falha de teste para que o código funcione e assim
sucessivamente. Comece programando a classe ContaTest.

1) deve ser possível sacar uma determinada quantia da conta, o método retorna o valor sacado.
1.1) Essa quantia deve ser sempre positiva, do contrario exception não verificada deve ser lançada
(ContaException)
1.2) Essa quantia deve ser menor que o saldo + o limite da conta para que o saque seja possível,
caso o saque não seja possível o valor retornado será 0.

2) deve ser possível depositar um valor positivo na conta. Será retornado o saldo final após o depósito.
2.1) Caso o valor não seja positivo, deve-se lançar uma ContaException.

3) deve ser possível alterar o limite de uma conta para um novo valor que não seja negativo.
3.1)caso valor negativo deve ser lançada uma ContaException

4) deve ser possível transferir uma determinada quantidade positiva da conta de um cliente para a
conta de outro cliente.
4.1) a quantidade deve ser positiva
4.2) a conta não deve ser nula
4.3) somando-se o saldo com o limite da conta de origem, não se pode obter um valor negativo
4.4) caso algum desses casos aconteça gere uma ContaException)
*/