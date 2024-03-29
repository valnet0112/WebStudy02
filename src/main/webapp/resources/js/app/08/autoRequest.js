/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	setInterval(()=>{
		fetch("serverTime.do", {
			headers:{
				"Accept":"application/json"
			}
		}).then(resp=>{
			return resp.json();
		}).then(jsonObj=>timeArea.innerHTML = jsonObj.now);
	}, 1000);
	
});