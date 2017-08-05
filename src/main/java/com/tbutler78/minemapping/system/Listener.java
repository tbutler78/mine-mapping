package com.tbutler78.minemapping.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
class Listener implements ApplicationListener<ContextRefreshedEvent> {

  private static final CompletableFuture<ContextRefreshedEvent> promise = new CompletableFuture<>();

  public static CompletableFuture<ContextRefreshedEvent> initialization() {
    return promise;
  }

  public Object postProcessBeforeInitialization(Object bean) throws BeansException {
    return bean;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    promise.complete(event);
  }

}
