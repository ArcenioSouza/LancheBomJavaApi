package br.com.lanchebom.models.dto.validacao;

public class NotFoundValidacaoDto {
    private final String mensagemErro;

    public NotFoundValidacaoDto(String erro) {
        this.mensagemErro = erro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
