@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}

@Bean
public IClientConfig ribbonClientConfig() {
    return new DefaultClientConfig();
}

@Bean
@LoadBalanced
public RestTemplate loadBalancedRestTemplate(IClientConfig ribbonClientConfig) {
    RestTemplate template = new RestTemplate();
    template.setInterceptors(Collections.singletonList(new RibbonClientHttpRequestInterceptor(ribbonClientConfig)));
    return template;
}