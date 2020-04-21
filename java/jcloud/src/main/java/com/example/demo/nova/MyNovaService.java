package com.example.demo.nova;

import java.util.Set;

import org.jclouds.openstack.nova.v2_0.domain.regionscoped.AvailabilityZone;

import com.google.common.collect.FluentIterable;

public interface MyNovaService {

	public Set<String> getConfiguredRegions();
	
	public FluentIterable<AvailabilityZone> getAvailabilityZones(String region);
}
