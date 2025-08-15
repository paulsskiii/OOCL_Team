var modeButton = document.getElementById('modeButton');
if(modeButton){
modeButton.addEventListener('click', function(){
    if(document.body.classList.contains('lightMode')){
        document.body.classList.remove('lightMode');
        document.body.classList.add('nightMode');
    }else{
        document.body.classList.remove('nightMode');
        document.body.classList.add('lightMode');
    }
});
}

