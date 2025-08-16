const navContainer = document.getElementById('nav-container');
const homeLink = document.getElementById('home-link');
const aboutLink = document.getElementById('about-link');
const projectsLink = document.getElementById('projects-link');
const contactLink = document.getElementById('contact-link');
const aboutText = document.getElementById('about-text');
const imageContainer = document.getElementById('image-container');
const projectTitle = document.getElementById('project-title');
const btnBox = document.getElementById('btn-box');

navContainer.addEventListener('click', () => {
    navContainer.style.backgroundColor = "red"
})

homeLink.addEventListener('mouseover', () => {
    homeLink.style.color = "white"
})

homeLink.addEventListener('mouseout', () => {
    homeLink.style.color = "black";
});

aboutLink.addEventListener('mouseover', () => {
    aboutLink.style.color = "white"
})

aboutLink.addEventListener('mouseout', () => {
    aboutLink.style.color = "black";
});

projectsLink.addEventListener('mouseover', () => {
    projectsLink.style.color = "white"
})

projectsLink.addEventListener('mouseout', () => {
    projectsLink.style.color = "black";
});

contactLink.addEventListener('mouseover', () => {
    contactLink.style.color = "white"
})

contactLink.addEventListener('mouseout', () => {
    contactLink.style.color = "black";
});

aboutText.addEventListener('mouseover', () => {
    aboutText.style.opacity = 0;
})

aboutText.addEventListener('mouseout', () => {
    aboutText.style.opacity = 1;
})

contactLink.addEventListener('click', () => {
    imageContainer.style.display = 'block';
})

projectsLink.addEventListener('click', () => {
    imageContainer.style.display = 'none';
})

projectTitle.addEventListener('click', () => {
    projectTitle.style.transform = 'rotate(10deg)';
})

projectTitle.addEventListener('mouseout', () => {
    projectTitle.style.transform = 'rotate(0deg)';
})

btnBox.addEventListener('mouseover', () => {
    btnBox.style.justifyContent = 'start';
})

btnBox.addEventListener('mouseout', () => {
    btnBox.style.justifyContent = 'between';
})

