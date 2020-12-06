package com.cest;

import com.cest.service.QYCestLaVie;
import com.cest.util.ApplicationUtils;
import org.junit.jupiter.api.Test;

public class BeanNameTest extends BaseTest{

    @Test
    public void testDefaultBeanName() {
//        QYCestLaVie qyCestLaVie = (QYCestLaVie)ApplicationUtils.getBean("qYCestLaVie");
//        QYCestLaVie qyCestLaVie = (QYCestLaVie)ApplicationUtils.getBean("QYCestLaVie");
        QYCestLaVie qyCestLaVie = (QYCestLaVie)ApplicationUtils.getBean(QYCestLaVie.class);
        qyCestLaVie.print();
    }
}
