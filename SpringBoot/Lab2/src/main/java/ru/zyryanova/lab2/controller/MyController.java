
package ru.zyryanova.lab2.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.zyryanova.lab2.model.Request;
import ru.zyryanova.lab2.model.Response;
import ru.zyryanova.lab2.service.ValidationService;
import ru.zyryanova.lab2.exception.ValidationFailedException;
import ru.zyryanova.lab2.exception.UnsupportedCodeException;

@RestController
public class MyController {

    private final ValidationService validationService;

    @Autowired
    public MyController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(
            @Valid @RequestBody Request request,
            BindingResult bindingResult) {

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        try {

            validationService.isValid(bindingResult);

            if ("123".equals(request.getUid())) {
                throw new UnsupportedCodeException(
                        "Неподдерживаемый uid: 123"
                );
            }

        } catch (ValidationFailedException e) {

            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка валидации");

            return new ResponseEntity<>(
                    response, HttpStatus.BAD_REQUEST
            );

        } catch (UnsupportedCodeException e) {

            response.setCode("failed");
            response.setErrorCode("UnsupportedCodeException");
            response.setErrorMessage(e.getMessage());

            return new ResponseEntity<>(
                    response, HttpStatus.BAD_REQUEST
            );

        } catch (Exception e) {

            response.setCode("failed");
            response.setErrorCode("UnknownException");
            response.setErrorMessage("Произошла непредвиденная ошибка");

            return new ResponseEntity<>(
                    response, HttpStatus.INTERNAL_SERVER_ERROR
            );

        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
