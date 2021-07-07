package com.digitalinnovation.Map;

import java.util.Objects;

class Livro {
    private String nome;
    private Integer páginas;

    public Livro(String nome, Integer páginas) {
        this.nome = nome;
        this.páginas = páginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPáginas() {
        return páginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && páginas.equals(livro.páginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, páginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", páginas=" + páginas +
                '}';
    }
}
