package com.impetus.ogos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**It is handling all custom exception.
 *
 */
@ControllerAdvice
public class MainExceptionClass {

    /**It is handling the  ResourceNotFound exception.
     * @param resourceNotFound it is object of ResourceNotFound
     * @return Return the errorMessage and statusCode
     */
    @ExceptionHandler(value=ResourceNotFound.class)
    public ResponseEntity<Object> exception(ResourceNotFound resourceNotFound){
        return new ResponseEntity<>(resourceNotFound, HttpStatus.NOT_FOUND);
    }
    
    /**It is handling the  DaoException exception.
     * @param daoException it is object of DaoException
     * @return Return the errorMessage and statusCode
     */
    @ExceptionHandler(value=DaoException.class)
    public ResponseEntity<Object> exception(DaoException daoException){
    	String errorMessage=daoException.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
}
