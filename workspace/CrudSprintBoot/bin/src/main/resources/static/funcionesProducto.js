const selectElement = document.getElementById("producto_nombre");

function myFunction() {
    let dat = selectElement.value;
    let options = selectElement.options;
    let optionsLen = selectElement.options.length;
    
    for(let i=0; optionsLen>i; i++){
        if(dat === options.item(i).value){
	        document.getElementById('producto_precio').value = options.item(i).dataset.prod;
	        i=optionsLen;
        }
    }
}

selectElement.addEventListener('change', (event) => {
    myFunction();
});
