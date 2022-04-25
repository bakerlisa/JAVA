function onPopup(element){
	var ele = document.querySelector('.'+element);
	
	if(ele.classList.contains('active')){
		ele.classList.remove('active');
	}else{
		ele.classList.add('active');
	}	
}

function onPopupRemove(element){
	var ele = document.querySelector('.'+element);
	
	if(ele.classList.contains('active')){
		ele.classList.remove('active');
	}else{
		ele.classList.add('active');
	}
}