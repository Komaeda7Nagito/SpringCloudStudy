package com.xzzzf.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 自定义全局过滤器
 */
@Component
public class TestFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {  // 只需要实现这个方法即可

        // 比如我们拦截没有携带 Test 请求参数
        ServerHttpRequest request = exchange.getRequest();

        List<String> reqQuery = request.getQueryParams().get("Test");
        System.out.println(reqQuery);

        if (reqQuery != null && reqQuery.contains("1")) {
            // 放行
            return chain.filter(exchange);
        } else {
            // 直接返回 拦截
            return exchange.getResponse().setComplete();
        }
    }
}
