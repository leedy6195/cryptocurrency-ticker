package com.oxingaxin.ticker.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class HttpConfig {

    ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {

        // connectionManager
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(5);

        // httpClientBuilder -> CloseableHttpClient
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().setConnectionManager(connectionManager).build());
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(5000);
        return factory;
    }

    @Bean
    public List<HttpMessageConverter<?>> httpMessageConverters() {

        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        jsonHttpMessageConverter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/json"));
        jsonHttpMessageConverter.setPrefixJson(false);

        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringConverter.setWriteAcceptCharset(false);  // see SPR-7316
        //stringConverter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/xml"));

        ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
//        byteArrayHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.IMAGE_PNG, MediaType.IMAGE_JPEG, MediaType.IMAGE_GIF));

        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        formHttpMessageConverter.setCharset(StandardCharsets.UTF_8);

        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(stringConverter);
        converters.add(jsonHttpMessageConverter);
        converters.add(byteArrayHttpMessageConverter);
        converters.add(formHttpMessageConverter);
        return converters;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        restTemplate.setMessageConverters(httpMessageConverters());
        return restTemplate;
    }
}