// plus minus function
function createCounter(plusElement, minusElement, numElement) {
    let a = 0;
    plusElement.addEventListener("click", () => {
        a++;
        // a = (a < 10) ? "0" + a : a;
        numElement.innerText = a;
    });

    minusElement.addEventListener("click", () => {
        if (a > 0) {
            a--;
            // a = (a < 10) ? "0" + a : a;
            numElement.innerText = a;
        }
    });
}
//Usage
const plus1 = document.querySelector(".plus1"),
    minus1 = document.querySelector(".minus1"),
    num1 = document.querySelector(".num1");
createCounter(plus1, minus1, num1);

const plus2 = document.querySelector(".plus2"),
    minus2 = document.querySelector(".minus2"),
    num2 = document.querySelector(".num2");
createCounter(plus2, minus2, num2);

const plus3 = document.querySelector(".plus3"),
    minus3 = document.querySelector(".minus3"),
    num3 = document.querySelector(".num3");
createCounter(plus3, minus3, num3);

const plus4 = document.querySelector(".plus4"),
    minus4 = document.querySelector(".minus4"),
    num4 = document.querySelector(".num4");
createCounter(plus4, minus4, num4);

const plus5 = document.querySelector(".plus5"),
    minus5 = document.querySelector(".minus5"),
    num5 = document.querySelector(".num5");
createCounter(plus5, minus5, num5);

const plus6 = document.querySelector(".plus6"),
    minus6 = document.querySelector(".minus6"),
    num6 = document.querySelector(".num6");
createCounter(plus6, minus6, num6);

const plus7 = document.querySelector(".plus7"),
    minus7 = document.querySelector(".minus7"),
    num7 = document.querySelector(".num7");
createCounter(plus7, minus7, num7);

const plus8 = document.querySelector(".plus8"),
    minus8 = document.querySelector(".minus8"),
    num8 = document.querySelector(".num8");
createCounter(plus8, minus8, num8);

const plus9 = document.querySelector(".plus9"),
    minus9 = document.querySelector(".minus9"),
    num9 = document.querySelector(".num9");
createCounter(plus9, minus9, num9);

window.onload = function(){
    let submitButton = document.getElementById("submit");
    submitButton.addEventListener('mousedown', submitEventHandling);
}

function submitEventHandling(event){
    for( let i = 1; i <= 9; i++ ){
        let spanValue = document.getElementById(`num${i}`).innerHTML;
        document.getElementById(`item_${i}`).value = spanValue;
    }
}
