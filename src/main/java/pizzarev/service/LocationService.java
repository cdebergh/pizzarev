package pizzarev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pizzarev.data.Location;
import pizzarev.data.LocationDao;

@Controller
@RequestMapping(value = "/location")
public class LocationService {

	@Autowired
	private LocationDao locationDao;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Location> getAllLocations() {
		return locationDao.getAllLocations();
	}
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Location create(
    		@RequestBody
    		Location location ) {
        return locationDao.save(location);
    }
 
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleClientErrors(Exception ex) {
        return ex.getMessage();
    }
 
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        return ex.getMessage();
    }
}
