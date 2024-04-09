#include <WiFi.h>
#include <HTTPClient.h>
#include "DHT.h"

#define DHTPIN 23
#define DHTTYPE DHT22 

DHT dht(DHTPIN,DHTTYPE);

const char * ssid="progettotemperatura"; //puntatore zona di memoria
// #define ssid "RETE_A24"
const char * wifipw="progettotemperatura";

float temperatura;
float umidita;


void setup(){
  Serial.begin(115200);
  startWifi();
  Serial.println("");
  Serial.println("WiFi connected.");
  segnale_rssi ();
  delay (5000);
  //WiFi.disconnect();
  //Serial.println("disconnesso");

  dht.begin();
}

void loop() {
  HTTPClient http;
  
  

  umidita = dht.readHumidity();
  temperatura = dht.readTemperature();

  if(isnan(umidita)|| isnan(temperatura)){
    Serial.println("Failed to read from DHT sensor!");
    return;
  }

  Serial.println("Temperatura: ");
  Serial.println(temperatura);
  Serial.println("Umidità: ");
  Serial.println(umidita);
  delay(2000);

  String servername;
  servername += F("http://10.0.3.68:5000/add?aula=mm1&valore=");
  servername += String(temperatura, 6);
  Serial.println(servername);

 
  
  http.begin(servername);
  int httpCode = http.GET();
  http.end();
  Serial.println(httpCode);

  delay(100000);
     
  
}

void  startWifi(){
  WiFi.begin(ssid, wifipw);
  Serial.println("Connecting Wifi");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
}
void  segnale_rssi(){
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  Serial.print("Wifi RSSI=");
  Serial.println(WiFi.RSSI());
}
