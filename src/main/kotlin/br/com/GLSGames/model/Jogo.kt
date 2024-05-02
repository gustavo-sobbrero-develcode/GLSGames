package br.com.GLSGames.model

data class Jogo(val titulo: String, val capa: String) {
    var descricao: String? = null
    override fun toString(): String {
        return "Meu br.com.GLSGames.model.Jogo:\n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n"
    }

}