
var randNumber =  Math.floor(Math.random() * 10000);
var mes = `Well you are locked out for ${randNumber} milseconds. If you refresh the time restarts`;
	
console.log(mes);
document.getElementById('message').innerHTML = mes;

setTimeout(function(){
	document.querySelector('.reset').classList.add('active');
	document.getElementById('message').classList.remove('active');
},randNumber);
document.querySelector('.reset');