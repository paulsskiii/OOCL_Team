const button = document.getElementById('button-change-color');
const maintext = document.getElementById("main-text")

button.addEventListener('click', function onClick() {
  document.getElementById("main-text").style.color = 'salmon';
});