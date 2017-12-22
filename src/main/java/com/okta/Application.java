package com.okta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@EnableOAuth2Sso
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/customers")
    public String getCustomers() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        OAuth2Authentication userDetails = (OAuth2Authentication) principal;
        OAuth2AuthenticationDetails userOAuthDetails = (OAuth2AuthenticationDetails) userDetails.getDetails();

        return String.format("%s is logged now with sessionID: %s and token: %s",
                principal.getName(),
                userOAuthDetails.getSessionId(),
                userOAuthDetails.getTokenValue());
    }
}