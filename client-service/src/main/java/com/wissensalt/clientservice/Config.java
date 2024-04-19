package com.wissensalt.clientservice;

import brave.Tracing;
import brave.http.HttpTracing;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {
  @Bean
  public HttpTracing httpTracing(final Tracing tracing) {
    return HttpTracing
        .newBuilder(tracing)
        .build();
  }

  @Bean
  public RestClient restClient(HttpTracing httpTracing) {

    return RestClient
        .builder()
        .baseUrl("http://localhost:8081")
        .requestInterceptor(TracingClientHttpRequestInterceptor.create(httpTracing))
        .build();
  }
}
