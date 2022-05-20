package com.jonathan.service.oauthservice.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.jonathan.service.oauthservice.dto.Usuario;
import com.jonathan.service.oauthservice.service.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {
	@Autowired
	private IUsuarioService iUsuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		Usuario usuario = iUsuarioService.findByUserName(authentication.getName());
		info.put("Nombre", usuario.getNombre());
		info.put("UserName", usuario.getUsername());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
