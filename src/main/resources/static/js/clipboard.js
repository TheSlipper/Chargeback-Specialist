function cpyToClipboard(elem) {
    elem.select();
    document.execCommand("copy");
}