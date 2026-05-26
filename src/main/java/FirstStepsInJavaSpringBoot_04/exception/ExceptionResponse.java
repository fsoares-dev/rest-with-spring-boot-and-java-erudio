package FirstStepsInJavaSpringBoot_04.exception;

import java.util.Date;

//o record serve para simplificar classes que apenas armazenam valores
//aqui iremos gerar um Json formatado para tratar a exceção e usar como maneira de exibição, basicamente a mensagem que será mostrada para o usuario
public record ExceptionResponse(Date timestamp, String message, String details) {}
