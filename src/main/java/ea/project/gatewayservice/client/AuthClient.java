package ea.project.gatewayservice.client;

import ea.project.gatewayservice.JwtRequest;
import ea.project.gatewayservice.JwtResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.HeaderParam;

@FeignClient(value = "auth-service")
public interface AuthClient {

    @RequestMapping(method = RequestMethod.POST, value = "/auth/validate")
    public boolean validateToken(@RequestHeader(name = "Authorization") String token);

    @RequestMapping(method = RequestMethod.POST, value = "/auth/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest);


}
