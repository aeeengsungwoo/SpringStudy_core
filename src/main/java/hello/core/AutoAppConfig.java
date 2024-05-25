package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 컴포넌트 스캔의 디폴트 베이스 패키지는 설정정보가 있는 패키지이다.
        // 권장하는 방법으로는
        // 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것 이다.
        // 최근 스프링 부트도 이 방법을 기본으로 제공한다.
        basePackages = "hello.core",
        // exclude 한 부분은 미리 만들어둔 AppConfig의 @Configuration을 컴포넌트 스캔 대상에서 제외하기 위함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ComponentScan.class)
)
public class AutoAppConfig {
}
