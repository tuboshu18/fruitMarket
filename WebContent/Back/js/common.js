//var baseurl ="http://47.97.163.4:6054/mall/";
var baseurl ="http://localhost:8080/FruitMarket";
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	}
	return null;
}