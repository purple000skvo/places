package com.localsearch.places.repo.externalapi;

import com.localsearch.places.exception.NotFoundException;
import com.localsearch.places.exception.RepoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
@Slf4j
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {

        return (httpResponse.getStatusCode().series() == CLIENT_ERROR
                || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {

        if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR ||
                httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                String msg = "External Api returned (404 - NOT FOUND) for given id";
                log.error(msg, httpResponse);
                throw new NotFoundException(msg);
            } else {
                String msg = String.format("External Api returned (%s - %s) while trying to retrieve place", httpResponse.getStatusCode().value(), httpResponse.getStatusText());
                log.error(msg, httpResponse);
                throw new RepoException(msg);
            }
        }
    }
}