package com.example.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//public class InitContext implements ApplicationListener<ContextStartedEvent>
//public class InitContext implements ApplicationListener<ContextRefreshedEvent>
//public class InitContext implements ApplicationListener<ContextClosedEvent>
//public class InitContext implements ApplicationListener<ContextStoppedEvent>
//public class InitContext implements ApplicationListener<ApplicationStartedEvent>
//public class InitContext implements ApplicationListener<ApplicationEnvironmentPreparedEvent>
//public class InitContext implements ApplicationListener<ApplicationPreparedEvent>
public class InitContext implements ApplicationListener<ApplicationFailedEvent>
{
//	@Override
//	public void onApplicationEvent(ContextStartedEvent event)
//	{
//		// TODO Auto-generated method stub
//		log.info("********************** Listener" );
//		
//	}
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event)
//	{
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void onApplicationEvent(ContextStoppedEvent event)
//	{
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onApplicationEvent(ContextClosedEvent event)
//	{
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void onApplicationEvent(ApplicationStartedEvent event)
//	{
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	public void onApplicationEvent(ApplicationFailedEvent event)
	{
		// TODO Auto-generated method stub
		
	}
	
}
