package com.zhenming.demo.spring.feature.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhenming
 * @date 2025/5/14 10:58
 */
public class TestSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        if (importingClassMetadata.hasAnnotation(EnableTest.class.getName())) {
            AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                    importingClassMetadata.getAnnotationAttributes(EnableTest.class.getName()));
            if (attributes != null) {
                return new String[]{attributes.getClass("value").getName()};
            } else {
                return new String[0];
            }
        } else {
            return new String[0];
        }
    }
}
