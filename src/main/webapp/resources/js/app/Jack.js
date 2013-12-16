function drawMap() {
    var latestPosition = {
    	lat: globals.latest_position.latitude,
    	lon: globals.latest_position.longitude
    }, mapOptions = {
		    center: new google.maps.LatLng(latestPosition.lat, latestPosition.lon),
		    zoom: 13
	    };
    var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
}

var GeoModel = can.Model.extend({
  findAll: 'GET /location',
  findOne: 'GET /location/{id}',
  create:  'POST /location',
  update:  'PUT /location/{id}',
  destroy: 'DELETE /todos/{id}' 
},{});

var Jack = can.Control.extend({
	options: {
		messageContainer: null,
		googleKey: 'AIzaSyDZ6_pLKY4ahXjbvmxiirJ-O31lrWwMmhQ'
	},
	'.locator click': function(){
		if (html5Tool.isGeoSupported()){
			var _this = this;
			html5Tool.getGeoLocation(function(position){
				if (typeof position.coords != 'undefined')
					_this.submit(position.coords);
			}, function(error){
				_this.messageContainer.message(error.message,'error');
			});
		};
	},
	getAll: function(){
		GeoModel.findAll({},function(geoLocations){
			$('.geo-detail').remove();
			$('.past-locations').append( can.view('resources/js/views/geotable.ejs',geoLocations) );
			$('.date-transform').each(function(){
				var dateString = new Date($(this).data('date'));
				$(this).html( dateString.toDateString() );
			});
		});
	},
	submit: function(position){
		var _this = this;
		globals.latest_position = position;
		loadScript('https://maps.googleapis.com/maps/api/js?key=AIzaSyDZ6_pLKY4ahXjbvmxiirJ-O31lrWwMmhQ&sensor=true&callback=drawMap');
		var geoRecord = new GeoModel({
			id: null,
			latitude: position.latitude,
			longitude: position.longitude,
			createdTimestamp: null
		});
		geoRecord.save(function(){
			_this.getAll();
		});
	},
	init: function(){
		this.messageContainer = new MessageContainer('.message-container');
		this.getAll();
		
	}
});

var jack = new Jack('.wrapper');