package dev.brunopablo.smartlocck.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import dev.brunopablo.smartlocck.client.AuthClient;
import dev.brunopablo.smartlocck.client.dto.AuthRequest;
import dev.brunopablo.smartlocck.config.AppConfig;
import dev.brunopablo.smartlocck.exception.NotAuthorizedException;

@Service
public class AuthService {

    private final String GRANT_TYPE = "client_credentials";

    private final AuthClient authClient;
    private final AppConfig appConfig;
    private static String token;
    private static LocalDateTime expiresIn;

    public AuthService(AuthClient authClient, AppConfig appConfig) {
        this.authClient = authClient;
        this.appConfig = appConfig;
    }

    public String getToken() {
        
        if (token == null) {
            var token = getNewToken();
        }else if (expiresIn.isBefore(LocalDateTime.now())) {
            
        }


        return token;
    }

    private String getNewToken() {
        
        var request = authClient.authenticate(
            new AuthRequest(
                GRANT_TYPE,
                appConfig.getId(),
                appConfig.getSecret()
            )
        );

        if (!request.getStatusCode().is2xxSuccessful()) {
            throw new NotAuthorizedException("Bad Credentials!");
        }

        token = request.getBody().acessToken();

        expiresIn = LocalDateTime.now().plusSeconds(request.getBody().expiresIn());

        return token;
    }

}