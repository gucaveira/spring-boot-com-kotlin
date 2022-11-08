package br.com.gustavo.curso.spring.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}