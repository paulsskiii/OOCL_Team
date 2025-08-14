function displaySubmit () {
    var inputName = document.getElementById ("inputName").value;
    var inputEmail = document.getElementById ("inputEmail").value;
    var inputMessage = document.getElementById ("inputMessage").value;
    alert ("Form successfully submitted. Have received:\nName: " + inputName + "\nEmail: " + inputEmail + "\nMessage: " + inputMessage);
}