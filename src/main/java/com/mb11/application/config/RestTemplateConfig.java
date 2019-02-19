package com.mb11.application.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	private static String hostname = "rest.entitysport.com";

	private static boolean isSSLEnable = true;

	private static String context = "v2";

	public static String apiTocken = "ec471071441bb2ac538a0ff901abd249";

	private static final int CONNECT_TIMEOUT = 30000;

	// The timeout when requesting a connection from the connection manager.
	private static final int REQUEST_TIMEOUT = 30000;

	// The timeout for waiting for data
	private static final int SOCKET_TIMEOUT = 60000;

	private static final int MAX_TOTAL_CONNECTIONS = 50;
	private static final int DEFAULT_KEEP_ALIVE_TIME_MILLIS = 20 * 1000;

	@Autowired
	CloseableHttpClient httpClient;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		return restTemplate;
	}

	@Bean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setHttpClient(httpClient);
		return clientHttpRequestFactory;
	}

	@Bean
	public CloseableHttpClient httpClient() {
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(REQUEST_TIMEOUT)
				.setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();

		return HttpClients.custom().setDefaultRequestConfig(requestConfig)
				.setConnectionManager(poolingConnectionManager()).setKeepAliveStrategy(connectionKeepAliveStrategy())
				.build();
	}

	@Bean
	public PoolingHttpClientConnectionManager poolingConnectionManager() {
		SSLContextBuilder builder = new SSLContextBuilder();
		try {
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		} catch (NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}

		SSLConnectionSocketFactory sslsf = null;
		try {
			sslsf = new SSLConnectionSocketFactory(builder.build());
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();

		PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager(
				socketFactoryRegistry);
		poolingConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
		return poolingConnectionManager;
	}

	@Bean
	public ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
		return new ConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				HeaderElementIterator it = new BasicHeaderElementIterator(
						response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();

					if (value != null && param.equalsIgnoreCase("timeout")) {
						return Long.parseLong(value) * 1000;
					}
				}
				return DEFAULT_KEEP_ALIVE_TIME_MILLIS;
			}
		};
	}

	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("poolScheduler");
		scheduler.setPoolSize(10);
		return scheduler;
	}

	public static StringBuilder getBaseURL() {
		StringBuilder builder = new StringBuilder();
		if (isSSLEnable) {
			builder.append("https://");
		} else {
			builder.append("http://");
		}
		builder.append(hostname);
		builder.append("/" + context);
		return builder;

	}

}