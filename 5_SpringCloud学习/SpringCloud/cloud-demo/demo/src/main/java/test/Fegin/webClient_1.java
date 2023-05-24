package test.Fegin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;


/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/27 8:59
 * @Description webClientDemo
 */
@RestController
public class webClient_1 {
    WebClient build = WebClient.builder()
            .baseUrl("http://api.nlecloud.com/Users/Login")
            .build();

    @GetMapping("/kk/web1")
    public void test_1() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Account", "15153780254");
        map.add("Password", "zizuoduoqing");
        Mono<Map> mono = build.post()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData(map))
                .attribute("IsRememberMe", true)
                .retrieve()
                .bodyToMono(Map.class);

        System.out.println(mono);
        Map block = mono.block();
        System.out.println(block);
        Map<Object,Object> resultObj = (Map<Object, Object>) block.get("ResultObj");
        System.out.println(resultObj.get("AccessToken"));
        // 订阅（异步处理结果）
        mono.subscribe(result -> {
            System.out.println("result=========>"+result);
        });
        System.out.println("--- end ---");
    }
}
