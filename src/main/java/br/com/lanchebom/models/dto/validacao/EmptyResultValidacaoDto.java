package br.com.lanchebom.models.dto.validacao;

public class EmptyResultValidacaoDto {
    private final String mensagemErro;

    public EmptyResultValidacaoDto(String erro) {
        this.mensagemErro = erro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
