const mydata = document.getElementById("data");
titleSal = mydata.dataset.title;
textSal = mydata.dataset.text;

function confirmacion() {
	swal({
	  title: titleSal,
	  text: textSal,
	  icon: "success",
	  button: "btnSal",
	}).then((ok)=>{
		if(ok){
			location.href="/listar";
		}
	});
}

confirmacion();
