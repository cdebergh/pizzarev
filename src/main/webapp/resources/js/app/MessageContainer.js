var MessageContainer = can.Control.extend({
	messages: new Array(),
	clearMessages: function(){
		this.messages = new Array();
	},
	hide: function(){
		this.element.removeClass('visible');
		this.element.addClass('invisible');
	},
	show: function(){
		var messages = "";
		$(this.messages).each(function(){
			var className = (this.type == 'error') ? 'error-message' : '';
			messages+='<li class="'+className+'">'+this.message+'</li>';
		});
		$(this.element).children('.container').html("<ul>"+messages+"</ul>");
		this.element.addClass('visible');
		this.element.removeClass('invisible');
	},
	append: function(msg, msgType){
		var msgElement = {
			message: msg,
			type: msgType
		};
		this.messages[this.messages.length] = msgElement;
		this.show();
	},
	message: function(msg, msgType){
		this.clearMessages();
		this.append(msg,msgType);
	},
	init: function(element){
		if (typeof(element)=='undefined'){
			console.log('Problem starting with message container');
		}
	}
});