package com.example.demo.controller.base;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.ServiceException;

//@ControllerAdvice			// extend 또는 @ControllerAdvice 사용
public class BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	/**
     *  javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     *  HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     *  주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
    	LOG.error("handleMethodArgumentNotValidException", e);
        return new ResponseEntity<>(this.makeResponseBody(request, e), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Map<String, Object>> handleBindException(HttpServletRequest request, BindException e) {
    	LOG.error("handleBindException", e);
        return new ResponseEntity<>(this.makeResponseBody(request, e), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Map<String, Object>> handleMethodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException e) {
    	LOG.error("handleMethodArgumentTypeMismatchException", e);
        return new ResponseEntity<>(this.makeResponseBody(request, e), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<Map<String, Object>> handleHttpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
    	LOG.error("handleHttpRequestMethodNotSupportedException", e);
        return new ResponseEntity<>(this.makeResponseBody(request, e), HttpStatus.METHOD_NOT_ALLOWED);
    }
    
    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Map<String, Object>> handleAccessDeniedException(HttpServletRequest request, AccessDeniedException e) {
    	LOG.error("handleAccessDeniedException", e);
        return new ResponseEntity<>(this.makeResponseBody(request, e), HttpStatus.valueOf(ErrorCode.HANDLE_ACCESS_DENIED.getStatus()));
    }
    
    /**
     * 비지니스 프로세스(@Service) 내에서 발생
     */
    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<Map<String, Object>> handleBusinessException(HttpServletRequest request, final ServiceException e) {
    	LOG.debug("ServiceException catched !");
    	return new ResponseEntity<>(this.makeResponseBody(request, e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * 의도하지 못한 익셉션 발생 
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Map<String, Object>> handleException(HttpServletRequest request, Exception e) {
    	LOG.error("handleEntityNotFoundException", e);
    	return new ResponseEntity<>(this.makeResponseBody(request, e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	private Map<String, Object> makeResponseBody(HttpServletRequest request, Exception e) {
		
		Map<String, Object> output = new HashMap<>();
		output.put("message", e.getMessage());
		if(e instanceof ServiceException) {
			output.put("code", ((ServiceException) e).getCode());
		}
		
		return output;
	}
}
