#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>
const char* host = "13.231.134.238";
const int httpPort = 3000;
int interval = 5000;

//const char* ssid = "AndroidHotspot4011";   // Your own ssid here
const char* ssid = "Seolgi";   // Your own ssid here
//const char* password = "1234567890999";  // Your own password here fca1zg2399
const char* password = "12345678900";  // Your own password here fca1zg2399

const int trigPin = 5; //D1
const int echoPin = 4; //D2
float duration, distance;
int period = 0, use = 0, empty = 0;


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
}

void loop(){
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance = duration*0.034/2;

  if(distance < 100) use++;
  else empty++;
  Serial.print("\nDIstance:");
  Serial.print(distance);
  Serial.println("cm\n");

  
  if(period == 10){
    period = 0;
    if(use >= empty) delivering("key=room1&field1=1");
    else delivering("key=room1&field1=0");
    use = empty = 0;
  }
  period++;
  delay(1000);
}

