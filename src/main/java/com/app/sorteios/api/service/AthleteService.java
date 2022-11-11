package com.app.sorteios.api.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class AthleteService implements ApplicationContextAware, DisposableBean {

	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
	}

}
