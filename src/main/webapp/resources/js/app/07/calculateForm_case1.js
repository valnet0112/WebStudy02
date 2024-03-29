/**
 * 
 */
/*
1. DOM(body를 포함) 트리 구조가 완성된 이후 실행되는 코드 : DOMContentLoaded
2. calForm submit 이벤트 중단
3. 비동기 요청 전송
	line : action, method
	header : accept, content-type
	body : form's inputs, (parameter: queryString)
*/
// case1 : 파라미터 전송, HTML 수신	
document.addEventListener("DOMContentLoaded", ()=>{
	calForm.addEventListener("submit", (event)=>{
		event.preventDefault();
		let form = event.target;
		let url = form.action;
		let method = form.method;
		let contentType = form.enctype;
		let accept = "text/html";
		let formData = new FormData(form);
		let urlSearchParams = new URLSearchParams(formData);
		
		let fetchPromise = fetch(url, {
			method : method, 
			headers : {
				"Content-Type" : contentType,
				"Accept" : accept
			}, body : urlSearchParams
		});
		fetchPromise.then(resp=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`상태코드 : ${resp.status} 발생`, {cause:resp});
			}
		}).then(text=>{
			resultArea.innerHTML = text;
		}).catch(err=>{
			console.log(err.message);
			if(err.cause){
				let resp = err.cause;
				resp.text().then(ep=>resultArea.innerHTML=ep);				 
			}
		});
		return false;
	});
});





