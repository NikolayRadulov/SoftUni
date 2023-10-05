package org.softuni.exam.structures;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.softuni.exam.entities.Deliverer;
import org.softuni.exam.entities.Package;

public class DeliveriesManagerImpl implements DeliveriesManager {
	

	private final Map<Deliverer, Set<Package>> deliverers;
	private final Set<Package> allPackages;
	private final Set<Package> unassaignedPackages;
	
    public DeliveriesManagerImpl() {
		this.deliverers = new LinkedHashMap<>();
		this.allPackages = new LinkedHashSet<>();
		this.unassaignedPackages = new LinkedHashSet<>();
	}

	@Override
    public void addDeliverer(Deliverer deliverer) {
        deliverers.put(deliverer, new HashSet<>());
    }

    @Override
    public void addPackage(Package _package) {  	
    	allPackages.add(_package);
    	unassaignedPackages.add(_package);
    }

    @Override
    public boolean contains(Deliverer deliverer) {
        return deliverers.containsKey(deliverer);
    }

    @Override
    public boolean contains(Package _package) {
        return allPackages.contains(_package);
    }

    @Override
    public Iterable<Deliverer> getDeliverers() {
        return deliverers.keySet();
    }

    @Override
    public Iterable<Package> getPackages() {
        return allPackages;
    }

    @Override
    public void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException {
    	if(!deliverers.containsKey(deliverer) || !unassaignedPackages.contains(_package)) throw new IllegalArgumentException();
    	
    	deliverers.get(deliverer).add(_package);
    	unassaignedPackages.remove(_package);
    }

    @Override
    public Iterable<Package> getUnassignedPackages() {
        return unassaignedPackages;
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        return allPackages.stream().sorted(Comparator.comparing(Package::getReceiver)).sorted(Comparator.comparing(Package::getWeight).reversed()).collect(Collectors.toList());
    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {
        return deliverers.keySet().
        		stream()
        		.sorted(Comparator.comparing(Deliverer::getName))
        		.sorted(Comparator.comparing(d->deliverers.get(d).size()).reversed()).collect(Collectors.toList());
    }
}
