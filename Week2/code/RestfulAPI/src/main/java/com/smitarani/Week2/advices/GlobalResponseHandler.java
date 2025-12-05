package com.smitarani.Week2.advices;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/*
  @RestControllerAdvice is a special annotation in Spring Boot.
  It allows us to intercept and modify responses globally from all @RestController classes.
  In simple words: we can apply some common logic to all responses from our REST APIs.
*/
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    /*
      The supports() method tells Spring whether this advice should be applied
      to a particular controller method's response.
      Returning true means: "Yes, apply this for every controller response".
    */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /*
      beforeBodyWrite() is called right before Spring sends the response to the client.
      We can modify the response here, like wrapping it in a standard format.

      Parameters explained:
      - Object body: the actual response returned by your controller
      - MethodParameter returnType: metadata about the controller method
      - MediaType selectedContentType: type of response (like JSON)
      - HttpMessageConverter: the converter Spring will use to serialize the response
      - ServerHttpRequest request: incoming HTTP request details
      - ServerHttpResponse response: outgoing HTTP response details
    */
    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {

        // If the response is already wrapped in ApiResponse, just return it as it is
        if(body instanceof ApiResponse<?>) {
            return body;
        }

        // Otherwise, wrap the response in ApiResponse
        // This ensures all responses have a consistent structure with timeStamp, data, and error
        return new ApiResponse<>(body);
    }
}
