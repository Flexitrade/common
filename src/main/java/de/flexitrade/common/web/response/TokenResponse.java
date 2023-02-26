package de.flexitrade.common.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
	private String accessToken;
	private String type = "Bearer";
	private String refreshToken;
	private Long id;
	private String username;
	private String email;
	
	public TokenResponse(String accessToken, String refreshToken, Long id, String username, String email) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.id = id;
		this.username = username;
		this.email = email;
	}
}