import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pizzarev.data.Location;

public class LocationTest {

	private RestTemplate restTemplate;

	@Before
	public void before() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void test() {
		Location location = new Location();
		location.setLatitude(1.0D);
		location.setLongitude(1.0D);
		location = restTemplate.postForObject("http://localhost:8080/location", location, Location.class);
	}
	
//	@Test
//	public void thatOrdersCanBeAddedAndQueried() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//		RestTemplate template = new RestTemplate();
//
//		HttpEntity<String> requestEntity = new HttpEntity<String>(
//				RestDataFixture.standardOrderJSON(),headers);
//
//		ResponseEntity<Location> entity = template.postForEntity(
//				"http://localhost:8080/location",
//				requestEntity, Location.class);
//
//		String path = entity.getHeaders().getLocation().getPath();
//
//		Location order = entity.getBody();
//
//		System.out.println ("The Order ID is " + order.getKey());
//		System.out.println ("The Location is " + entity.getHeaders().getLocation());
//
//		assertEquals(2, order.getItems().size());
//	}
}
