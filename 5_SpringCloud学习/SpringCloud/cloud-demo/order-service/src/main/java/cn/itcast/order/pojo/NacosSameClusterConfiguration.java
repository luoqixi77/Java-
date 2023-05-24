package cn.itcast.order.pojo;

//这里不用写Configuration
//public class NacosSameClusterConfiguration{
//        @Bean
//        ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
//                                                                LoadBalancerClientFactory loadBalancerClientFactory) {
//            String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//
//            return new RandomLoadBalancer(loadBalancerClientFactory
//                    .getLazyProvider(name, ServiceInstanceListSupplier.class),
//                    name);
//        }
//    }
