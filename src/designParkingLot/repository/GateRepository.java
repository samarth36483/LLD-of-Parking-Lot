package designParkingLot.repository;

import java.util.HashMap;
import java.util.Map;

import designParkingLot.exception.GateNotFoundException;
import designParkingLot.models.Gate;

public class GateRepository {
	private Map<Integer, Gate> gateMap;

	public GateRepository() {
		super();
		this.gateMap = new HashMap<Integer, Gate>();
	}
	
	public Gate get(int GateId) {
		Gate gate = gateMap.get(GateId);
		if(gate == null) {
			throw new GateNotFoundException("Gate not found with id: " + GateId);
		}
		return gate;
	}
	
	public void put(Gate gate) {
		gateMap.put(gate.getId(), gate);
		System.out.println("Gate added with id: " + gate.getId());
	}
}
