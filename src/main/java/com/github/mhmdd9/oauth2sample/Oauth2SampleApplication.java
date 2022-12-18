package com.github.mhmdd9.oauth2sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Oauth2SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SampleApplication.class, args);
	}


	@Bean
	ClientRegistration clientRegistration() {
		return clientRegistrationBuilder().build();
	}

	@Bean
	ClientRegistrationRepository clientRegistrationRepository(ClientRegistration clientRegistration) {
		return new InMemoryClientRegistrationRepository(clientRegistration);
	}

	private ClientRegistration.Builder clientRegistrationBuilder() {
		Map<String, Object> metadata = new HashMap<>();
		metadata.put("end_session_endpoint", "https://jhipster.org/logout");

		return ClientRegistration
				.withRegistrationId("oidc")
				.issuerUri("{baseUrl}")
				.redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.scope("read:user")
				.authorizationUri("https://jhipster.org/login/oauth/authorize")
				.tokenUri("https://jhipster.org/login/oauth/access_token")
				.jwkSetUri("https://jhipster.org/oauth/jwk")
				.userInfoUri("https://api.jhipster.org/user")
				.providerConfigurationMetadata(metadata)
				.userNameAttributeName("id")
				.clientName("Client Name")
				.clientId("client-id")
				.clientSecret("client-secret");
	}
}
