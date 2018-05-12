#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>
const char* host = "13.231.134.238";
//String url = "/trigger/temp/with/key/d7_KiOg3TqkS18HjgZOVe";   // Your Own Key here
const int httpPort = 3000;
int interval = 5000;

const char* ssid = "AndroidHotspot4011";   // Your own ssid here
const char* password = "1234567890";  // Your own password here fca1zg2399

const int trigPin = 5; //D1
const int echoPin = 4; //D2
const int motion =  13; //D3
float duration, distance;
int cnt_use = 0;
int cnt_empty = 0;

void delivering(String payload)
{
  WiFiClient client;
  Serial.print("connecting to ");
  Serial.println(host);
  if (!client.connect(host, httpPort))
  {
    Serial.print("connection failed: ");
    Serial.println(payload);
    return;
  }
  String getheader = "GET /log?" + String(payload) + " HTTP/1.1";
 // String getheader = "/log?" + String(payload) + " HTTP/1.1";
  client.println(getheader);
  client.println("User-Agent: ESP8266 SukHwan Kim");
  client.println("Host: " + String(host));
  client.println("Connection: close");
  client.println();
  Serial.println(getheader);
  while (client.connected())
  {
    String line = client.readStringUntil('\n');
    Serial.println(line);
  }
  Serial.println("Done cycle.");
}
void connect_ap()
{
  Serial.println();
  Serial.print("connecting to ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(1000);
    Serial.print(".");
  }
  Serial.print("\n Got WiFi, IP address: ");
  Serial.println(WiFi.localIP());
}
 
void setup(){
  Serial.begin(9600);
  connect_ap();
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(motion, INPUT);
}

void loop(){
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance = duration*0.034/2;

  if(distance < 100) {
    cnt_use = cnt_use + 1;
  }
  else{
    cnt_empty = cnt_empty + 1;
  }

  if(cnt_use >= 10){
    Serial.println("using");
    delivering("key=kim&field1=kyuho");
    cnt_empty = 0;
  }
  else if(cnt_empty >= 10){
    Serial.println("empty");
    cnt_use = 0;
  }
 
  Serial.print("\nDIstance:");
  Serial.print(distance);
  Serial.println("cm\n");
  delay(1000);
}
