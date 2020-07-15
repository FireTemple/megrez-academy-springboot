package com.bohan.shiro;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {



    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);


        HashMap<String, String> filter = new HashMap<>();
        /**
         * anon:无需认证
         * authc: 必须认证
         * user: 必须拥有记住我
         * perms: 必须有某个资源的quanxian
         * role: 必须有角色
         */
        filter.put("/user/*","authc");
        filter.put("/test/**","authc");
        filter.put("/index/**","anon");

        filter.put("/swagger/**", "anon");
        filter.put("/v2/api-docs", "anon");
        filter.put("/swagger-ui.html", "anon");
        filter.put("/swagger-resources/**", "anon");


        factoryBean.setLoginUrl("/index/login");
        factoryBean.setFilterChainDefinitionMap(filter);


        return factoryBean;

    }


    @Bean(name = "manager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }


    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
