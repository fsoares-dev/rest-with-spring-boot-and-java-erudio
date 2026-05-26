package FirstStepsInJavaSpringBoot_04.exception.handler;

import FirstStepsInJavaSpringBoot_04.exception.ExceptionResponse;
import FirstStepsInJavaSpringBoot_04.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice//concentra um tratamento que seria espalhado para todos os controllers, se a exception nao for especificada, cairá aqui
@RestController
public class CustomizedEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)//tratamento de exceptions genericas
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                exception.getMessage(),
                request.getDescription(false));
        return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); //erro 500
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)//tratamento de exceptions genericas
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); //erro 400
    }
}
