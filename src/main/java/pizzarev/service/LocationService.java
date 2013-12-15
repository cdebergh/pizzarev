package pizzarev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pizzarev.data.Location;
import pizzarev.data.LocationDao;

@Controller
public class LocationService {

	@Autowired
	private LocationDao locationDao;
	
	@RequestMapping("/locations")
	@ResponseBody
	public List<Location> getAllLocations() {
		return locationDao.getAllLocations();
	}
}
