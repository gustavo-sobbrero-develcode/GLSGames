package br.com.GLSGames.main

import br.com.GLSGames.model.Jogo
import br.com.GLSGames.services.UseApi
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar")
    val busca = leitura.nextLine()

    val buscaApi = UseApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)
    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }

    resultado.onFailure {
        println("Retorno Inválido. Tente outro id.")
    }
        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s",true)) {
                println("Insira a descrição personalizada para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
                println("sua descrição: $descricaoPersonalizada")
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            println(meuJogo)
        }
}