/** warenkorb.js
 * @author Maik Proba(Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */


var warenkorbAnzahl = document.getElementById("warenkorbAnzahl");

//direkt beim Aufruf der Seite wird der aktuelle Stand des Warenkorbs aktualisiert.
aktualisiereWarenkorbImClient();

//HTTP GET REQUEST
/*Die Anzahl des Warenkorb-Zählers */
function aktualisiereWarenkorbImClient(){
    console.log("aktualisiereWarenkorbImClient wird ausgeführt...");
    var request = new XMLHttpRequest();
    request.open("GET", "/api/get/warenkorb/", true);
    request.onreadystatechange = function(){
        
        if( request.readyState == 4 ){
            if(request.status == 200 ){
                console.log(request.responseText);
                warenkorbAnzahl.innerText = request.responseText;
            } else {
                console.error('Error: ' + request.status);
            }
        } 
    }
    request.send();
}

//Im Frontend wird direkt die Anzahl des Warenkorbs erhöht.
function anzahlImWarenkorbErhoehen(){
    warenkorbAnzahl.innerText = parseInt(warenkorbAnzahl.innerText) + 1;
}

//Nach Button In den Warenkorb klick:
function artikelInWarenkorbLegen(){
    var artikelId = getArtikelId();
    setArtikelInWarenkorb(artikelId);
    anzahlImWarenkorbErhoehen();
}

//Benachrichtigung, falls erfolgreich:
function successAlertAnzeigen(){
    var successAlert = document.getElementById("warenkorbSuccessAlert");
    successAlert.style.display = "block";
    hideAlert(successAlert);
}

//Benachrichtigung, falls Fehler auftritt:
function failAlertAnzeigen(){
    var failAlert = document.getElementById("warenkorbFailAlert");
    failAlert.style.display = "block";
    hideAlert(failAlert);
}

//Benachrichtigung verstecken nach 5 Sekunden!
function hideAlert(alertBox){
    setTimeout(function(){ 
        alertBox.style.display = "none";
    }, 5000);
}

//HTTP POST REQUEST
//Der Artikel wird in den Warenkorb gelegt:
function setArtikelInWarenkorb(id){
    console.log("setArtikelInWarenkorb wird ausgeführt...");
    var request = new XMLHttpRequest();
    request.open("POST", "/api/set/warenkorb/", true);
    request.onreadystatechange = function(){        
        if( request.readyState == 4){
            if(request.status == 200){
                console.log('Response: ' + request.responseText);
                successAlertAnzeigen();
            } else {
                console.error('Error: ' + request.status);
                failAlertAnzeigen()
            }
        }
    }
    console.log("Artikel id ist: " + id)
    //Sende ID ins Backend!
    request.send(id);
}