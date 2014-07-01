// JavaScript Document
var Ajax = function(options){
	this.xhttp = null;
	this._options = {
				url: "",
			 method: "post",
		   onCreate: function(){},
		  onSuccess: function(){},
		 onComplete: function(){},
		  onFailure: function(){},
		     params:{}
		};
	 
	for(key in options ){
		this._options[key] = options[key];
	}
	var queryString;
	for(key in options.params){
		queryString += key + '=' + options.params[key] + '&';
	} 
	this.init();
	if(this.xhttp == null){
		alert('系统Ajax不支持！');
		return null ;
	}
	
	var _transport = this;
	this.xhttp.onreadystatechange= function(){_transport.onReadyStateChange.call(_transport);};
	if(this._options.method.toUpperCase() == "GET"){
		this._options.url += (this._options.url.indexOf("?") > -1 ? '&' : '?') + queryString;
	}
	 
	this.xhttp.open(this._options.method,this._options.url,true);
	this.postBody = this._options.method.toUpperCase() == "POST" ? queryString : null;
	this._options["onCreate"]();
	this.xhttp.send(this.postBody);
}
	
Ajax.prototype.init=function(){
	try{  this.xhttp = new XMLHttpRequest();}catch(e){}
	try{  this.xhttp = new ActiveObject("Microsoft.XMLHTTP");}catch(e){}
	try{  this.xhttp = new ActiveXObject('Msxml2.XMLHTTP');}catch(e){}
 
 }	
	
Ajax.prototype.onReadyStateChange=function(){
	if(this.xhttp.readyState==4 ){
		if(this.xhttp.status==200){
			//var xhttp = this.xhttp;
			this._options["onSuccess"](this);
			this._options["onComplete"](); 
		}else{
			 alert("请求失败!errorCode:"+this.xhttp.status);	
		}
	} 

}