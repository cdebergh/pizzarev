if (typeof(globals)=='undefined')
	globals = {};

var html5Tool = {
	getGeoLocation: function(callback,errorCallback){
		if (this.isGeoSupported){
			return(navigator.geolocation.getCurrentPosition(callback,errorCallback));
		};
	},
	isGeoSupported: function(){
		var supported = (typeof(navigator.geolocation)=='undefined') ? false : true;
		return(supported);
	}	
};


function loadScript(scriptname) {
  var script = document.createElement('script');
  script.type = 'text/javascript';
  script.src = scriptname;
  document.body.appendChild(script);
}

$.ajaxSetup({
	  contentType: "application/json",
	  dataType: 'json',
	  processData: false
	});

$.ajaxPrefilter( function( options, originalOptions, jqXHR ) {
		options.data=JSON.stringify(options.data);
});