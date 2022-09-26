package ea.project.gatewayservice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import ea.project.gatewayservice.JwtRequest;
import ea.project.gatewayservice.JwtResponse;
import ea.project.gatewayservice.client.AuthClient;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecurityFilter implements Filter {

    private final AuthClient authClient;
    private final ObjectMapper objectMapper;

    public SecurityFilter(AuthClient authClient, ObjectMapper objectMapper) {
        this.authClient = authClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        if(req.getRequestURI().equals("/auth")){
            JwtRequest jwtRequest = new JwtRequest(req.getHeader("username"), req.getHeader("password"));
            try {
                ResponseEntity<?> authenticate = authClient.authenticate(jwtRequest);
                res.setStatus(HttpStatus.OK.value());
                res.setContentType(MediaType.APPLICATION_JSON_VALUE);
                objectMapper.writeValue(res.getWriter(), authenticate.getBody());
            } catch (FeignException exception) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("message", "Invalid username/password");

                res.setStatus(HttpStatus.FORBIDDEN.value());
                res.setContentType(MediaType.APPLICATION_JSON_VALUE);

                objectMapper.writeValue(res.getWriter(), errorDetails);
            }
        }

        if (req.getHeader("Authorization")!=null){
            System.out.println("req.getHeader(\"Authorization\") = " + req.getHeader("Authorization"));
            try {
//                JwtResponse jwt = new JwtResponse(req.getHeader("Authorization"));
                authClient.validateToken(req.getHeader("Authorization"));
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (FeignException exception) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("message", "Invalid token");

                res.setStatus(HttpStatus.UNAUTHORIZED.value());
                res.setContentType(MediaType.APPLICATION_JSON_VALUE);

                objectMapper.writeValue(res.getWriter(), errorDetails);
            }
        }else{
            Map<String, Object> errorDetails = new HashMap<>();
            errorDetails.put("message", "Token in header was not found");

            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);

            objectMapper.writeValue(res.getWriter(), errorDetails);
        }
    }
}
