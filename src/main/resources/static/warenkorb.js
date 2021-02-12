console.log("Skript eingebunden!");

var warenkorbAnzahl = document.getElementById("warenkorbAnzahl");

aktualisiereWarenkorbImClient();

//HTTP GET REQUEST
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

function anzahlImWarenkorbErhoehen(){
    warenkorbAnzahl.innerText = parseInt(warenkorbAnzahl.innerText) + 1;
}


//console.log("ID: " + getArtikelId() );

function artikelInWarenkorbLegen(){
    var artikelId = getArtikelId();
    setArtikelInWarenkorb(artikelId);
    anzahlImWarenkorbErhoehen();
}

function successAlertAnzeigen(){
    var successAlert = document.getElementById("warenkorbSuccessAlert");
    successAlert.style.display = "block";
    hideAlert(successAlert);
}

function failAlertAnzeigen(){
    var failAlert = document.getElementById("warenkorbFailAlert");
    failAlert.style.display = "block";
    hideAlert(failAlert);
}

function hideAlert(alertBox){
    setTimeout(function(){ 
        alertBox.style.display = "none";
    }, 5000);
}

//HTTP POST REQUEST
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