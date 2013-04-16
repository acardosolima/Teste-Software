package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

private Carrinho carrinho;

@Before
public void criandoCarrinho() {
	carrinho = new Carrinho();
}

	@Test(expected = CarrinhoVazioExpected.class)
	public void menorZeroProdutos() throws CarrinhoVazioExpected {
		Produto menor;
		menor = carrinho.menorProduto();
		assertEquals(null, menor);
	}

	@Test
	public void menorUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto menor;
		menor = carrinho.menorProduto();
		assertEquals(livro, menor);
	}

	@Test
	public void menorVariosProdutos() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
		Produto menor;
		menor = carrinho.menorProduto();
		assertEquals(livro, menor);
	}

	@Test
	public void menorMesmoProduto() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 50.00);
		original = carrinho.menorProduto();
                assertEquals(original, copia);
	}
        
        @Test
	public void menorValorDiferente() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 49.99);
		original = carrinho.menorProduto();
                assertFalse(original.equals(copia));
	}
        
        @Test
        public void listaProduto() throws CarrinhoVazioExpected{
                Produto p1 = new Produto("DP: Provas em uma semana", 1403.00);
                carrinho.add(p1);
                Produto p2 = new Produto("DP: Provas Finais em uma semana", 1403.00);
                carrinho.add(p2);
                assertTrue(carrinho.printAll());
        }
        
	@Test
        public void pertenceVazio() throws CarrinhoVazioExpected{
                Produto p = new Produto("DP: Provas Finais em uma semana", 1403.00);
                assertFalse(carrinho.pertence(p));
        }
        
        @Test
        public void pertenceNVazio(){
                Produto p = new Produto("DP: Provas Finais em uma semana", 1403.00);
                carrinho.add(p);
                assertTrue(carrinho.pertence(p));
        }

        @Test
        public void removeNPertence(){
                Produto p = new Produto("DP: Provas Finais em uma semana", 1403.00);
                assertFalse(carrinho.remove(p));
        }
                
        @Test
        public void removePertence(){
                Produto p = new Produto("DP: Provas Finais em uma semana", 1403.00);
                carrinho.add(p);
                assertTrue(carrinho.remove(p));
        }
        
        @Test
        public void precoTotalVazio(){
                assertEquals(0, carrinho.precoTotal(),0.1);
        }
        
        @Test
        public void precoTotalNVazio(){
                Produto p1 = new Produto("DP: Provas em uma semana", 1403.00);
                carrinho.add(p1);
                Produto p2 = new Produto("DP: Provas Finais em uma semana", 1403.00);
                carrinho.add(p2);
                assertEquals(p1.getPreco()+p2.getPreco(), carrinho.precoTotal(),0.1);
        }
}
