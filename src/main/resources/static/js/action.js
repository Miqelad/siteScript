function showAlert() {
    var summa =document.getElementById("summa").value=summing();
    alert("Summing = "+ summa);
}
function summing() {

    var firstNumber=document.getElementById("first").value;
    var secondNumber=document.getElementById("second").value;
    var sumValue=(+firstNumber)+(+secondNumber);
    return sumValue;
}