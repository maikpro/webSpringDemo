console.log("validierung eingebunden!");

var form = document.getElementById("validateForm");
var button = document.getElementById("validateButton");
var artikelnameInput = document.getElementById("name");
var artikelbeschreibungInput = document.getElementById("beschreibung");
var artikelPreisInput = document.getElementById("preis");

button.addEventListener("click", function(e){
    console.log("button clicked!");
    e.preventDefault(); //Seite nicht aktualisieren nach submit!

    checkForm();
} );

//Artikel: Name, Beschreibung, Preis validieren
function checkForm(){
    if( textValidate(artikelnameInput.value) ){
        if( textValidate(artikelbeschreibungInput.value) ){
            if( preisValidate(artikelPreisInput.value) ){
                form.submit();
            } 
        } else{
            alert("Überprüfe die Eingabe vomm ArtikelBeschreibung");
        }
    } else{
        alert("Überprüfe die Eingabe vomm ArtikelName");
    }
}

//
function textValidate(textFromInput){
    if( textFromInput === '' || textFromInput === null || textFromInput.length < 5){
        return false;
    } else{
        return true;
    }
}

function preisValidate(preisFromInput){
    if( preisFromInput === '' || preisFromInput === null){
        return false;
    } else if( preisFromInput.includes(",")  ){
        alert("Anstatt Komma , bitte . verwenden für den Preis! (20.00)");
        return false;
    } else{
        return true;
    }
}