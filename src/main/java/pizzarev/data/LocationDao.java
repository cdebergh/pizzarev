package pizzarev.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationDao {
	@Autowired
	private LocationRepository repository;
	
	public List<Location> getAllLocations() {
		List<Location> locations = new ArrayList<Location>();
		for(Location location : repository.findAll() ) {
			locations.add(location);
		}
		return locations;
	}

	public Location save(Location location) {
		if(location.getCreatedTimestamp() == null)
			location.setCreatedTimestamp( new Date() );
		return repository.save(location);
	}
}
