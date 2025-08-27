let nameElement = document.getElementById("name");
let hoverTimer;

// Start 5-second timer
nameElement.addEventListener("mouseenter", () => {
    countTimer();
});

// reset background when mouse leaves
nameElement.addEventListener("mouseleave", () => {
    reset()
});

function countTimer(){
    hoverTimer = setTimeout(() => {
        nameElement.style.backgroundColor = "#cabd09";
    }, 5000);
}

function reset(){
    clearTimeout(hoverTimer);
    nameElement.style.backgroundColor = "";
}