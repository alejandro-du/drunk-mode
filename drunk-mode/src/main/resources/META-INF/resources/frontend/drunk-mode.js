window.addEventListener('click', () => {
    document.body.classList.add('drunk');
});

window.addEventListener('keydown', () => {
    document.body.classList.add('drunk');
});

document.body.addEventListener('animationend', e => {
    if (e.target === document.body) {
        document.body.classList.add('drunkerer');
    }
});
