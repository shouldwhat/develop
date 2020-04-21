package com.example.demo.nova;

import java.util.Set;

import org.jclouds.ContextBuilder;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.NovaApiMetadata;
import org.jclouds.openstack.nova.v2_0.domain.regionscoped.AvailabilityZone;
import org.jclouds.openstack.nova.v2_0.extensions.AvailabilityZoneApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.base.OpenStackApi;
import com.example.demo.property.OpenStackProperties;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

public class MyNovaApi extends OpenStackApi implements MyNovaService {

	private static final Logger LOG = LoggerFactory.getLogger(MyNovaApi.class);
	
	private NovaApi novaApi;
	
	public static void main(String[] args) {
		
		MyNovaApi myNovaApi = new MyNovaApi();
		
		Set<String> regions = myNovaApi.getConfiguredRegions();
		LOG.debug("--- regions = {}", regions);
		
		FluentIterable<AvailabilityZone> zones = myNovaApi.getAvailabilityZones("RegionOne");
		LOG.debug("--- zones = {}", zones.toString());
	}
	
	@Override
	protected void init() {
		
		Iterable<Module> modules = ImmutableSet.<Module>of(new SLF4JLoggingModule());

        this.novaApi = 
//        		ContextBuilder.newBuilder(OpenStackProperties.NOVA_PROVIDER)
        		ContextBuilder.newBuilder(new NovaApiMetadata())
                .endpoint("http://192.168.120.5:5000/v2.0/")
                .credentials(OpenStackProperties.IDENTITY, OpenStackProperties.PASSWORD)
                .modules(modules)
                .buildApi(NovaApi.class);
        
	}
	
	@Override
	public Set<String> getConfiguredRegions() {
		return (novaApi == null)? null : novaApi.getConfiguredRegions();
	}

	@Override
	public FluentIterable<AvailabilityZone> getAvailabilityZones(String region) {

		Optional<AvailabilityZoneApi> availabilityZoneApi = this.novaApi.getAvailabilityZoneApi(region);
		if(availabilityZoneApi.isPresent()) {
			return availabilityZoneApi.get().listAvailabilityZones();
		}
		return null;
	}
}
