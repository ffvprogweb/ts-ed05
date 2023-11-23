package com.fatec.scel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fatec.scel.model.Livro;

class Req01CadastrarLivroTest {
	@BeforeAll

	@Test
	void ct01_quando_o_ano_publicacao_e_menor_que_o_ano_atual_deve_aceitar() {
		Livro livro = new Livro();
		assertTrue(livro.ano_da_publicacao_menor_ou_igual_ao_ano_atual("2022"));
	}

	@Test
	void ct02_quando_o_ano_publicacao_e_maior_que_o_ano_atual_deve_rejeitar() {
		Livro livro = new Livro();
		assertFalse(livro.ano_da_publicacao_menor_ou_igual_ao_ano_atual("2024"));
	}
	@Test
	void test3() {
		Livro livro = new Livro();
		assertTrue(livro.ano_da_publicacao_menor_ou_igual_ao_ano_atual("2023"));
	}
}
