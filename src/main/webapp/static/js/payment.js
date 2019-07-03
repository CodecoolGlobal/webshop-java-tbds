let paypalButton = document.getElementById("paypalButton");
let creditcardButton = document.getElementById("creditcardButton");

paypalButton.addEventListener("click", loadPayPal);
creditcardButton.addEventListener("click",loadCreditCard);

function loadTemplate(index) {
    let temp = document.getElementsByTagName("template")[index];
    let clone = temp.content.cloneNode(true);
    document.getElementById("payMethod").appendChild(clone);
}

function clearBox() {
    document.getElementById("payMethod").innerHTML = "";
}

function loadPayPal() {
    clearBox();
    loadTemplate(0); // todo: fix magic constant issue
}

function loadCreditCard() {
    clearBox();
    loadTemplate(1);  // todo: fix magic constant issue vol.2
}
