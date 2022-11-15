package br.com.lanchebom.exceptions;

import br.com.lanchebom.models.dto.validacao.EmptyResultValidacaoDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmptyResultHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public EmptyResultValidacaoDto handle(EmptyResultDataAccessException exception){
        return new EmptyResultValidacaoDto("Não existe registro com esse id no banco de dados");
    }
}
