/** validation.js
 * @author Maik Proba(Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */

console.log("validierung eingebunden!");

var form = document.getElementById("validateForm");
var button = document.getElementById("validateButton");
var artikelnameInput = document.getElementById("name");
var artikelbeschreibungInput = document.getElementById("beschreibung");
var artikelPreisInput = document.getElementById("preis");

//Wenn der Button Artikel einstellen geklickt wird:
button.addEventListener("click", function(e){
    console.log("button clicked!");
    e.preventDefault(); //Seite nicht aktualisieren nach submit!

    checkForm();
} );

//Artikel: Name, Beschreibung, Preis validieren
//Überprüfe die Form, ob sie im gewollten Format ist.
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

//Texteingaben prüfen
function textValidate(textFromInput){
    if( textFromInput === '' || textFromInput === null || textFromInput.length < 5){
        return false;
    } else{
        return true;
    }
}

//Preiseingabe prüfen, ob der Preis mit . anstatt , eingegeben wurde.
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