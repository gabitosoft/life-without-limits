/**
  @file sensor_temperatura
  
  VCC  -> (+)
  DATA -> (pin digital) 
  GND  -> (-)

  @author LWL
  @date 04/2014

*/

#include <DHT.h>  
DHT dht(2, DHT11); 

void setup()
{  
  Serial.begin(9600); 
  Serial.println(" -- iniciando dispositivo de temperatura y humedad DHT11");
  dht.begin();
}

void loop()
{
  float t = dht.readTemperature();
  if(isnan(t)) 
  {  
    Serial.println(" -- !! No data temperature received");
  } else 
  {
    Serial.print("Venus1 - temperatura: "); Serial.print(t); Serial.print(" *C\n");
  }
  
  delay(15000);// 15 secs
}
