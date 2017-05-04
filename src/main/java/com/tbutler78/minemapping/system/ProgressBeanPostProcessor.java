package com.tbutler78.minemapping.system;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;

class ProgressBeanPostProcessor implements BeanPostProcessor {

private static final Logger log = LoggerFactory.getLogger(ProgressBeanPostProcessor.class);

  @Override
  public Object postProcessBeforeInitialization(
      Object bean, String beanName
  ) throws BeansException {
    return null;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof EmbeddedServletContainerFactory) {
      return wrap((EmbeddedServletContainerFactory) bean);
    } else {
      return bean;
    }
  }

  private EmbeddedServletContainerFactory wrap(EmbeddedServletContainerFactory factory) {
    return initializers -> {
	  final EmbeddedServletContainer container = factory.getEmbeddedServletContainer(initializers);
	  /*if (factory instanceof TomcatEmbeddedServletContainerFactory) {
		((TomcatEmbeddedServletContainerFactory) factory).addContextValves(new ProgressValve());
	  }*/
	  log.info("Eagerly starting {}", container);
	  container.start();
	  return container;
	};
  }
}
