const mydata = document.getElementById("data");
const titleSal = mydata.dataset.title;
const textSal = mydata.dataset.text;
const icon = mydata.dataset.icon;
const button = mydata.dataset.button;
const res = mydata.dataset.res;

function notificacion() {
	swal({
	  title: titleSal,
	  text: textSal,
	  icon: icon,
	  button: button,
	}).then((ok)=>{
		if(ok){
			location.href=res;
		}
	});
}

notificacion();
