package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<Produto> produtos;

	public Carrinho() {
		produtos = new ArrayList<>();
	}

	public void add(Produto produto) {
		produtos.add(produto);
	}
  
        public boolean printAll(){
                int i = 0;
                for(Produto p:produtos){
                    i++;
                    System.out.println(p.getNome());
                }
                return i == produtos.size();
        }

	public Produto menorProduto() throws CarrinhoVazioExpected {
		if (produtos.isEmpty())
			throw new CarrinhoVazioExpected();
		Produto menor = produtos.get(0);
		for (Produto produto : produtos) {
			if (produto.getPreco() < menor.getPreco())
				menor = produto;
		}
		return menor;
	}
        
        public boolean pertence(Produto proc){
            if(produtos.isEmpty())
                    return false;
            for(Produto p:produtos){
                if(p.equals(proc))
                    return true;
            }       
            return false;
        }
        
        public boolean remove(Produto proc){
            if(this.pertence(proc)){
                produtos.remove(proc);
                return true;
            }
            return false;
        }
        
        public double precoTotal(){
            double soma=0;
            for(Produto p:produtos)
                soma += p.getPreco();
           return soma;           
        }

}
