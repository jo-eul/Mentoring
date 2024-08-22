package com.example.demo.week1.global.error.exception;

import com.example.demo.week1.global.error.ErrorCode;
import com.example.demo.week1.global.entity.ErrorResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws SecurityException, IOException{
        try {
                filterChain.doFilter(request,response);
            }
        catch (CustomException e){
            sendErrorMessage(response,e.getErrorCode());
        }
        catch (Exception e){
            logger.error(e);
            sendErrorMessage(response, ErrorCode.USER_NOT_FOUND);
        }
    }

    private void sendErrorMessage(HttpServletResponse response,ErrorCode errorCode)throws IOException{
        ErrorResponseEntity errorResponseEntity=ErrorResponseEntity.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getHttpStatus())
                .createLocalDateTime(LocalDateTime.now())
                .build();
        String errorResponseJson=objectMapper.writeValueAsString(errorResponseEntity);

        response.setStatus(errorCode.getHttpStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(errorResponseJson);
    }
}
