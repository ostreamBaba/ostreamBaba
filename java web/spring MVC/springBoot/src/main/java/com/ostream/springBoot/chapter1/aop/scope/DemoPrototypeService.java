package com.ostream.springBoot.chapter1.aop.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

@Service
@Scope("prototype")
public class DemoPrototypeService {
}
