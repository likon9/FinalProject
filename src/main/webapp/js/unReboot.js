function my_onkeydown_handler( event ) {

    switch (event.keyCode) {
        case 116 :
            event.preventDefault();
            event.keyCode = 0;
            window.status = "F5 disabled";
            break;
        case 82 :
            event.preventDefault();
            event.keyCode = 0;
            window.status = "r disabled";
            break;
    }
}
document.addEventListener("keydown", my_onkeydown_handler);
