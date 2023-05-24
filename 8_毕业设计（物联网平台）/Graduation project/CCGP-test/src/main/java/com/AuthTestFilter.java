//package gw.Filter;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import io.netty.util.internal.StringUtil;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.io.UnsupportedEncodingException;
//import java.nio.charset.StandardCharsets;
//
//
//@Component
//public class AuthTestFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest serverHttpRequest = exchange.getRequest();
//        String method = serverHttpRequest.getMethodValue();
//        String contentType = serverHttpRequest.getHeaders().getFirst("Content-Type");
//        if (StringUtil.isNullOrEmpty(contentType)){
//            contentType = "DEFAULT";
//        }
//        if(method.equals("POST")||contentType.startsWith("multipart/form-data")){
//            return DataBufferUtils.join(exchange.getRequest().getBody())
//                    .flatMap(dataBuffer -> {
//                        byte[] bytes = new byte[dataBuffer.readableByteCount()];
//                        dataBuffer.read(bytes);
//                        try {
//                            String bodyString = new String(bytes, "utf-8");
//                            JSONObject json = JSON.parseObject(bodyString);
//                            String token = json.getString("token");
//                            if(authCheck(token)){
//                                exchange.getAttributes().put("POST_BODY",bodyString);
//                            }else {
//                                ServerHttpResponse response = exchange.getResponse();
//                                JSONObject responseBody = new JSONObject();
//                                responseBody.put("msg","鉴权失败");
//                                byte[] bits = responseBody.toJSONString().getBytes(StandardCharsets.UTF_8);
//                                DataBuffer buffer2 = response.bufferFactory().wrap(bits);
//                                response.setStatusCode(HttpStatus.UNAUTHORIZED);
//                                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//                                return response.writeWith(Mono.just(buffer2));
//                            }
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
//                        DataBufferUtils.release(dataBuffer);
//                        Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
//                            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
//                            return Mono.just(buffer);
//                        });
//                        ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(
//                                exchange.getRequest()) {
//                            @Override
//                            public Flux<DataBuffer> getBody() {
//                                return cachedFlux;
//                            }
//                        };
//                        return chain.filter(exchange.mutate().request(mutatedRequest).build());
//                    });
//        }else if(method.equals("GET")){
//            String token = serverHttpRequest.getQueryParams().getFirst("token");
//            if(authCheck(token)){
//                return chain.filter(exchange);
//            }else {
//                ServerHttpResponse response = exchange.getResponse();
//                JSONObject responseBody = new JSONObject();
//                responseBody.put("msg","鉴权失败");
//                byte[] bits = responseBody.toJSONString().getBytes(StandardCharsets.UTF_8);
//                DataBuffer buffer2 = response.bufferFactory().wrap(bits);
//                response.setStatusCode(HttpStatus.UNAUTHORIZED);
//                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//                return response.writeWith(Mono.just(buffer2));
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//
//    public boolean authCheck(String token){
//        if(token.equals("qwe")){
//            return true;
//        }else {
//            return false;
//        }
//    }
//}
