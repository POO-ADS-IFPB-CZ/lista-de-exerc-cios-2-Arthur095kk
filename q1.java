1.
Usar getters e setters é considerado uma boa prática porque permite encapsular os dados e controlar o acesso e a modificação dos atributos de um objeto.
Isso ajuda a manter a segurança e integridade dos dados dentro da classe.

private double preco;

public void setPreco(double preco) {
    if (preco >= 0) {
        this.preco = preco;
    } else {
        System.out.println("Preço inválido!");
    }
}
podemos usar um setter que não permite valores negativos como esse.