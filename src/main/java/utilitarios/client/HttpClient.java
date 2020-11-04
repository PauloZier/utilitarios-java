package utilitarios.client;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HttpClient {

	/**
	 * Retorna a resposta como ClientResponse
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @return ClientResponse
	 */
	public ClientResponse getClientResponse(String url, MediaType mediaType) {
		
		try {
			
			WebResource resource = this.createWebResource(url);
			
			return resource.accept(mediaType).get(ClientResponse.class);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Retorna a resposta como string
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @return response to string
	 */
	public String get(String url, MediaType mediaType) {
		
		try {
			
			return this.getClientResponse(url, mediaType)
					.getEntity(String.class);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Retorna a resposta como T
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @param cls classe para conversao
	 * @return response to string
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String url, MediaType mediaType, Class<?> cls) {
		
		try {
			
			return (T)this.getClientResponse(url, mediaType)
					.getEntity(cls);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Realiza um post e retorna ClientResponse
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @param content conteúdo em formato de string
	 * @return ClientResponse
	 */
	public ClientResponse post(String url, MediaType mediaType, String content) {
		
		try {
			
			WebResource resource = this.createWebResource(url);
			
			return resource.accept(mediaType).post(ClientResponse.class, content);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Realiza um post e retorna T
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @param content conteúdo em formato de string
	 * @param cls tipo de retorno
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public <T> T post(String url, MediaType mediaType, String content, Class<?> cls) {
		
		try {
			
			return (T)this.post(url, mediaType, content).getEntity(cls);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}

	
	/**
	 * Realiza um put e retorna T
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @param content conteúdo em formato de string
	 * @param cls tipo de retorno
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public <T> T put(String url, MediaType mediaType, String content, Class<?> cls) {
		
		try {
			
			return (T)this.put(url, mediaType, content).getEntity(cls);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Realiza um put e retorna ClientResponse
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @param content conteúdo em formato de string
	 * @return ClientResponse
	 */
	public ClientResponse put(String url, MediaType mediaType, String content) {
		
		try {
			
			WebResource resource = this.createWebResource(url);
			
			return resource.accept(mediaType).put(ClientResponse.class, content);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Realiza um delete e retorna ClientResponse
	 * 
	 * @param url endpoint
	 * @param mediaType tipo de resposta
	 * @return ClientResponse
	 */
	public ClientResponse delete(String url, MediaType mediaType) {
		
		try {
			
			WebResource resource = this.createWebResource(url);
			
			return resource.accept(mediaType).delete(ClientResponse.class);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	private WebResource createWebResource(String url) {
		
		return Client.create().resource(url);
	}
}
