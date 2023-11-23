package com.fatec.scel.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Livro {
	String isbn;
	String tiluo;
	String autor;
	int edicao;
	String ano;
	Logger logger = LogManager.getLogger(this.getClass());

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTiluo() {
		return tiluo;
	}

	public void setTiluo(String tiluo) {
		this.tiluo = tiluo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public boolean ano_da_publicacao_menor_ou_igual_ao_ano_atual(String anoPublicacao) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY");
		DateTime dt1 = fmt.parseDateTime(anoPublicacao);
		dt1.getYear();//é possivel obter o ano direto da data.
		if (dt1.isBeforeNow() || dt1.isEqualNow()) {
			logger.info(">>>>>> ano da publicacao valido");
			return true;
		}
		return false;
	}

	public boolean verificaAnoPublicacao(String anoPublicacao) {
		try {
			String dataPublicacao = "01/01/" + anoPublicacao;
			DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
			DateTime dtPublicacao = formatter.parseDateTime(dataPublicacao);
			DateTime dtAtual = new DateTime();
			System.out.println("anos => " +   Years.yearsBetween(dtAtual, dtPublicacao).getYears());
			Days d = Days.daysBetween(dtAtual, dtPublicacao);
			if (d.getDays() >= 0) {
				logger.info(">>>>>> dataVencMaiorDataAtual => true ");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.info(">>>>>> metodo dtVencMaiorDtAtual() retornou erro nao esperado =>" + e.getMessage());
			throw new IllegalArgumentException("Data invalida");
		}
	}

}
