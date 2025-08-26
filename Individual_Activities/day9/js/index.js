function getContent(fromContent) {
    var content = document.getElementById('dynamic-content');

    if (fromContent == "HOME") {
        console.log('hello')
        content.innerHTML = `
        <div class="new-content">
            <blockquote> “It is good to love many things, for therein lies the true strength, and whosoever loves much performs much, and can accomplish much, and what is done in love is well done.”
            ― Vincent Van Gogh</blockquote>
        </div>
        `;

    }
    else if (fromContent == "ABOUT") {
        content.innerHTML = `
        <div class="new-content">
            <div id="about">
                <p>Education</p>
                <ul>
                    <li>PUP</li>
                    <li>MHPNHS</li>
                </ul>
            </div>
        </div>
        `;
    }
    else {
        content.innerHTML = `
        <div class="new-content">
            <p>${fromContent}</p>
        </div>
        `;
    }
}