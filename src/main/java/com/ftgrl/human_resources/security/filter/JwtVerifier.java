package com.ftgrl.human_resources.security.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.base.Strings;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtVerifier extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
String token = request.getHeader("Authorization");
		
		if (token != null && token.startsWith("Bearer ")) {
			token = token.replace("Bearer ", "");
			
			String key = "secretsecretsecretsecretsecretsecretsecretsecretsecret";
			try {
				
				Jws<Claims> claimsJws = Jwts.parser()
						.setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
						.parseClaimsJws(token);
				
				Claims body = claimsJws.getBody();
				String email = body.getSubject();
				List<Map<String, String>> authorities = (List<Map<String, String>>) body.get("authorities");
				
				Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
						.map(a -> new SimpleGrantedAuthority("ROLE_" + a.get("authority")))
						.collect(Collectors.toSet());
				
				Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, simpleGrantedAuthorities);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				
			} catch (JwtException e) {
				throw new IllegalStateException("Token can't be trusted");
			}
			
			filterChain.doFilter(request, response);
			
		} else {
			filterChain.doFilter(request, response);
			return;
		}
	}

	
}
