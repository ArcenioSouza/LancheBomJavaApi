package br.com.lanchebom.models.dto.validacao;

public class ErroValidacaoDto {
    private final String campo;
    private final String mensagemErro;

    public ErroValidacaoDto(String local, String erro) {
        this.campo = local;
        this.mensagemErro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
